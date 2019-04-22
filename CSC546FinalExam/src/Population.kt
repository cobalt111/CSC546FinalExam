class Population(private val populationSize: Int, private val targetString: String) {

    var individuals = mutableListOf<Individual>()
    private val numberOfSurvivingParents = populationSize / 4

    init {
        (1..populationSize).forEach { _ ->
            val individual = Individual(targetString)
            individual.calculateFitness()
            individuals.add(individual)
        }
        individuals.sortByDescending { it.fitness }
    }

    fun processGeneration() {
        val newGeneration = mutableListOf<Individual>()
        val elites = individuals.take(populationSize * 10 / 100)
        newGeneration.addAll(elites)

        val mates = individuals.take(numberOfSurvivingParents)
            .zip(individuals.takeLast(numberOfSurvivingParents))

        while (newGeneration.size < populationSize) {
            mates.forEach { pair ->
                val newOffspring = pair.first.crossover(pair.second)
                newGeneration.add(newOffspring.first)
                newGeneration.add(newOffspring.second)
            }
        }

        individuals = newGeneration.take(populationSize).toMutableList()
        individuals.takeLast(populationSize * 90 / 100).forEach {
            it.mutate()
            it.calculateFitness()
        }
        individuals.sortByDescending { it.fitness }
    }

    fun printFittestIndividual() {
        println("Fittest Individual:")
        println("${individuals.first().chromosome}")
    }

    fun printPopulationFitness() {
        println("Fitness of population:")
        individuals.forEach { it.printFitness() }
    }
}