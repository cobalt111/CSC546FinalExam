data class Coordinate(var x: Double, var y: Double) {

    companion object Calculator {
        internal fun distance(firstPoint: Coordinate, secondPoint: Coordinate, isTwoDimensional: Boolean): Double {
            return when (isTwoDimensional) {
                true -> Math.sqrt(Math.pow(secondPoint.x - firstPoint.x, 2.0) + Math.pow(secondPoint.y - firstPoint.y, 2.0))
                false -> Math.abs(secondPoint.x - firstPoint.x)
            }
        }
    }
}
