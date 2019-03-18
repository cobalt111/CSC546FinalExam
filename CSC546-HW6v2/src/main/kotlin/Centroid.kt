class Centroid(internal var coordinate: Coordinate) {

    internal var closestDataPoints = mutableListOf<Coordinate>()

    fun updateCoordinate() {
        val mean = Coordinate(0.0, 0.0)
            for (currentPoint in closestDataPoints) {
                mean.x += currentPoint.x
                mean.y += currentPoint.y
            }
            mean.x = mean.x / closestDataPoints.size
            mean.y = mean.y / closestDataPoints.size
        coordinate = mean
    }

    fun flushClosestPoints() {
        closestDataPoints = mutableListOf<Coordinate>()
    }
}