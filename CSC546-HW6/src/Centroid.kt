class Centroid(var coordinate: Coordinate, val isTwoDimensional: Boolean) {

    var closestDataPoints = mutableListOf<Coordinate>()

    fun updateCoordinate() {
        var mean = Coordinate(0.0, 0.0)
        if (isTwoDimensional) {
            var xMean = 0.0
            var yMean = 0.0
            for (currentPoint: Int in (0..closestDataPoints.size)) {
                xMean += closestDataPoints[currentPoint].x
                yMean += closestDataPoints[currentPoint].y
            }
            mean.x = xMean / closestDataPoints.size
            mean.y = yMean / closestDataPoints.size
        }
        else {
            var xMean = 0.0
            for (currentPoint: Int in (0..closestDataPoints.size)) {
                xMean += closestDataPoints[currentPoint].x
            }
            mean.x = xMean / closestDataPoints.size
        }
        coordinate = mean
    }

    fun flushClosestPoints() {
        closestDataPoints = mutableListOf<Coordinate>()
    }
}