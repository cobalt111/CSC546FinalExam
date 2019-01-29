data class Slot(var filled: Boolean, private val slotNumber: Int) {

    val adjacencyLookup = hashMapOf<Int, Int>()

    init {
        for (i in IntRange(0, 5)) {
            // initialize illegal jumps (walls of the board) with -1
            adjacencyLookup[i] = -1
        }
        /* write down into the lookup table every adjacent slot number
           for the input slot based on this 0-5 relative direction system:

                                       2  3
                                     1 slot 4
                                       0  5

        */
        when (slotNumber) {
            0 -> {
                adjacencyLookup[0] = 1
                adjacencyLookup[5] = 2
            }
            1 -> {
                adjacencyLookup[0] = 3
                adjacencyLookup[3] = 0
                adjacencyLookup[5] = 4
            }
            2 -> {
                adjacencyLookup[0] = 4
                adjacencyLookup[2] = 0
                adjacencyLookup[5] = 5
            }
            3 -> {
                adjacencyLookup[0] = 6
                adjacencyLookup[3] = 1
                adjacencyLookup[4] = 4
                adjacencyLookup[5] = 7
            }
            4 -> {
                adjacencyLookup[0] = 7
                adjacencyLookup[1] = 3
                adjacencyLookup[2] = 1
                adjacencyLookup[3] = 2
                adjacencyLookup[4] = 5
                adjacencyLookup[5] = 8
            }
            5 -> {
                adjacencyLookup[0] = 8
                adjacencyLookup[1] = 4
                adjacencyLookup[2] = 2
                adjacencyLookup[5] = 9
            }
            6 -> {
                adjacencyLookup[0] = 10
                adjacencyLookup[3] = 3
                adjacencyLookup[4] = 7
            }
            7 -> {
                adjacencyLookup[0] = 11
                adjacencyLookup[1] = 6
                adjacencyLookup[2] = 3
                adjacencyLookup[3] = 4
                adjacencyLookup[4] = 8
                adjacencyLookup[5] = 12
            }
            8 -> {
                adjacencyLookup[0] = 12
                adjacencyLookup[1] = 7
                adjacencyLookup[2] = 4
                adjacencyLookup[3] = 5
                adjacencyLookup[4] = 9
                adjacencyLookup[5] = 13
            }
            9 -> {
                adjacencyLookup[0] = 13
                adjacencyLookup[1] = 8
                adjacencyLookup[2] = 5
                adjacencyLookup[5] = 14
            }
            10 -> {
                adjacencyLookup[3] = 6
                adjacencyLookup[4] = 11
            }
            11 -> {
                adjacencyLookup[1] = 10
                adjacencyLookup[3] = 7
                adjacencyLookup[4] = 12
            }
            12 -> {
                adjacencyLookup[1] = 11
                adjacencyLookup[2] = 7
                adjacencyLookup[3] = 8
                adjacencyLookup[4] = 13
            }
            13 -> {
                adjacencyLookup[1] = 12
                adjacencyLookup[2] = 8
                adjacencyLookup[3] = 9
                adjacencyLookup[4] = 14
            }
            14 -> {
                adjacencyLookup[1] = 13
                adjacencyLookup[2] = 9
            }
        }
    }

    fun isFilled(): Boolean {
        return filled
    }
}