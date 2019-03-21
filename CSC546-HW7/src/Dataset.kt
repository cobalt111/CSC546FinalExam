import Coordinate.Calculator.distance
import java.util.*

class Dataset(internal var data: ArrayList<Coordinate>, private val k: Int) {

    data class CoordinateDistance(val coordinate: Coordinate, val distance: Double): Comparable<CoordinateDistance> {
        override fun compareTo(other: CoordinateDistance): Int {
            return when {
                other.distance < distance -> 1
                other.distance == distance -> 0
                other.distance > distance -> -1
                else -> 0
            }
        }
    }

    internal fun decideClass(pointToClassify: Coordinate): Int {
        var typeOneCount = 0
        var typeTwoCount = 0
        val distancesToPoints = findSortedDistances(pointToClassify)
        for (i in 0 until k) {
            when (distancesToPoints[i].coordinate.type) {
                1 -> typeOneCount++
                2 -> typeTwoCount++
            }
        }
        return when (typeOneCount >= typeTwoCount) {
            true -> 1
            false -> 2
        }
    }

    private fun findSortedDistances(pointToClassify: Coordinate): MutableList<CoordinateDistance> {
        val distancesToPoints = mutableListOf<CoordinateDistance>()
        for (currentPoint in data)
            distancesToPoints.add(CoordinateDistance(currentPoint, distance(pointToClassify, currentPoint)))
        distancesToPoints.sort()
        return distancesToPoints
    }
}