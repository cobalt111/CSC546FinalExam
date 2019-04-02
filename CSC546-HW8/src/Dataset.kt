class Dataset(private val data: List<Coordinate>) {

    private var clusters = hashMapOf<Int, Cluster>()

    internal fun createClustersAndCentroids() {
        allocatePointsToCentroids()
        for (cluster in clusters)
            cluster.value.update()
    }

    private fun allocatePointsToCentroids() {
        val listOfTypes = mutableListOf<Int>()
        for (point in data) {
            if (!listOfTypes.contains(point.type)) {
                clusters[point.type] = Cluster()
                listOfTypes.add(point.type)
            }
            clusters[point.type]!!.data.add(point)
        }
    }

    internal fun decideClass(point: Coordinate): Int {
        var highestProbabilityMean = Double.MIN_VALUE
        var predictedCluster = 1
        for (i in 1..2) {
            val probabilityX = gaussFunction(point.x, clusters[i]?.centroid?.x, clusters[i]?.standardDeviations?.first)
            val probabilityY = gaussFunction(point.y, clusters[i]?.centroid?.y, clusters[i]?.standardDeviations?.second)

            val probabilityMean = (probabilityX + probabilityY) / 2

            if (probabilityMean > highestProbabilityMean) {
                highestProbabilityMean = probabilityMean
                predictedCluster = i
            }
        }
        return predictedCluster
    }

    private fun gaussFunction(point: Double, mean: Double?, standardDeviation: Double?): Double {
        return (Math.exp(-(Math.pow(point - mean!!, 2.0)) / (2 * Math.pow(standardDeviation!!, 2.0)))) / (standardDeviation * Math.sqrt(2 * Math.PI))
    }
}