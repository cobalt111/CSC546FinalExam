import java.math.BigInteger
import java.util.*

class Game(startingPosition: Int, private val endingPosition: Int) {

    internal val board = Board(startingPosition)
    internal val solutionPath = Stack<Int>()
    internal var numberOfTotalMoves = BigInteger("0")
    private var currentPosition = startingPosition

    init {
        solutionPath.push(startingPosition)
    }

    internal fun solvableWithDepthFirstSearch(): Boolean {
        if (foundSolution()) return true
        else {
            val positionThisTurn = currentPosition
            for (direction in Direction.values()) {
                if (movable(direction)) {
                    val adjacentCellIndex = findAdjacentCellIndex(direction)
                    moveTo(adjacentCellIndex)
                    if (solvableWithDepthFirstSearch()) return true
                    else {
                        currentPosition = positionThisTurn
                        unMoveFrom(adjacentCellIndex)
                    }
                }
            }
            return false
        }
    }

    private fun foundSolution(): Boolean {
        return solutionPath.lastElement() == endingPosition && solutionPath.size == board.numberOfCells
    }

    private fun movable(direction: Direction): Boolean {
        return findAdjacentCellIndex(direction) != -1 && !board.cells[findAdjacentCellIndex(direction)].filled
    }

    private fun findAdjacentCellIndex(direction: Direction): Int {
        return board.cells[currentPosition].adjacentCellsLookup[direction]!!
    }

    private fun moveTo(index: Int) {
        currentPosition = index
        numberOfTotalMoves++
        solutionPath.push(index)
        board.cells[index].filled = true
//        if (numberOfTotalMoves.mod(BigInteger("10000000")) == BigInteger("0")) board.print()
    }

    private fun unMoveFrom(index: Int) {
        solutionPath.pop()
        board.cells[index].filled = false
    }
}