class Slot(var filled: Boolean, slotNumber: Int) {

    val adjacentSlotNumbers = hashMapOf<Direction, Int>()

    companion object {
        const val NUMBER_OF_SLOTS = 15
    }

    init {
        for (direction in Direction.values()) {
            // initialize illegal jumps (walls of the board) with -1
            adjacentSlotNumbers[direction] = -1
        }

        /* Slot numbers are defined as such:

                             0
                           1   2
                         3   4   5
                       6   7   8   9
                     10  11  12  14  15

        */

        when (slotNumber) {
            0 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 1
                adjacentSlotNumbers[Direction.RightDown] = 2
            }
            1 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 3
                adjacentSlotNumbers[Direction.RightUp] = 0
                adjacentSlotNumbers[Direction.RightDown] = 4
            }
            2 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 4
                adjacentSlotNumbers[Direction.LeftUp] = 0
                adjacentSlotNumbers[Direction.RightDown] = 5
            }
            3 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 6
                adjacentSlotNumbers[Direction.RightUp] = 1
                adjacentSlotNumbers[Direction.Right] = 4
                adjacentSlotNumbers[Direction.RightDown] = 7
            }
            4 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 7
                adjacentSlotNumbers[Direction.Left] = 3
                adjacentSlotNumbers[Direction.LeftUp] = 1
                adjacentSlotNumbers[Direction.RightUp] = 2
                adjacentSlotNumbers[Direction.Right] = 5
                adjacentSlotNumbers[Direction.RightDown] = 8
            }
            5 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 8
                adjacentSlotNumbers[Direction.Left] = 4
                adjacentSlotNumbers[Direction.LeftUp] = 2
                adjacentSlotNumbers[Direction.RightDown] = 9
            }
            6 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 10
                adjacentSlotNumbers[Direction.RightUp] = 3
                adjacentSlotNumbers[Direction.Right] = 7
            }
            7 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 11
                adjacentSlotNumbers[Direction.Left] = 6
                adjacentSlotNumbers[Direction.LeftUp] = 3
                adjacentSlotNumbers[Direction.RightUp] = 4
                adjacentSlotNumbers[Direction.Right] = 8
                adjacentSlotNumbers[Direction.RightDown] = 12
            }
            8 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 12
                adjacentSlotNumbers[Direction.Left] = 7
                adjacentSlotNumbers[Direction.LeftUp] = 4
                adjacentSlotNumbers[Direction.RightUp] = 5
                adjacentSlotNumbers[Direction.Right] = 9
                adjacentSlotNumbers[Direction.RightDown] = 13
            }
            9 -> {
                adjacentSlotNumbers[Direction.LeftDown] = 13
                adjacentSlotNumbers[Direction.Left] = 8
                adjacentSlotNumbers[Direction.LeftUp] = 5
                adjacentSlotNumbers[Direction.RightDown] = 14
            }
            10 -> {
                adjacentSlotNumbers[Direction.RightUp] = 6
                adjacentSlotNumbers[Direction.Right] = 11
            }
            11 -> {
                adjacentSlotNumbers[Direction.Left] = 10
                adjacentSlotNumbers[Direction.RightUp] = 7
                adjacentSlotNumbers[Direction.Right] = 12
            }
            12 -> {
                adjacentSlotNumbers[Direction.Left] = 11
                adjacentSlotNumbers[Direction.LeftUp] = 7
                adjacentSlotNumbers[Direction.RightUp] = 8
                adjacentSlotNumbers[Direction.Right] = 13
            }
            13 -> {
                adjacentSlotNumbers[Direction.Left] = 12
                adjacentSlotNumbers[Direction.LeftUp] = 8
                adjacentSlotNumbers[Direction.RightUp] = 9
                adjacentSlotNumbers[Direction.Right] = 14
            }
            14 -> {
                adjacentSlotNumbers[Direction.Left] = 13
                adjacentSlotNumbers[Direction.LeftUp] = 9
            }
        }
    }

    fun hasPeg(): Boolean {
        return filled
    }
}