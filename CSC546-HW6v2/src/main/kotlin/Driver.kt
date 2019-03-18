import org.jfree.chart.ChartFactory
import org.jfree.chart.ChartPanel
import org.jfree.chart.JFreeChart
import org.jfree.data.xy.XYDataset
import org.jfree.data.xy.XYSeries
import org.jfree.data.xy.XYSeriesCollection
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



    class DataPlot(private val isTwoDimensional: Boolean) : JFrame() {

        init {
            var chart: JFreeChart = ChartFactory.createScatterPlot(
                if (isTwoDimensional) "HW6 Two Dimensions" else "HW6 One Dimension",
                "X-Axis",
                "Y-Axis",
                convertToXYDataset(if (isTwoDimensional) data2D else data1D))
            var panel = ChartPanel(chart)
            contentPane = panel
        }

        fun convertToXYDataset(dataset: Dataset): XYDataset {
            var newDataset = XYSeriesCollection()
            var seriesOne = XYSeries("Cluster 1")
            var seriesTwo = XYSeries("Cluster 2")
            var seriesThree = XYSeries("Cluster 1 Centroid")
            var seriesFour = XYSeries("Cluster 2 Centroid")

            when (isTwoDimensional) {
                true -> {
                    var currentCentroid = dataset.centroids[0]
                    for (point in currentCentroid.closestDataPoints) {
                        seriesOne.add(point.x, point.y)
                    }
                    seriesThree.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    currentCentroid = dataset.centroids[1]
                    for (point in currentCentroid.closestDataPoints) {
                        seriesTwo.add(point.x, point.y)
                    }
                    seriesFour.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                }
                false -> {
                    var currentCentroid = dataset.centroids[0]
                    for (point in currentCentroid.closestDataPoints) {
                        seriesOne.add(point.x, 0)
                    }
                    seriesThree.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                    currentCentroid = dataset.centroids[1]
                    for (point in currentCentroid.closestDataPoints) {
                        seriesTwo.add(point.x, 0)
                    }
                    seriesFour.add(currentCentroid.coordinate.x, currentCentroid.coordinate.y)
                }
            }
            newDataset.addSeries(seriesOne)
            newDataset.addSeries(seriesTwo)
            newDataset.addSeries(seriesThree)
            newDataset.addSeries(seriesFour)
            return newDataset
        }
    }

    for (i in 0..10) {
        data1D.updateCentroidMeans()
        data2D.updateCentroidMeans()
    }

    val plot1D = DataPlot(false)
    val plot2D = DataPlot(true)
    plot1D.setSize(800, 500)
    plot1D.show()
    plot2D.setSize(800, 500)
    plot2D.show()
}