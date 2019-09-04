fun main() {
    val populationSize = 100
    var generationCount = 0
    val targetString = "This is my CSC 546 Final Exam coding portion. It is an implementation of a genetic algorithm. " +
            "It will generate the targetString from a population of $populationSize randomized strings. Have a great summer!"
    val population = Population(populationSize, targetString)

    println("\nStarting genetic algorithm...\n")
    println("Example initial individual:\n${population.individuals.first().chromosome}")
    population.individuals.first().printFitness()

    while (population.individuals.first().fitness != targetString.length) {
        population.processGeneration()
        generationCount++
        if (generationCount % 500 == 0) {
            println("\nGeneration: $generationCount")
            population.printFittestIndividual()
            println("Fitness: ${population.individuals.first().fitness}")
        }
    }

    println("\nSolved.\nNumber of generations: $generationCount")
    population.printFittestIndividual()
    population.printPopulationFitness()
    println("\nExiting...")
}