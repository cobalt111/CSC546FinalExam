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
    val rawData1D: ArrayList<Coordinate> = ArrayList()
    val rawData2D: ArrayList<Coordinate> = ArrayList()
    val datafileName1D = "/Users/tim/Projects/Intellij/CSC546-HW6v2/src/main/resources/HW_6_data_1D.dat"
    val datafileName2D = "/Users/tim/Projects/Intellij/CSC546-HW6v2/src/main/resources/HW_6_data_2D.dat"
    val oneDimensionalLines = File(datafileName1D).readLines()
    val twoDimensionalLines = File(datafileName2D).readLines()

    // Parse data strings to Coordinate type
    for (line in oneDimensionalLines)
        rawData1D.add(Coordinate(line.toDouble(), 0.0))
    for (line in twoDimensionalLines) {
        val dataPoint = line.split("  ")
        rawData2D.add(Coordinate(dataPoint[0].toDouble(), dataPoint[1].toDouble()))
    }

    // Create Datasets
    val dataset1D = Dataset(rawData1D, k, false)
    val dataset2D = Dataset(rawData2D, k, true)

    // Internal class used for making the scatter plots
    class DataPlot(private val isTwoDimensional: Boolean, private val k: Int, private val stage: Int): JFrame() {

        init {
            val chart: JFreeChart = ChartFactory.createScatterPlot(
                if (isTwoDimensional) "HW6 Two Dimensions - Stage $stage" else "HW6 One Dimension - Stage $stage",
                "X-Axis",
                "Y-Axis",
                convertToXYDataset(if (isTwoDimensional) dataset2D else dataset1D))
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

        // XYDataset is the type that the JFreeChart library wants, so this converts my Dataset type to that
        fun convertToXYDataset(dataset: Dataset): XYDataset {
            val newDataset = XYSeriesCollection()
            val seriesOne = XYSeries("Cluster 1")
            val seriesTwo = XYSeries("Cluster 2")
            val seriesThree = XYSeries("Cluster 3")
            val seriesOneCentroid = XYSeries("Cluster 1 Centroid")
            val seriesTwoCentroid = XYSeries("Cluster 2 Centroid")
            val seriesThreeCentroid = XYSeries("Cluster 3 Centroid")
            when (isTwoDimensional) {
                true -> {
                    var currentCentroid = dataset.centroids[0]
                    for (point in currentCentroid.closestDataPoints)
                        seriesOne.add(point.x, point.y)
                    seriesOneCentroid.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    currentCentroid = dataset.centroids[1]
                    for (point in currentCentroid.closestDataPoints)
                        seriesTwo.add(point.x, point.y)
                    seriesTwoCentroid.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    if (k > 2) {
                        currentCentroid = dataset.centroids[2]
                        for (point in currentCentroid.closestDataPoints)
                            seriesThree.add(point.x, point.y)
                        seriesThreeCentroid.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    }
                }
                false -> {
                    var currentCentroid = dataset.centroids[0]
                    for (point in currentCentroid.closestDataPoints)
                        seriesOne.add(point.x, 0)
                    seriesOneCentroid.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    currentCentroid = dataset.centroids[1]
                    for (point in currentCentroid.closestDataPoints)
                        seriesTwo.add(point.x, 0)
                    seriesTwoCentroid.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    if (k > 2) {
                        currentCentroid = dataset.centroids[2]
                        for (point in currentCentroid.closestDataPoints)
                            seriesThree.add(point.x, point.y)
                        seriesThreeCentroid.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    }
                }
            }
            newDataset.addSeries(seriesOneCentroid)
            newDataset.addSeries(seriesTwoCentroid)
            newDataset.addSeries(seriesThreeCentroid)
            newDataset.addSeries(seriesOne)
            newDataset.addSeries(seriesTwo)
            newDataset.addSeries(seriesThree)
            return newDataset
        }
    }

    for (stage in 1..10) {
        dataset1D.updateCentroidMeans()
        dataset2D.updateCentroidMeans()

        if (stage == 1 || stage == 10) {
            // Plot the datasets
            val plot1D = DataPlot(false, k, stage)
            val plot2D = DataPlot(true, k, stage)
            plot1D.setSize(800, 500)
            plot1D.show()
            plot2D.setSize(800, 500)
            plot2D.show()
        }
    }
}
