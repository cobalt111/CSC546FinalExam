fun main() {
    val board = mutableListOf<Slot>()
    for (i in IntRange(0, 14))
        board.add(Slot(true, i))

    // change the board index here to change the start position
    board[1].filled = false

    val gameboard = Game(board)
    gameboard.print(board)
    if (gameboard.solveWithDFS(board)) {
        println()
        println("Checked ${gameboard.numberOfBoardsCreated} jumps.\nSolution requires ${gameboard.numberOfCorrectBoards} jumps.")
//        println("\nSolution:")
//        for (i in gameboard.boardList.indices) {
//            gameboard.print(gameboard.boardList[i])
//        }
    }
}