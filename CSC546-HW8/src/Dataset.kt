class Dataset(internal val data: List<Coordinate>) {

    internal var clusters = hashMapOf<Int, Cluster>()

    internal fun updateCentroids() {
        allocatePointsToCentroids()
        for (cluster in clusters)
            cluster.value.update()
    }

    private fun allocatePointsToCentroids() {
        val listOfTypes = mutableListOf<Int>()
        for (point in data) {
            if (!listOfTypes.contains(point.type)) {
                clusters[point.type] = Cluster(Coordinate(0.0, 0.0, point.type))
                listOfTypes.add(point.type)
            }
            clusters[point.type]!!.data.add(point)
        }
    }

    internal fun decideClass(point: Coordinate): Int {
        var highestProbabilityMean = Double.MIN_VALUE
        var predictedCluster = 1
        for (cluster in 1..2) {
            val currentProbabilityX = gaussFunction(point.x, clusters[cluster]!!.centroidCoordinate.x, clusters[cluster]!!.standardDeviations.first)
            val currentProbabilityY = gaussFunction(point.y, clusters[cluster]!!.centroidCoordinate.y, clusters[cluster]!!.standardDeviations.second)
            val currentProbabilityMean = (currentProbabilityX + currentProbabilityY) / 2
            if (currentProbabilityMean > highestProbabilityMean) {
                highestProbabilityMean = currentProbabilityMean
                predictedCluster = cluster
            }
        }
        return predictedCluster
    }

    private fun gaussFunction(point: Double, mean: Double, standardDeviation: Double): Double {
        return (Math.exp(-(Math.pow(point - mean, 2.0)) / (2 * Math.pow(standardDeviation, 2.0)))) / (standardDeviation * Math.sqrt(2 * Math.PI))
    }
}