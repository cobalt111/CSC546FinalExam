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

    // Set this number to the number of points to count
    val k = 1

    // Input data from dat files
    val rawTrainingData: ArrayList<Coordinate> = ArrayList()
    val trainingDataFilePath = "/Users/tim/Projects/Intellij/CSC546-HW7/resources/homework_classify_train_2D.dat"
    val rawTestData: ArrayList<Coordinate> = ArrayList()
    val testDataFilePath = "/Users/tim/Projects/Intellij/CSC546-HW7/resources/homework_classify_test_2D.dat"
    val trainLines = File(trainingDataFilePath).readLines()
    val testLines = File(testDataFilePath).readLines()

    // Parse data strings to Coordinate type
    for (line in trainLines) {
        val dataPoint = line.split("   ")
        rawTrainingData.add(Coordinate(dataPoint[0].toDouble(), dataPoint[1].toDouble(), dataPoint[2].toInt()))
    }
    for (line in testLines) {
        val dataPoint = line.split("   ")
        rawTestData.add(Coordinate(dataPoint[0].toDouble(), dataPoint[1].toDouble(), dataPoint[2].toInt()))
    }

    // Create Datasets
    val trainingData = Dataset(rawTrainingData, k)
    val testData = Dataset(rawTestData, k)

    // Internal class used for making the scatter plots
    class DataPlot(private val pointToClassify: Coordinate, private val stage: Int): JFrame() {
        val chart: JFreeChart = ChartFactory.createScatterPlot(
            "Classifying Point ${stage+1}",
            "X-Axis",
            "Y-Axis",
            convertToXYDataset(pointToClassify))
        init {

            chart.setTextAntiAlias(true)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesPaint(0, Color.RED)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesPaint(1, Color.BLUE)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesPaint(2, Color.GREEN)
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesShape(0, ShapeUtilities.createRegularCross(3f, 1f))
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesShape(1, ShapeUtilities.createDiamond(3f))
            chart.xyPlot.getRendererForDataset(chart.xyPlot.dataset).setSeriesShape(2, ShapeUtilities.createRegularCross(8f, 2f))
            val panel = ChartPanel(chart)
            contentPane = panel
        }

        // XYDataset is the type that the JFreeChart library wants, so this converts my Dataset type to that
        fun convertToXYDataset(pointToClassify: Coordinate): XYDataset {
            val newDataset = XYSeriesCollection()
            val seriesOne = XYSeries("Cluster 1")
            val seriesTwo = XYSeries("Cluster 2")
            val inputPoint = XYSeries("Input Point")
            for (point in trainingData.data) {
                if (point.type == 1) seriesOne.add(point.x, point.y)
                else seriesTwo.add(point.x, point.y)
            }
            inputPoint.add(pointToClassify.x, pointToClassify.y)
            newDataset.addSeries(seriesOne)
            newDataset.addSeries(seriesTwo)
            newDataset.addSeries(inputPoint)
            return newDataset
        }
    }

    for (i in 0..4) {
        val plot = DataPlot(testData.data[i], i)
        when (trainingData.decideClass(testData.data[i])) {
            1 -> plot.chart.xyPlot.getRendererForDataset(plot.chart.xyPlot.dataset).setSeriesPaint(2, Color.RED)
            2 -> plot.chart.xyPlot.getRendererForDataset(plot.chart.xyPlot.dataset).setSeriesPaint(2, Color.BLUE)
        }
        plot.setSize(800, 500)
        plot.show()
    }
}
