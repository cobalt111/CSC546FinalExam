fun main() {
    val initializer = mutableListOf<Slot>()
    for (i in IntRange(0, 14))
        initializer.add(i, Slot(true, i))
    initializer[0].filled = false

    val initialBoard = Board(initializer)

    val gameboard = Game(initialBoard)
    gameboard.print(initialBoard)
    if (gameboard.solvableWithDepthFirstSearch(initialBoard)) {
        println()
        println("Checked ${gameboard.numberOfBoardsCreated} jumps.\nSolution requires ${gameboard.numberOfCorrectBoards - 1} jumps.")
        println("\nSolution:")
        for (i in gameboard.boardList.indices) {
            gameboard.print(gameboard.boardList[i])
        }
    }
}