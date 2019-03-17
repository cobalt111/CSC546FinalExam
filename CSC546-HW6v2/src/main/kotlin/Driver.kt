import krangl.sleepData
import kravis.LegendType
import kravis.geomPoint
import kravis.guides
import kravis.plot
import java.io.File

fun main() {

    // Set this number to the number of centroids desired
    val k = 3

    // Input data from dat files
    var rawData1D: ArrayList<Coordinate> = ArrayList()
    var rawData2D: ArrayList<Coordinate> = ArrayList()
    var datafileName1D = "/Users/tim/Projects/Intellij/CSC546-HW6v2/src/main/resources/HW_6_data_1D.dat"
    var datafileName2D = "/Users/tim/Projects/Intellij/CSC546-HW6v2/src/main/resources/HW_6_data_2D.dat"
    var oneDimensionalLines: List<String> = File(datafileName1D).readLines()
    var twoDimensionalLines: List<String> = File(datafileName2D).readLines()

    // Parse data strings to Coordinate type
    for (line in oneDimensionalLines) {
        rawData1D.add(Coordinate(line.toDouble(), 0.0))
    }
    for (line in twoDimensionalLines) {
        var dataPoint = line.split(" ")
        rawData2D.add(Coordinate(dataPoint[0].toDouble(), dataPoint[2].toDouble()))
    }

    var data1D = Dataset(rawData1D, k, false)
    var data2D = Dataset(rawData2D, k, true)

    for (i in 0..10) {
//        data1D.updateCentroidMeans()
        data2D.updateCentroidMeans()
    }




    sleepData
        .addColumn("rem_proportion") { it["sleep_rem"] / it["sleep_total"] }
        // Analyze correlation
        .plot(x = "X", y = "Y", color = "Clusters")
        .geomPoint(alpha = 0.7)
        .guides(size = LegendType.none)
        .title("Clustering of HW6 Data")
}