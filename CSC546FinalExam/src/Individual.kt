class Individual(private val targetString: String) {

    var chromosome: String? = null
    var fitness = 0

    init {
        val builder = StringBuilder()
        targetString.indices.forEach { _ -> builder.append(Gene.values().random().character) }
        chromosome = builder.toString()
    }

    fun calculateFitness() {
        fitness = 0
        val alignedCharacters = targetString.zip(chromosome!!)
        alignedCharacters.forEach { pair ->
            if (pair.first == pair.second)
                fitness++
        }
    }

    fun mate(mate: Individual): Pair<Individual, Individual> {
        val crossoverStartPivot = (targetString.indices - 1).random()
        val crossoverEndPivot = (crossoverStartPivot until targetString.length).random()

        val firstParentGenesToTransfer = chromosome?.substring(crossoverStartPivot, crossoverEndPivot)
        val secondParentGenesToTransfer = mate.chromosome?.substring(crossoverStartPivot, crossoverEndPivot)

        val firstOffspring = Individual(targetString)
        firstOffspring.chromosome = StringBuilder(chromosome)
            .replace(crossoverStartPivot, crossoverEndPivot, secondParentGenesToTransfer)
            .toString()

        val secondOffspring = Individual(targetString)
        secondOffspring.chromosome = StringBuilder(mate.chromosome)
            .replace(crossoverStartPivot, crossoverEndPivot, firstParentGenesToTransfer)
            .toString()

        return Pair(firstOffspring, secondOffspring)
    }

    fun mutate() {
        val numberOfGenesToMutate = (1..3).random()
        val builder = StringBuilder(chromosome)
        (1..numberOfGenesToMutate).forEach { _ ->
            val indexToChange = targetString.indices.random()
            builder.replace(indexToChange, indexToChange + 1, Gene.values().random().character)
        }
        chromosome = builder.toString()
    }


    fun printFitness() {
        println("Fitness: $fitness")
    }
}