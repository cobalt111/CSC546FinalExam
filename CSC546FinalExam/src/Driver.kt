
fun main() {
    val targetString = "This is my CSC 546 Final Exam coding portion. It is an implementation of a genetic algorithm. " +
            "It will generate the targetString. Have a great summer!"
    val populationSize = 100
    var generationCount = 0
    val population = Population(populationSize, targetString)

    while (population.individuals.first().fitness != targetString.length) {
        population.processGeneration()
        generationCount++
        if (generationCount % 100 == 0) {
            println("\nGeneration: $generationCount")
            population.printFittestIndividual()
            println("Fitness: ${population.individuals.first().fitness}")
        }
    }

    println("\nSolved.\nNumber of generations: $generationCount\n")
    population.printFittestIndividual()
    population.printPopulationFitness()
}