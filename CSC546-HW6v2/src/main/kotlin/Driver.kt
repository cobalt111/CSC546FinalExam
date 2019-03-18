import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.JFreeChart
import org.jfree.data.xy.XYDataset
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
import org.jfree.util.ShapeUtilities
import java.awt.Color
import java.io.File
import javax.swing.JFrame

fun main() {

    // Set this number to the number of centroids desired
    val k = 2

    // Input data from dat files
    var rawData1D: ArrayList<Coordinate> = ArrayList()
    var rawData2D: ArrayList<Coordinate> = ArrayList()
    var datafileName1D = "/Users/tim/Projects/Intellij/CSC546-HW6v2/src/main/resources/HW_6_data_1D.dat"
    var datafileName2D = "/Users/tim/Projects/Intellij/CSC546-HW6v2/src/main/resources/HW_6_data_2D.dat"
    var oneDimensionalLines: List<String> = File(datafileName1D).readLines()
    var twoDimensionalLines: List<String> = File(datafileName2D).readLines()

    // Parse data strings to Coordinate type
    for (line in oneDimensionalLines)
        rawData1D.add(Coordinate(line.toDouble(), 0.0))
    for (line in twoDimensionalLines) {
        var dataPoint = line.split(" ")
        rawData2D.add(Coordinate(dataPoint[0].toDouble(), dataPoint[2].toDouble()))
    }

    var data1D = Dataset(rawData1D, k, false)
    var data2D = Dataset(rawData2D, k, true)

    class DataPlot(private val isTwoDimensional: Boolean, private val k: Int): JFrame() {

        init {
            val chart: JFreeChart = ChartFactory.createScatterPlot(
                if (isTwoDimensional) "HW6 Two Dimensions" else "HW6 One Dimension",
                "X-Axis",
                "Y-Axis",
                convertToXYDataset(if (isTwoDimensional) data2D else data1D))
            chart.setTextAntiAlias(true)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesPaint(0, Color.YELLOW)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesPaint(1, Color.ORANGE)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesPaint(2, Color.BLACK)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesPaint(3, Color.RED)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesPaint(4, Color.BLUE)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesPaint(5, Color.GREEN)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesShape(0, ShapeUtilities.createDiagonalCross(5f, 2f))
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesShape(1, ShapeUtilities.createDiamond(6f))
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesShape(2, ShapeUtilities.createRegularCross(5f, 2f))
            val panel = ChartPanel(chart)
            contentPane = panel
        }

        fun convertToXYDataset(dataset: Dataset): XYDataset {
            val newDataset = XYSeriesCollection()
            val seriesOne = XYSeries("Cluster 1")
            val seriesTwo = XYSeries("Cluster 2")
            val seriesThree = XYSeries("Cluster 3")
            val seriesFour = XYSeries("Cluster 1 Centroid")
            val seriesFive = XYSeries("Cluster 2 Centroid")
            val seriesSix = XYSeries("Cluster 3 Centroid")
            when (isTwoDimensional) {
                true -> {
                    var currentCentroid = dataset.centroids[0]
                    for (point in currentCentroid.closestDataPoints) {
                        seriesOne.add(point.x, point.y)
                    }
                    seriesFour.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    currentCentroid = dataset.centroids[1]
                    for (point in currentCentroid.closestDataPoints) {
                        seriesTwo.add(point.x, point.y)
                    }
                    seriesFive.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    if (k > 2) {
                        currentCentroid = dataset.centroids[2]
                        for (point in currentCentroid.closestDataPoints) {
                            seriesThree.add(point.x, point.y)
                        }
                        seriesSix.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    }
                }
                false -> {
                    var currentCentroid = dataset.centroids[0]
                    for (point in currentCentroid.closestDataPoints) {
                        seriesOne.add(point.x, 0)
                    }
                    seriesFour.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    currentCentroid = dataset.centroids[1]
                    for (point in currentCentroid.closestDataPoints) {
                        seriesTwo.add(point.x, 0)
                    }
                    seriesFive.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    if (k > 2) {
                        currentCentroid = dataset.centroids[2]
                        for (point in currentCentroid.closestDataPoints) {
                            seriesThree.add(point.x, point.y)
                        }
                        seriesSix.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    }
                }
            }
            newDataset.addSeries(seriesFour)
            newDataset.addSeries(seriesFive)
            newDataset.addSeries(seriesSix)
            newDataset.addSeries(seriesOne)
            newDataset.addSeries(seriesTwo)
            newDataset.addSeries(seriesThree)
            return newDataset
        }
    }

    for (i in 0..10) {
        data1D.updateCentroidMeans()
        data2D.updateCentroidMeans()
    }

    // Plot the datasets
    val plot1D = DataPlot(false, k)
    val plot2D = DataPlot(true, k)
    plot1D.setSize(800, 500)
    plot1D.show()
    plot2D.setSize(800, 500)
    plot2D.show()
}