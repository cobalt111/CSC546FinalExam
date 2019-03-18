import Coordinate.Calculator.distance

class Dataset(private var data: ArrayList<Coordinate>, private val k: Int, private val isTwoDimensional: Boolean) {

    internal var centroids = mutableListOf<Centroid>()

    init {
        // Randomize the initial starting point of k centroids, with no repeat centroids
        var point: Coordinate
        val usedPoints = mutableListOf<Coordinate>()
        for (i in 1..k) {
            point = randomPoint()
            while (usedPoints.contains(point))
                point = randomPoint()
            usedPoints.add(point)
            centroids.add(Centroid(point))
        }
    }

    private fun randomPoint(): Coordinate {
        return data[(0 until data.size).random()]
    }

    fun updateCentroidMeans() {
        allocatePointsToCentroids()
        for (centroid in centroids)
            centroid.updateCoordinate()
    }

    private fun allocatePointsToCentroids() {
        for (centroid in centroids)
            centroid.flushClosestPoints()
        var currentDistance: Double
        var lowestDistance: Double
        var parentCentroid = centroids[0]
        for (point in data) {
            lowestDistance = Double.MAX_VALUE
            for (centroid in centroids) {
                currentDistance = distance(point, centroid.coordinate, isTwoDimensional)
                if (currentDistance < lowestDistance) {
                    lowestDistance = currentDistance
                    parentCentroid = centroid
                }
            }
            parentCentroid.closestDataPoints.add(point)
        }
    }
}