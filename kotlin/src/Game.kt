import java.math.BigInteger
import java.util.*

class Game(private val startingPosition: Int, private val endingPosition: Int) {

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
                    if (solutionPath.size < board.numberOfCells - 1) {
                        if (adjacentCellIndex != endingPosition) {
                            currentPosition = adjacentCellIndex
                            moveTo(adjacentCellIndex)
                            if (solvableWithDepthFirstSearch()) return true
                            else {
                                currentPosition = positionThisTurn
                                unMoveFrom(adjacentCellIndex)
                            }
                        }
                    }
                    else if (solutionPath.size == board.numberOfCells - 1 && adjacentCellIndex == endingPosition) {
                        currentPosition = adjacentCellIndex
                        moveTo(adjacentCellIndex)
                        return true
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
        numberOfTotalMoves++
        solutionPath.push(index)
        board.cells[index].filled = true
        if (numberOfTotalMoves.mod(BigInteger("100000000")) == BigInteger("0")) {
            println("\nStart: $startingPosition")
            println("Goal: $endingPosition")
            println("Moves: $numberOfTotalMoves")
        }
    }

    private fun unMoveFrom(index: Int) {
        solutionPath.pop()
        board.cells[index].filled = false
    }
}