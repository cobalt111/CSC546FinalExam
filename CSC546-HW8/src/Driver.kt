import java.io.File

fun main() {

    // region Process input
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
    val trainingData = Dataset(rawTrainingData)
    // endregion

    trainingData.createClustersAndCentroids()

    for (i in 0..4)
        println("Test point ${i+1} decided class: ${trainingData.decideClass(rawTestData[i])}\n")
}
