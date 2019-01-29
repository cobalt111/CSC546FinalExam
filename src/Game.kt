import java.util.*

class Game(initialBoardState: Board) {

    var boardList = Stack<Board>()
    var numberOfPegs = 14
    var numberOfBoardsCreated = 1
    var numberOfCorrectBoards = 1

    init {
        boardList.push(initialBoardState.copy(initialBoardState.slots))
    }

    fun solvableWithDepthFirstSearch(board: Board): Boolean {
        if (numberOfPegs == 1) return true
        else {
            for (slotNumber in IntRange(0, 14)) {
                if (board.slots[slotNumber].hasPeg()) {
                    for (direction in IntRange(0, 5)) {
                        if (jumpable(board, board.slots[slotNumber], direction)) {
                            jump(board, slotNumber, direction)
                            if (solvableWithDepthFirstSearch(board)) return true
                            else undoJump(board, slotNumber, direction)
                        }
                    }
                }
            }
            return false
        }
    }

//    fun solvableWithBreadthFirstSearch(board: MutableList<Slot>): Boolean {
//        if (numberOfPegs == 1) return true
//        else {
//            for (searchDepth in IntRange(1, 14)) {
//                for (slotNumber in IntRange(0, 14)) {
//                    if (board.slots[slotNumber].hasPeg()) {
//                        for (direction in IntRange(0, 5)) {
//                            if (jumpable(board, board.slots[slotNumber], direction)) {
//                                jump(board, slotNumber, direction)
//                                if (numberOfPegs == 1) return true
//                                else undoJump(board, slotNumber, direction)
//                            }
//                        }
//                    }
//                }
//                for (slotNumber in IntRange(0, 14))
//            }
//
//            if (searchDepth <= maxSearchDepth) {
//                searchDepth++
//                solvableWithBreadthFirstSearch(board)
//            }
//            return false
//        }
//    }

    private fun jump(board: Board, slotNumber: Int, direction: Int) {
        numberOfBoardsCreated++
        numberOfCorrectBoards++
        numberOfPegs--
        // Slot to move peg into
        board.slots[board.slots[board.slots[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!!].filled = true
        // Middle slot to remove peg from
        board.slots[board.slots[slotNumber].adjacencyLookup[direction]!!].filled = false
        // Slot where the jumping peg came from
        board.slots[slotNumber].filled = false
        boardList.push(board.copy(board.slots))
        print(board)
    }

    private fun undoJump(board: Board, slotNumber: Int, direction: Int) {
        numberOfCorrectBoards--
        numberOfPegs++
        board.slots[board.slots[board.slots[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!!].filled = false
        board.slots[board.slots[slotNumber].adjacencyLookup[direction]!!].filled = true
        board.slots[slotNumber].filled = true
        boardList.pop()
        println("\nNo solution found in this branch, moving back up the tree...")
        print(board)
    }

    private fun jumpable(board: Board, currentSlot: Slot, direction: Int): Boolean {
        return currentSlot.adjacencyLookup[direction] != -1
                && board.slots[currentSlot.adjacencyLookup[direction]!!].adjacencyLookup[direction] != -1
                && board.slots[currentSlot.adjacencyLookup[direction]!!].hasPeg()
                && !board.slots[board.slots[currentSlot.adjacencyLookup[direction]!!].adjacencyLookup[direction]!!].hasPeg()
    }

    fun print(board: Board) {
        println("\n------------")
        var firstSlot = if (board.slots[0].hasPeg()) 1 else 0
        println("    $firstSlot    ")
        firstSlot = if (board.slots[1].hasPeg()) 1 else 0
        var secondSlot = if (board.slots[2].hasPeg()) 1 else 0
        println("   $firstSlot $secondSlot   ")
        firstSlot = if (board.slots[3].hasPeg()) 1 else 0
        secondSlot = if (board.slots[4].hasPeg()) 1 else 0
        var thirdSlot = if (board.slots[5].hasPeg()) 1 else 0
        println("  $firstSlot $secondSlot $thirdSlot  ")
        firstSlot = if (board.slots[6].hasPeg()) 1 else 0
        secondSlot = if (board.slots[7].hasPeg()) 1 else 0
        thirdSlot = if (board.slots[8].hasPeg()) 1 else 0
        var fourthSlot = if (board.slots[9].hasPeg()) 1 else 0
        println(" $firstSlot $secondSlot $thirdSlot $fourthSlot ")
        firstSlot = if (board.slots[10].hasPeg()) 1 else 0
        secondSlot = if (board.slots[11].hasPeg()) 1 else 0
        thirdSlot = if (board.slots[12].hasPeg()) 1 else 0
        fourthSlot = if (board.slots[13].hasPeg()) 1 else 0
        val fifthSlot = if (board.slots[14].hasPeg()) 1 else 0
        println("$firstSlot $secondSlot $thirdSlot $fourthSlot $fifthSlot")
        println()
        println("Pegs: $numberOfPegs")
        println("------------")
    }
}