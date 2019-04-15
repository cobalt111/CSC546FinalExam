import java.math.BigInteger
import java.util.*

class Game(private val startingPositionIndex: Int, private val endingPositionIndex: Int) {

    internal val board = Board(startingPositionIndex)
    internal val solutionPath = Stack<Int>()
    internal var numberOfTotalMoves = BigInteger("0")
    private var currentPositionIndex = startingPositionIndex

    init {
        solutionPath.push(startingPositionIndex)
    }

    internal fun solvableWithDepthFirstSearch(): Boolean {
        if (foundSolution()) return true
        else {
            val positionThisTurn = currentPositionIndex
            for (direction in Direction.values()) {
                if (movable(direction)) {
                    val adjacentCellIndex = findAdjacentCellIndex(direction)
                    if (solutionPath.size < board.numberOfCells - 1) {
                        if (adjacentCellIndex != endingPositionIndex) {
                            currentPositionIndex = adjacentCellIndex
                            moveTo(adjacentCellIndex)
                            if (solvableWithDepthFirstSearch()) return true
                            else {
                                currentPositionIndex = positionThisTurn
                                unMoveFrom(adjacentCellIndex)
                            }
                        }
                    }
                    // Check if we have every other cell on the board in our path other than the goal
                    // and see if we can move to it
                    else if (solutionPath.size == board.numberOfCells - 1 && adjacentCellIndex == endingPositionIndex) {
                        currentPositionIndex = adjacentCellIndex
                        moveTo(adjacentCellIndex)
                        return true
                    }
                }
            }
            return false
        }
    }


    private fun foundSolution(): Boolean {
        return solutionPath.lastElement() == endingPositionIndex && solutionPath.size == board.numberOfCells
    }

    private fun movable(direction: Direction): Boolean {
        return findAdjacentCellIndex(direction) != -1 && !board.cells[findAdjacentCellIndex(direction)].filled
    }

    private fun findAdjacentCellIndex(direction: Direction): Int {
        return board.cells[currentPositionIndex].adjacentCellsLookup[direction]!!
    }

    private fun moveTo(index: Int) {
        numberOfTotalMoves++
        solutionPath.push(index)
        board.cells[index].filled = true
        if (numberOfTotalMoves.mod(BigInteger("100000000")) == BigInteger("0")) {
            println("\nStart: $startingPositionIndex")
            println("Goal: $endingPositionIndex")
            println("Moves: $numberOfTotalMoves")
        }
    }

    private fun unMoveFrom(index: Int) {
        solutionPath.pop()
        board.cells[index].filled = false
    }
}