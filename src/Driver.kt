fun main() {
    for (k in 1..7) {
//        Thread {
            val game = Game(0, k)

            if (game.solvableWithDepthFirstSearch()) {
                println("Solved")
                println("Goal index = $k")
                for (i in 0 until game.solutionPath.size)
                    print("${game.solutionPath[i]}" + if (i != game.solutionPath.size - 1) " -> " else "")
                println("\nMoves: ${game.numberOfTotalMoves}")
                println()
            }
            else
                println("Unsolvable")
//        }.start()
    }
}