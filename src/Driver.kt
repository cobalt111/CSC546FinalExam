fun main() {
    // Change this number here to change where the empty slot is on the board.
    val initialEmptySlotNumber = 0
    val initializer = mutableListOf<Slot>()
    for (i in IntRange(0, 14))
        initializer.add(i, Slot(true, i))
    initializer[initialEmptySlotNumber].filled = false

    val initialBoard = Board(initializer)
    val gameboard = Game(initialBoard)
    gameboard.print(initialBoard)

    if (gameboard.solvableWithDepthFirstSearch(initialBoard, initialEmptySlotNumber)) {
        println("\nChecked ${gameboard.numberOfBoardsCreated} jumps.\nSolution requires ${gameboard.numberOfCorrectBoards - 1} jumps.")
        println("\nSolution:")
        gameboard.numberOfPegs = 14
        for (i in gameboard.boardList.indices) {
            gameboard.print(gameboard.boardList[i])
            gameboard.numberOfPegs--
        }
    }
}