import java.lang.Math.pow
import kotlin.collections.ArrayList

class Dataset(var data: ArrayList<Coordinate>, val k: Int, val isTwoDimensional: Boolean) {

    var centroids = mutableListOf<Centroid>()
    val numberOfDataPoints = data.size

    init {
        // Randomize the initial starting point of k centroids, with no repeat centroids
        var point: Coordinate
        var usedPoints = mutableListOf<Coordinate>()
        for (i: Int in (0 until k - 1)) {
            point = randomPoint()
            while (usedPoints.contains(point))
                point = randomPoint()
            usedPoints.add(point)
            centroids[i] = Centroid(point, isTwoDimensional)
        }
    }

    fun randomPoint(): Coordinate {
        return data[(0 until numberOfDataPoints).random()]
    }

    fun updateCentroidMeans() {
        allocatePointsToCentroids()
        for (centroid: Centroid in centroids)
            centroid.updateCoordinate()
    }

    fun allocatePointsToCentroids() {
        for (centroid: Centroid in centroids)
            centroid.flushClosestPoints()
        var currentDistance: Double
        var lowestDistance = Double.MAX_VALUE
        var parentCentroid = centroids[0]
        for (point: Coordinate in data) {
            for (centroid: Centroid in centroids) {
                currentDistance = euclideanDistance(point, centroid.coordinate)
                if (currentDistance < lowestDistance) {
                    lowestDistance = currentDistance
                    parentCentroid = centroid
                }
            }
            parentCentroid.closestDataPoints.add(point)
        }
    }

    fun euclideanDistance(firstPoint: Coordinate, secondPoint: Coordinate): Double {
        return Math.sqrt(pow(secondPoint.x - firstPoint.x, 2.0) + pow(secondPoint.y - firstPoint.y, 2.0))
    }
}