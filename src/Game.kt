import java.util.*

class Game(initialBoardState: Board) {

    var boardList = Stack<Board>()
    var board = initialBoardState
    var numberOfPegs = 14
    var totalNumberOfJumps = 1
    var numberOfCorrectBoards = 1
    private val initialEmptySlotNumber = initialBoardState.initialEmptySlotNumber


    init {
        boardList.push(initialBoardState)
    }

    fun solvableWithDepthFirstSearch(): Boolean {
        if (foundSolution()) return true
        else {
            for (slot in board.slots) {
                if (slot.hasPeg()) {
                    for (direction in Direction.values()) {
                        if (jumpable(slot, direction)) {
                            jump(slot, direction)
                            if (solvableWithDepthFirstSearch()) return true
                            else undoJump(slot, direction)
                        }
                    }
                }
            }
            return false
        }
    }

    private fun foundSolution(): Boolean {
        return (numberOfPegs == 1 && board.slots[initialEmptySlotNumber!!].hasPeg())
    }

    private fun jump(originSlot: Slot, direction: Direction) {
        totalNumberOfJumps++
        numberOfCorrectBoards++
        numberOfPegs--
        // Slot to move peg into
        board.slots[board.slots[originSlot.adjacentSlotNumbers[direction]!!].adjacentSlotNumbers[direction]!!].filled = true
        // Middle Slot to remove peg from
        board.slots[originSlot.adjacentSlotNumbers[direction]!!].filled = false
        // Slot where the jumping peg came from
        originSlot.filled = false
        boardList.push(Board(null, board))
        board.print()
    }

    private fun undoJump(originSlot: Slot, direction: Direction) {
        numberOfCorrectBoards--
        numberOfPegs++
        board.slots[board.slots[originSlot.adjacentSlotNumbers[direction]!!].adjacentSlotNumbers[direction]!!].filled = false
        board.slots[originSlot.adjacentSlotNumbers[direction]!!].filled = true
        originSlot.filled = true
        boardList.pop()
        println("\nNo solution found in this branch, moving back up the tree...")
        board.print()
    }

    private fun jumpable(currentSlot: Slot, direction: Direction): Boolean {
        return currentSlot.adjacentSlotNumbers[direction] != -1
                && board.slots[currentSlot.adjacentSlotNumbers[direction]!!].adjacentSlotNumbers[direction] != -1
                && board.slots[currentSlot.adjacentSlotNumbers[direction]!!].hasPeg()
                && !board.slots[board.slots[currentSlot.adjacentSlotNumbers[direction]!!].adjacentSlotNumbers[direction]!!].hasPeg()
    }

    fun printSolution() {
        println("\nChecked $totalNumberOfJumps jumps.\nSolution requires ${numberOfCorrectBoards - 1} jumps.\n\nSolution:")
        var pegCount = 14
        for (currentBoard in boardList) {
            currentBoard.print()
            println("Pegs: $pegCount")
            pegCount--
        }
        println("\nSolved")
    }
}