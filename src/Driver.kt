/*  Slot numbers are defined as such:

                 0
               1   2
             3   4   5
           6   7   8   9
         10  11  12  14  15

    Change initialEmptySlotNumber to change where the empty slot is on the board.
*/

fun main() {
    val initialEmptySlotNumber = 0

    val game = Game(Board(initialEmptySlotNumber, null))
    game.board.print()

    if (game.solvableWithDepthFirstSearch()) {
        game.printSolution()
    }
}