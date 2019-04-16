// Cell is a class that records the filled status of a given cell, its board index number, and
// has a lookup table for what indexes its neighbors are
class Cell(internal var filled: Boolean, internal var boardSlotNumber: Int) {


    internal val adjacentCellsLookup = hashMapOf<Direction, Int>()

    init {
        // Initialize the lookup table to be all -1 values,
        // -1 means wall.
        for (direction in Direction.values()) {
            adjacentCellsLookup[direction] = -1
        }

        // This lookup table writes down what a given cell's neighbor indexes are.
        // It will make procesing the game quicker since it doesn't need to calculate
        // indexes for neighbors on every jump
        when (boardSlotNumber) {
            0 -> {
                adjacentCellsLookup[Direction.LeftDown] = 4
                adjacentCellsLookup[Direction.Right] = 1
                adjacentCellsLookup[Direction.RightDown] = 5
            }
            1 -> {
                adjacentCellsLookup[Direction.LeftDown] = 5
                adjacentCellsLookup[Direction.Left] = 0
                adjacentCellsLookup[Direction.Right] = 2
                adjacentCellsLookup[Direction.RightDown] = 6
            }
            2 -> {
                adjacentCellsLookup[Direction.LeftDown] = 6
                adjacentCellsLookup[Direction.Left] = 1
                adjacentCellsLookup[Direction.Right] = 3
                adjacentCellsLookup[Direction.RightDown] = 7
            }
            3 -> {
                adjacentCellsLookup[Direction.LeftDown] = 7
                adjacentCellsLookup[Direction.Left] = 2
                adjacentCellsLookup[Direction.RightDown] = 8
            }
            4 -> {
                adjacentCellsLookup[Direction.LeftDown] = 9
                adjacentCellsLookup[Direction.Right] = 5
                adjacentCellsLookup[Direction.RightDown] = 10
                adjacentCellsLookup[Direction.RightUp] = 0
            }
            5 -> {
                adjacentCellsLookup[Direction.LeftDown] = 10
                adjacentCellsLookup[Direction.Left] = 4
                adjacentCellsLookup[Direction.LeftUp] = 0
                adjacentCellsLookup[Direction.RightUp] = 1
                adjacentCellsLookup[Direction.Right] = 6
                adjacentCellsLookup[Direction.RightDown] = 11
            }
            6 -> {
                adjacentCellsLookup[Direction.LeftDown] = 11
                adjacentCellsLookup[Direction.Left] = 5
                adjacentCellsLookup[Direction.LeftUp] = 1
                adjacentCellsLookup[Direction.RightUp] = 2
                adjacentCellsLookup[Direction.Right] = 7
                adjacentCellsLookup[Direction.RightDown] = 12
            }
            7 -> {
                adjacentCellsLookup[Direction.LeftDown] = 12
                adjacentCellsLookup[Direction.Left] = 6
                adjacentCellsLookup[Direction.LeftUp] = 2
                adjacentCellsLookup[Direction.RightUp] = 3
                adjacentCellsLookup[Direction.Right] = 8
                adjacentCellsLookup[Direction.RightDown] = 13
            }
            8 -> {
                adjacentCellsLookup[Direction.LeftDown] = 13
                adjacentCellsLookup[Direction.Left] = 7
                adjacentCellsLookup[Direction.LeftUp] = 3
                adjacentCellsLookup[Direction.RightDown] = 14
            }
            9 -> {
                adjacentCellsLookup[Direction.LeftDown] = 15
                adjacentCellsLookup[Direction.RightUp] = 4
                adjacentCellsLookup[Direction.Right] = 10
                adjacentCellsLookup[Direction.RightDown] = 16
            }
            10 -> {
                adjacentCellsLookup[Direction.LeftDown] = 16
                adjacentCellsLookup[Direction.Left] = 9
                adjacentCellsLookup[Direction.LeftUp] = 4
                adjacentCellsLookup[Direction.RightUp] = 5
                adjacentCellsLookup[Direction.Right] = 11
                adjacentCellsLookup[Direction.RightDown] = 17
            }
            11 -> {
                adjacentCellsLookup[Direction.LeftDown] = 17
                adjacentCellsLookup[Direction.Left] = 10
                adjacentCellsLookup[Direction.LeftUp] = 5
                adjacentCellsLookup[Direction.RightUp] = 6
                adjacentCellsLookup[Direction.Right] = 12
                adjacentCellsLookup[Direction.RightDown] = 18
            }
            12 -> {
                adjacentCellsLookup[Direction.LeftDown] = 18
                adjacentCellsLookup[Direction.Left] = 11
                adjacentCellsLookup[Direction.LeftUp] = 6
                adjacentCellsLookup[Direction.RightUp] = 7
                adjacentCellsLookup[Direction.Right] = 13
                adjacentCellsLookup[Direction.RightDown] = 19
            }
            13 -> {
                adjacentCellsLookup[Direction.LeftDown] = 19
                adjacentCellsLookup[Direction.Left] = 12
                adjacentCellsLookup[Direction.LeftUp] = 7
                adjacentCellsLookup[Direction.RightUp] = 8
                adjacentCellsLookup[Direction.Right] = 14
                adjacentCellsLookup[Direction.RightDown] = 20
            }
            14 -> {
                adjacentCellsLookup[Direction.LeftDown] = 20
                adjacentCellsLookup[Direction.Left] = 13
                adjacentCellsLookup[Direction.LeftUp] = 8
                adjacentCellsLookup[Direction.RightDown] = 21
            }
            15 -> {
                adjacentCellsLookup[Direction.RightUp] = 9
                adjacentCellsLookup[Direction.Right] = 16
                adjacentCellsLookup[Direction.RightDown] = 22
            }
            16 -> {
                adjacentCellsLookup[Direction.LeftDown] = 22
                adjacentCellsLookup[Direction.Left] = 15
                adjacentCellsLookup[Direction.LeftUp] = 9
                adjacentCellsLookup[Direction.RightUp] = 10
                adjacentCellsLookup[Direction.Right] = 17
                adjacentCellsLookup[Direction.RightDown] = 23
            }
            17 -> {
                adjacentCellsLookup[Direction.LeftDown] = 23
                adjacentCellsLookup[Direction.Left] = 16
                adjacentCellsLookup[Direction.LeftUp] = 10
                adjacentCellsLookup[Direction.RightUp] = 11
                adjacentCellsLookup[Direction.Right] = 18
                adjacentCellsLookup[Direction.RightDown] = 24
            }
            18 -> {
                adjacentCellsLookup[Direction.LeftDown] = 24
                adjacentCellsLookup[Direction.Left] = 17
                adjacentCellsLookup[Direction.LeftUp] = 11
                adjacentCellsLookup[Direction.RightUp] = 12
                adjacentCellsLookup[Direction.Right] = 19
                adjacentCellsLookup[Direction.RightDown] = 25
            }
            19 -> {
                adjacentCellsLookup[Direction.LeftDown] = 25
                adjacentCellsLookup[Direction.Left] = 18
                adjacentCellsLookup[Direction.LeftUp] = 12
                adjacentCellsLookup[Direction.RightUp] = 13
                adjacentCellsLookup[Direction.Right] = 20
                adjacentCellsLookup[Direction.RightDown] = 26
            }
            20 -> {
                adjacentCellsLookup[Direction.LeftDown] = 26
                adjacentCellsLookup[Direction.Left] = 19
                adjacentCellsLookup[Direction.LeftUp] = 13
                adjacentCellsLookup[Direction.RightUp] = 14
                adjacentCellsLookup[Direction.Right] = 21
                adjacentCellsLookup[Direction.RightDown] = 27
            }
            21 -> {
                adjacentCellsLookup[Direction.LeftDown] = 27
                adjacentCellsLookup[Direction.Left] = 20
                adjacentCellsLookup[Direction.LeftUp] = 14
            }
            22 -> {
                adjacentCellsLookup[Direction.LeftUp] = 15
                adjacentCellsLookup[Direction.RightUp] = 16
                adjacentCellsLookup[Direction.Right] = 23
                adjacentCellsLookup[Direction.RightDown] = 28
            }
            23 -> {
                adjacentCellsLookup[Direction.LeftDown] = 28
                adjacentCellsLookup[Direction.Left] = 22
                adjacentCellsLookup[Direction.LeftUp] = 16
                adjacentCellsLookup[Direction.RightUp] = 17
                adjacentCellsLookup[Direction.Right] = 24
                adjacentCellsLookup[Direction.RightDown] = 29
            }
            24 -> {
                adjacentCellsLookup[Direction.LeftDown] = 29
                adjacentCellsLookup[Direction.Left] = 23
                adjacentCellsLookup[Direction.LeftUp] = 17
                adjacentCellsLookup[Direction.RightUp] = 18
                adjacentCellsLookup[Direction.Right] = 25
                adjacentCellsLookup[Direction.RightDown] = 30
            }
            25 -> {
                adjacentCellsLookup[Direction.LeftDown] = 30
                adjacentCellsLookup[Direction.Left] = 24
                adjacentCellsLookup[Direction.LeftUp] = 18
                adjacentCellsLookup[Direction.RightUp] = 19
                adjacentCellsLookup[Direction.Right] = 26
                adjacentCellsLookup[Direction.RightDown] = 31
            }
            26 -> {
                adjacentCellsLookup[Direction.LeftDown] = 31
                adjacentCellsLookup[Direction.Left] = 25
                adjacentCellsLookup[Direction.LeftUp] = 19
                adjacentCellsLookup[Direction.RightUp] = 20
                adjacentCellsLookup[Direction.Right] = 27
                adjacentCellsLookup[Direction.RightDown] = 32
            }
            27 -> {
                adjacentCellsLookup[Direction.LeftDown] = 32
                adjacentCellsLookup[Direction.Left] = 26
                adjacentCellsLookup[Direction.LeftUp] = 20
                adjacentCellsLookup[Direction.RightUp] = 21
            }
            28 -> {
                adjacentCellsLookup[Direction.LeftUp] = 22
                adjacentCellsLookup[Direction.RightUp] = 23
                adjacentCellsLookup[Direction.Right] = 29
                adjacentCellsLookup[Direction.RightDown] = 33
            }
            29 -> {
                adjacentCellsLookup[Direction.LeftDown] = 33
                adjacentCellsLookup[Direction.Left] = 28
                adjacentCellsLookup[Direction.LeftUp] = 23
                adjacentCellsLookup[Direction.RightUp] = 24
                adjacentCellsLookup[Direction.Right] = 30
                adjacentCellsLookup[Direction.RightDown] = 34
            }
            30 -> {
                adjacentCellsLookup[Direction.LeftDown] = 34
                adjacentCellsLookup[Direction.Left] = 29
                adjacentCellsLookup[Direction.LeftUp] = 24
                adjacentCellsLookup[Direction.RightUp] = 25
                adjacentCellsLookup[Direction.Right] = 31
                adjacentCellsLookup[Direction.RightDown] = 35
            }
            31 -> {
                adjacentCellsLookup[Direction.LeftDown] = 35
                adjacentCellsLookup[Direction.Left] = 30
                adjacentCellsLookup[Direction.LeftUp] = 25
                adjacentCellsLookup[Direction.RightUp] = 26
                adjacentCellsLookup[Direction.Right] = 32
                adjacentCellsLookup[Direction.RightDown] = 36
            }
            32 -> {
                adjacentCellsLookup[Direction.LeftDown] = 36
                adjacentCellsLookup[Direction.Left] = 31
                adjacentCellsLookup[Direction.LeftUp] = 31
                adjacentCellsLookup[Direction.RightUp] = 27
            }
            33 -> {
                adjacentCellsLookup[Direction.LeftUp] = 28
                adjacentCellsLookup[Direction.RightUp] = 29
                adjacentCellsLookup[Direction.Right] = 34
            }
            34 -> {
                adjacentCellsLookup[Direction.LeftUp] = 29
                adjacentCellsLookup[Direction.RightUp] = 30
                adjacentCellsLookup[Direction.Right] = 33
                adjacentCellsLookup[Direction.Left] = 35
            }
            35 -> {
                adjacentCellsLookup[Direction.LeftUp] = 30
                adjacentCellsLookup[Direction.RightUp] = 31
                adjacentCellsLookup[Direction.Right] = 34
                adjacentCellsLookup[Direction.Left] = 36
            }
            36 -> {
                adjacentCellsLookup[Direction.LeftUp] = 31
                adjacentCellsLookup[Direction.RightUp] = 32
                adjacentCellsLookup[Direction.Left] = 35
            }
        }
    }
}