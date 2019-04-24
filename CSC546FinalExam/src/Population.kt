class Population(private val populationSize: Int, private val targetString: String) {

    var individuals = mutableListOf<Individual>()
    private val numberOfMatingParents = populationSize / 4

    init {
        (1..populationSize).forEach { _ ->
            val individual = Individual(targetString)
            individual.calculateFitness()
            individuals.add(individual)
        }
        individuals.sortByDescending { it.fitness }
    }

    fun processGeneration() {
        val selectedIndividuals = selection()
        val newGeneration = selectedIndividuals.first.toMutableList()
        newGeneration.addAll(crossover(selectedIndividuals.second).take(populationSize * 90 / 100))
        newGeneration.takeLast(populationSize * 90 / 100).forEach {
            it.mutate()
            it.calculateFitness()
        }
        newGeneration.sortByDescending { it.fitness }
        individuals = newGeneration
    }

    private fun selection(): Pair<List<Individual>, List<Pair<Individual, Individual>>> {
        val elites = individuals.take(populationSize * 10 / 100)
        val mates = individuals.take(numberOfMatingParents)
            .zip(individuals.take(numberOfMatingParents)).reversed()
        return Pair(elites, mates)
    }

    private fun crossover(mates: List<Pair<Individual, Individual>>): MutableList<Individual> {
        val matedIndividuals = mutableListOf<Individual>()
        while (matedIndividuals.size < populationSize) {
            mates.forEach { pair ->
                val newOffspring = pair.first.mate(pair.second)
                matedIndividuals.add(newOffspring.first)
                matedIndividuals.add(newOffspring.second)
            }
        }
        return matedIndividuals
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