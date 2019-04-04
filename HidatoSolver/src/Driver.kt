
fun main() {
//    val numberOfCells = readLine()!!.toInt()
//    var i = 0
//    var validNumber = true
//    while (i < numberOfCells) {
//        i += i + 6
//        if (i == numberOfCells) {
//            validNumber = true
//            break
//        }
//        else if (i > numberOfCells) {
//            validNumber = false
//            println("Not a valid Hidato cells cell number, exiting...")
//        }
//    }
//
//    if (validNumber) {
//
//    }


    Thread {
        val game = Game(32, 36)

        if (game.solvableWithDepthFirstSearch(1, 32))
            println("Solved")
        else
            println("Unsolvable")
    }.start()

    Thread {
        val game = Game(9, 10)

        if (game.solvableWithDepthFirstSearch(1, 9))
            println("Solved")
        else
            println("Unsolvable")
    }.start()

    Thread {
        val game = Game(0, 1)

        if (game.solvableWithDepthFirstSearch(1, 0))
            println("Solved")
        else
            println("Unsolvable")
    }.start()

    Thread {
        val game = Game(28, 33)

        if (game.solvableWithDepthFirstSearch(1, 28))
            println("Solved")
        else
            println("Unsolvable")
    }.start()

    Thread {
        val game = Game(2, 3)

        if (game.solvableWithDepthFirstSearch(1, 2))
            println("Solved")
        else
            println("Unsolvable")
    }.start()

    Thread {
        val game = Game(14, 21)

        if (game.solvableWithDepthFirstSearch(1, 14))
            println("Solved")
        else
            println("Unsolvable")
    }.start()

    Thread {
        val game = Game(18, 19)

        if (game.solvableWithDepthFirstSearch(1, 18))
            println("Solved")
        else
            println("Unsolvable")
    }.start()

    Thread {
        val game = Game(5, 6)

        if (game.solvableWithDepthFirstSearch(1, 5))
            println("Solved")
        else
            println("Unsolvable")
    }.start()
}