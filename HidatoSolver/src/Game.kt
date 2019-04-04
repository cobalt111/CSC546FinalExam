import java.util.*

class Game(internal val startingPosition: Int, internal val endingPosition: Int) {

    internal val board = Board(startingPosition, endingPosition)
    internal val solutionPath = Stack<Int>()

    init {
        solutionPath.push(startingPosition)
    }

    internal fun solvableWithDepthFirstSearch(counter: Int, currentPosition: Int): Boolean {
        if (foundSolution())
            return true
        else {
            for (direction in Direction.values()) {
                val currentAdjacentCellIndex = board.cells[currentPosition].adjacentCellsLookup[direction]!!
                if (currentAdjacentCellIndex != -1 && board.cells[currentAdjacentCellIndex].number == 0) {
                    move(counter, currentAdjacentCellIndex)
                    if (solvableWithDepthFirstSearch(counter + 1, currentAdjacentCellIndex))
                        return true
                    else unMove(currentAdjacentCellIndex)
                }
            }
            return false
        }
    }

    private fun foundSolution(): Boolean {
        val remainingCells = board.cells.toMutableList()
        var counter = 1
        for (index in solutionPath) {
            if (board.cells[index].number != counter)
                return false
            else {
                remainingCells.remove(board.cells[index])
                counter++
            }
        }
        return remainingCells.isEmpty()
    }

    private fun move(counter: Int, index: Int) {
        solutionPath.push(index)
        board.cells[index].number = counter
//        board.print()
    }

    private fun unMove(index: Int) {
        solutionPath.pop()
        board.cells[index].number = 0
//        board.print()
    }
}