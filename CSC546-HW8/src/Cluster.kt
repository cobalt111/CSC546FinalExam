class Cluster(internal var centroidCoordinate: Coordinate) {

    internal var data = mutableListOf<Coordinate>()
    internal var standardDeviations = Pair(0.0, 0.0)

    internal fun update() {
        val means = means()
        centroidCoordinate = Coordinate(means.first, means.second, centroidCoordinate.type)
        standardDeviations = standardDeviations(means)
    }

    private fun means(): Pair<Double, Double> {
        var x = 0.0
        var y = 0.0
        for (currentPoint in data) {
            x += currentPoint.x
            y += currentPoint.y
        }
        x /= data.size
        y /= data.size
        return Pair(x, y)
    }

    private fun standardDeviations(means: Pair<Double, Double>): Pair<Double, Double> {
        var xMeanDifferences = 0.0
        var yMeanDifferences = 0.0
        for (currentPoint in data) {
            xMeanDifferences += Math.pow(currentPoint.x - means.first, 2.0)
            yMeanDifferences += Math.pow(currentPoint.y - means.second, 2.0)
        }
        return Pair(Math.sqrt(xMeanDifferences / data.size), Math.sqrt(yMeanDifferences / data.size))
    }
}
