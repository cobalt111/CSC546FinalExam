import java.util.*

class Game(initialBoardState: MutableList<Slot>) {

    val boardList = Stack<MutableList<Slot>>()
    var numberOfPegs = 14
    var numberOfBoardsCreated = 1
    var numberOfCorrectBoards = 1

    init {
        boardList.push(initialBoardState)
    }

    fun solveWithDFS(board: MutableList<Slot>): Boolean {
        if (numberOfPegs == 1) return true
        else {
            // for every slot on the board
            for (slotNumber in IntRange(0, 14)) {
                // if filled with a peg
                if (board[slotNumber].isFilled()) {
                    // for every jumpable direction from the current slot
                    for (direction in IntRange(0, 5)) {
                        // if there is a valid adjacent slot
                        if (board[slotNumber].adjacencyLookup[direction] != -1)
                            // if the adjacent slot has a peg in it
                            if (board[board[slotNumber].adjacencyLookup[direction]!!].isFilled())
                                // if the adjacent slot has another peg on the other side of it
                                if (board[board[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!! != -1)
                                    // if the slot on the other side of that peg is empty, i.e. a legal jump
                                    if (!board[board[board[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!!].isFilled()) {
                                        // this is a legal jump, so process it
                                        numberOfBoardsCreated++
                                        numberOfCorrectBoards++
                                        numberOfPegs--
                                        board[board[board[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!!].filled = true
                                        board[board[slotNumber].adjacencyLookup[direction]!!].filled = false
                                        board[slotNumber].filled = false
                                        boardList.push(board)
                                        print(board)
                                        // recursive call on the new board state
                                        if (solveWithDFS(board)) return true
                                        else {
                                            // the new board state was unsolvable, so undo the jump, pop the board,
                                            // and try the next jump on the next loop iteration
                                            numberOfCorrectBoards--
                                            numberOfPegs++
                                            board[board[board[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!!].filled = false
                                            board[board[slotNumber].adjacencyLookup[direction]!!].filled = true
                                            board[slotNumber].filled = true
                                            boardList.pop()
                                            println("\nNo solution found in this branch, moving back up the tree...")
                                            print(board)
                                        }
                                    }

                    }
                }
            }
            // if nothing worked, close this recursive branch
            return false
        }
    }

    fun solveWithBFS(board: MutableList<Slot>): Boolean {
        if (numberOfPegs == 1) return true
        else {
            // for every slot on the board
            for (slotNumber in IntRange(0, 14)) {
                // if filled with a peg
                if (board[slotNumber].isFilled()) {
                    // for every jumpable direction from the current slot
                    for (direction in IntRange(0, 5)) {
                        // if there is a valid adjacent slot
                        if (board[slotNumber].adjacencyLookup[direction] != -1)
                        // if the adjacent slot has a peg in it
                            if (board[board[slotNumber].adjacencyLookup[direction]!!].isFilled())
                            // if the adjacent slot has another peg on the other side of it
                                if (board[board[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!! != -1)
                                // if the slot on the other side of that peg is empty, i.e. a legal jump
                                    if (!board[board[board[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!!].isFilled()) {                                        boardList.push(board)
                                        // this is a legal jump, so process it
                                        numberOfBoardsCreated++
                                        numberOfCorrectBoards++
                                        numberOfPegs--
                                        board[board[board[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!!].filled = true
                                        board[board[slotNumber].adjacencyLookup[direction]!!].filled = false
                                        board[slotNumber].filled = false
                                        boardList.push(board)
                                        print(board)
                                        // recursive call on the new board state
                                        if (solveWithDFS(board)) return true
                                        else {
                                            // the new board state was unsolvable, so undo the jump, pop the board,
                                            // and try the next jump on the next loop iteration
                                            numberOfCorrectBoards--
                                            numberOfPegs++
                                            board[board[board[slotNumber].adjacencyLookup[direction]!!].adjacencyLookup[direction]!!].filled = false
                                            board[board[slotNumber].adjacencyLookup[direction]!!].filled = true
                                            board[slotNumber].filled = true
                                            boardList.pop()
                                            println("\nNo solution found in this branch, moving back up the tree...")
                                            print(board)
                                        }
                                    }

                    }
                }
            }
            // if nothing worked, close this recursive branch
            return false
        }
    }

    fun print(board: MutableList<Slot>) {
        println("\n------------")
        var firstSlot = if (board[0].isFilled()) 1 else 0
        println("    $firstSlot    ")
        firstSlot = if (board[1].isFilled()) 1 else 0
        var secondSlot = if (board[2].isFilled()) 1 else 0
        println("   $firstSlot $secondSlot   ")
        firstSlot = if (board[3].isFilled()) 1 else 0
        secondSlot = if (board[4].isFilled()) 1 else 0
        var thirdSlot = if (board[5].isFilled()) 1 else 0
        println("  $firstSlot $secondSlot $thirdSlot  ")
        firstSlot = if (board[6].isFilled()) 1 else 0
        secondSlot = if (board[7].isFilled()) 1 else 0
        thirdSlot = if (board[8].isFilled()) 1 else 0
        var fourthSlot = if (board[9].isFilled()) 1 else 0
        println(" $firstSlot $secondSlot $thirdSlot $fourthSlot ")
        firstSlot = if (board[10].isFilled()) 1 else 0
        secondSlot = if (board[11].isFilled()) 1 else 0
        thirdSlot = if (board[12].isFilled()) 1 else 0
        fourthSlot = if (board[13].isFilled()) 1 else 0
        var fifthSlot = if (board[14].isFilled()) 1 else 0
        println("$firstSlot $secondSlot $thirdSlot $fourthSlot $fifthSlot")
        println()
        println("Pegs: $numberOfPegs")
        println("------------")
    }
}