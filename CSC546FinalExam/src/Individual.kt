class Individual(private val targetString: String) {

    var chromosome: String? = null
    var fitness = 0

    init {
        val builder = StringBuilder()
        for (i in 0 until targetString.length)
            builder.append(Gene.values().random().character)

        chromosome = builder.toString()
    }

    fun mutate() {
        val numberOfMutatedGenes = (1..3).random()
        val builder = StringBuilder(chromosome)
        (1..numberOfMutatedGenes).forEach { _ ->
            val indexToChange = (0 until targetString.length).random()
            builder.replace(indexToChange, indexToChange + 1, Gene.values().random().character)
        }
        chromosome = builder.toString()
    }

    fun crossover(mate: Individual): Pair<Individual, Individual> {
        val crossoverPivot = (0 until targetString.length / 4).random()
        val crossoverEndPivot = (crossoverPivot until targetString.length / 4).random()

        val firstParentGenesToTransfer = chromosome?.substring(crossoverPivot, crossoverEndPivot)
        val secondParentGenesToTransfer = mate.chromosome?.substring(crossoverPivot, crossoverEndPivot)

        val firstOffspring = Individual(targetString)
        firstOffspring.chromosome = StringBuilder(chromosome)
            .replace(crossoverPivot, crossoverEndPivot, secondParentGenesToTransfer)
            .toString()

        val secondOffspring = Individual(targetString)
        secondOffspring.chromosome = StringBuilder(mate.chromosome)
            .replace(crossoverPivot, crossoverEndPivot, firstParentGenesToTransfer)
            .toString()

        return Pair(firstOffspring, secondOffspring)
    }

    fun calculateFitness() {
        fitness = 0
        val characterPairs = targetString.zip(chromosome!!)
        for (pair in characterPairs)
            if (pair.first == pair.second)
                fitness++
    }

    fun printFitness() {
        println("Fitness: $fitness")
    }
}