fun main() {
    for (k in 0..36) {
        for (i in 0..36) {
            if (i != k) {
                Thread {
                    val game = Game(i, k)

                    if (game.solvableWithDepthFirstSearch()) {
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
    }
}