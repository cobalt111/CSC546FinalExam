// Main driver function for the program
fun main() {
    // Check for every possible start node
//    for (y in 0..36) {
        // Check for every possible goal node
//        for (q in 0..36) {
            // So long as the start node does not equal the goal node (this is against the rules)
//            if (y != q)
                // Create a thread of the current game and try to solve it
    val y = 0
    val q = 36
                Thread {
                    val game = Game(y, q)
                    if (game.solvableWithDepthFirstSearch()) {
                        println("\nSolved")
                        println("Start index = $y")
                        println("Goal index = $q")
                        for (t in 0 until game.solutionPath.size)
                            print("${game.solutionPath[t]}" + if (t != game.solutionPath.size - 1) " -> " else "\n")
                        println("Moves: ${game.numberOfTotalMoves}\n")
                    } else
                        println("Unsolvable")
                }.start()
//        }
//    }
}