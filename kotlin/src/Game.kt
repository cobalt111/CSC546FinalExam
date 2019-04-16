import java.math.BigInteger
import java.util.*

class Game(private val startingPositionIndex: Int, private val endingPositionIndex: Int) {

    // Board is the current board state of the game.
    internal val board = Board(startingPositionIndex)

    // solutionPath is a stack that tracks the path taken to the solution
    internal val solutionPath = Stack<Int>()

    // numberOfTotalMoves tracks the number of states the program checks in the state space before finding the solution
    internal var numberOfTotalMoves = BigInteger("0")

    // currentPositionIndex is used to help keep track of where the player currently is on the board
    private var currentPositionIndex = startingPositionIndex

    init {
        // push the beginning node onto the solutionPath at the start of the game
        solutionPath.push(startingPositionIndex)
    }

    // This is the function that has the recursive depth first search algorithm that solves the game
    internal fun solvableWithDepthFirstSearch(): Boolean {
        // First check if the game has been solved by moving to the current node
        if (foundSolution()) return true
        else {
            // Save the current position this turn in case we need to undo moves to come back to it later
            val positionThisTurn = currentPositionIndex
            // For every direction from the current node
            for (direction in Direction.values()) {
                // If the direction is legally movable by the games rules (empty and not a wall)
                if (movable(direction)) {
                    // Find the adjacent empty node's index
                    val adjacentCellIndex = findAdjacentCellIndex(direction)
                    // If this adjacent empty node is not the penultimate node in the solution path
                    if (solutionPath.size < board.numberOfCells - 1) {
                        // If the adjacent empty node is not the solution node
                        if (adjacentCellIndex != endingPositionIndex) {
                            // Make the saved current cell that node
                            currentPositionIndex = adjacentCellIndex
                            // Change the board to reflect our move
                            moveTo(adjacentCellIndex)
                            // Recursively call the depth first search algorithm on the new board state
                            if (solvableWithDepthFirstSearch())
                                return true
                            // If we reached a dead end under that node
                            else {
                                // Move the current saved position back to the position saved this turn
                                currentPositionIndex = positionThisTurn
                                // Change the board to reflect this board state
                                unMoveFrom(adjacentCellIndex)
                            }
                        }
                    }
                    // Check if we have every other cell on the board in our path other than the goal
                    // and see if we can move to it
                    else if (solutionPath.size == board.numberOfCells - 1 && adjacentCellIndex == endingPositionIndex) {
                        // Make the saved current cell that node
                        currentPositionIndex = adjacentCellIndex
                        // If we reached a dead end under that node
                        moveTo(adjacentCellIndex)
                        return true
                    }
                }
            }
            return false
        }
    }

    // foundSolution() checks to see if the current solutionPath has the goal node at its very end, and that its
    // size is the number of cells on the board.
    private fun foundSolution(): Boolean {
        return solutionPath.lastElement() == endingPositionIndex && solutionPath.size == board.numberOfCells
    }

    // movable() checks to see if the current direction from the current position on the board is movable
    private fun movable(direction: Direction): Boolean {
        return findAdjacentCellIndex(direction) != -1 && !board.cells[findAdjacentCellIndex(direction)].filled
    }

    // findAdjacentCellIndex() returns the index of the cell in a certain direction from the current cell
    private fun findAdjacentCellIndex(direction: Direction): Int {
        return board.cells[currentPositionIndex].adjacentCellsLookup[direction]!!
    }

    // moveTo() procoess a move to a certain cell on the board by adding it to the solutionPath and incrementing
    // the total number of moves
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

    // unMoveFrom() processes undoing a move from a certain cell
    private fun unMoveFrom(index: Int) {
        solutionPath.pop()
        board.cells[index].filled = false
    }
}