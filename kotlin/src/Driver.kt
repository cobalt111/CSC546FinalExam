fun main() {
    var solutionFound = false
    val i = 0
    val k = 15
    for (q in 1..6) {
        Thread {
            val game = Game(0, k)

            if (game.solvableWithDepthFirstSearch()) {
                solutionFound = true
                println("\nSolved")
                println("Start index = $i")
                println("Goal index = $k")
                for (t in 0 until game.solutionPath.size)
                    print("${game.solutionPath[t]}" + if (t != game.solutionPath.size - 1) " -> " else "\n")
                println("Moves: ${game.numberOfTotalMoves}\n")
            }
            else
                println("Unsolvable")
        }.start()
    }

}