import java.lang.Math.pow

class Dataset(private var data: ArrayList<Coordinate>, private val k: Int, private val isTwoDimensional: Boolean) {

    private var centroids = mutableListOf<Centroid>()

    init {
        // Randomize the initial starting point of k centroids, with no repeat centroids
        var point: Coordinate
        var usedPoints = mutableListOf<Coordinate>()
        for (i in 1..k) {
            point = randomPoint()
            while (usedPoints.contains(point))
                point = randomPoint()
            usedPoints.add(point)
            centroids.add(Centroid(point, isTwoDimensional))
        }
    }

    private fun randomPoint(): Coordinate {
        return data[(0..data.size).random()]
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
        var parentCentroid: Centroid
        for (point in data) {
            lowestDistance = Double.MAX_VALUE
            parentCentroid = centroids[0]
            for (centroid in centroids) {
                currentDistance = distance(point, centroid.coordinate)
                if (currentDistance < lowestDistance) {
                    lowestDistance = currentDistance
                    parentCentroid = centroid
                }
            }
            parentCentroid.closestDataPoints.add(point)
        }
    }

    private fun distance(firstPoint: Coordinate, secondPoint: Coordinate): Double {
        when (isTwoDimensional)
        {
            true -> return Math.sqrt(pow(secondPoint.x - firstPoint.x, 2.0) + pow(secondPoint.y - firstPoint.y, 2.0))
            false -> return Math.abs(secondPoint.x - firstPoint.x)
        }
    }
}