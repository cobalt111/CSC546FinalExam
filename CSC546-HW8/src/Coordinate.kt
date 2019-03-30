data class Coordinate(internal val x: Double, internal val y: Double, internal val type: Int) {

    companion object Calculator {
        // Euclidean distance between two points
        internal fun distance(firstPoint: Coordinate, secondPoint: Coordinate): Double {
            return Math.sqrt(Math.pow(secondPoint.x - firstPoint.x, 2.0) + Math.pow(secondPoint.y - firstPoint.y, 2.0))
        }
    }
}
