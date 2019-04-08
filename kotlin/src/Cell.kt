class Cell(internal var filled: Boolean, internal var boardSlotNumber: Int) {

    internal val adjacentCellsLookup = hashMapOf<Direction, Int>()
    internal val transposeCellsLookup = hashMapOf<Direction, Int>()

    init {
        for (direction in Direction.values()) {
            adjacentCellsLookup[direction] = -1
            transposeCellsLookup[direction] = -1
        }

        // region Adjacent Cell Lookup Table
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
        // endregion

        // region Transpose Lookup Table
        when (boardSlotNumber) {
            0 -> {
                transposeCellsLookup[Direction.LeftDown] = 33
                transposeCellsLookup[Direction.Left] = 15
                transposeCellsLookup[Direction.RightUp] = 3
                transposeCellsLookup[Direction.Right] = 21
                transposeCellsLookup[Direction.RightDown] = 36
            }
            1 -> {
                transposeCellsLookup[Direction.LeftDown] = 28
                transposeCellsLookup[Direction.Left] = 1
                transposeCellsLookup[Direction.RightUp] = 8
                transposeCellsLookup[Direction.Right] = 27
                transposeCellsLookup[Direction.RightDown] = 35
            }
            2 -> {
                transposeCellsLookup[Direction.LeftDown] = 22
                transposeCellsLookup[Direction.Left] = 4
                transposeCellsLookup[Direction.RightUp] = 14
                transposeCellsLookup[Direction.Right] = 32
                transposeCellsLookup[Direction.RightDown] = 34
            }
            3 -> {
                transposeCellsLookup[Direction.LeftDown] = 7
                transposeCellsLookup[Direction.Left] = 1
                transposeCellsLookup[Direction.LeftUp] = 1
                transposeCellsLookup[Direction.Right] = 2
                transposeCellsLookup[Direction.RightDown] = 8
            }
            4 -> {
                transposeCellsLookup[Direction.LeftDown] = 9
                transposeCellsLookup[Direction.Right] = 5
                transposeCellsLookup[Direction.RightDown] = 10
                transposeCellsLookup[Direction.RightUp] = 0
            }
            5 -> {
                transposeCellsLookup[Direction.LeftDown] = 10
                transposeCellsLookup[Direction.Left] = 4
                transposeCellsLookup[Direction.LeftUp] = 0
                transposeCellsLookup[Direction.RightUp] = 1
                transposeCellsLookup[Direction.Right] = 6
                transposeCellsLookup[Direction.RightDown] = 11
            }
            6 -> {
                transposeCellsLookup[Direction.LeftDown] = 11
                transposeCellsLookup[Direction.Left] = 5
                transposeCellsLookup[Direction.LeftUp] = 1
                transposeCellsLookup[Direction.RightUp] = 2
                transposeCellsLookup[Direction.Right] = 7
                transposeCellsLookup[Direction.RightDown] = 12
            }
            7 -> {
                transposeCellsLookup[Direction.LeftDown] = 12
                transposeCellsLookup[Direction.Left] = 6
                transposeCellsLookup[Direction.LeftUp] = 2
                transposeCellsLookup[Direction.RightUp] = 3
                transposeCellsLookup[Direction.Right] = 8
                transposeCellsLookup[Direction.RightDown] = 13
            }
            8 -> {
                transposeCellsLookup[Direction.LeftDown] = 13
                transposeCellsLookup[Direction.Left] = 7
                transposeCellsLookup[Direction.LeftUp] = 3
                transposeCellsLookup[Direction.RightDown] = 14
            }
            9 -> {
                transposeCellsLookup[Direction.LeftDown] = 15
                transposeCellsLookup[Direction.RightUp] = 4
                transposeCellsLookup[Direction.Right] = 10
                transposeCellsLookup[Direction.RightDown] = 16
            }
            10 -> {
                transposeCellsLookup[Direction.LeftDown] = 16
                transposeCellsLookup[Direction.Left] = 9
                transposeCellsLookup[Direction.LeftUp] = 4
                transposeCellsLookup[Direction.RightUp] = 5
                transposeCellsLookup[Direction.Right] = 11
                transposeCellsLookup[Direction.RightDown] = 17
            }
            11 -> {
                transposeCellsLookup[Direction.LeftDown] = 17
                transposeCellsLookup[Direction.Left] = 10
                transposeCellsLookup[Direction.LeftUp] = 5
                transposeCellsLookup[Direction.RightUp] = 6
                transposeCellsLookup[Direction.Right] = 12
                transposeCellsLookup[Direction.RightDown] = 18
            }
            12 -> {
                transposeCellsLookup[Direction.LeftDown] = 18
                transposeCellsLookup[Direction.Left] = 11
                transposeCellsLookup[Direction.LeftUp] = 6
                transposeCellsLookup[Direction.RightUp] = 7
                transposeCellsLookup[Direction.Right] = 13
                transposeCellsLookup[Direction.RightDown] = 19
            }
            13 -> {
                transposeCellsLookup[Direction.LeftDown] = 19
                transposeCellsLookup[Direction.Left] = 12
                transposeCellsLookup[Direction.LeftUp] = 7
                transposeCellsLookup[Direction.RightUp] = 8
                transposeCellsLookup[Direction.Right] = 14
                transposeCellsLookup[Direction.RightDown] = 20
            }
            14 -> {
                transposeCellsLookup[Direction.LeftDown] = 20
                transposeCellsLookup[Direction.Left] = 13
                transposeCellsLookup[Direction.LeftUp] = 8
                transposeCellsLookup[Direction.RightDown] = 21
            }
            15 -> {
                transposeCellsLookup[Direction.RightUp] = 9
                transposeCellsLookup[Direction.Right] = 16
                transposeCellsLookup[Direction.RightDown] = 22
            }
            16 -> {
                transposeCellsLookup[Direction.LeftDown] = 22
                transposeCellsLookup[Direction.Left] = 15
                transposeCellsLookup[Direction.LeftUp] = 9
                transposeCellsLookup[Direction.RightUp] = 10
                transposeCellsLookup[Direction.Right] = 17
                transposeCellsLookup[Direction.RightDown] = 23
            }
            17 -> {
                transposeCellsLookup[Direction.LeftDown] = 23
                transposeCellsLookup[Direction.Left] = 16
                transposeCellsLookup[Direction.LeftUp] = 10
                transposeCellsLookup[Direction.RightUp] = 11
                transposeCellsLookup[Direction.Right] = 18
                transposeCellsLookup[Direction.RightDown] = 24
            }
            18 -> {
                transposeCellsLookup[Direction.LeftDown] = 24
                transposeCellsLookup[Direction.Left] = 17
                transposeCellsLookup[Direction.LeftUp] = 11
                transposeCellsLookup[Direction.RightUp] = 12
                transposeCellsLookup[Direction.Right] = 19
                transposeCellsLookup[Direction.RightDown] = 25
            }
            19 -> {
                transposeCellsLookup[Direction.LeftDown] = 25
                transposeCellsLookup[Direction.Left] = 18
                transposeCellsLookup[Direction.LeftUp] = 12
                transposeCellsLookup[Direction.RightUp] = 13
                transposeCellsLookup[Direction.Right] = 20
                transposeCellsLookup[Direction.RightDown] = 26
            }
            20 -> {
                transposeCellsLookup[Direction.LeftDown] = 26
                transposeCellsLookup[Direction.Left] = 19
                transposeCellsLookup[Direction.LeftUp] = 13
                transposeCellsLookup[Direction.RightUp] = 14
                transposeCellsLookup[Direction.Right] = 21
                transposeCellsLookup[Direction.RightDown] = 27
            }
            21 -> {
                transposeCellsLookup[Direction.LeftDown] = 27
                transposeCellsLookup[Direction.Left] = 20
                transposeCellsLookup[Direction.LeftUp] = 14
            }
            22 -> {
                transposeCellsLookup[Direction.LeftUp] = 15
                transposeCellsLookup[Direction.RightUp] = 16
                transposeCellsLookup[Direction.Right] = 23
                transposeCellsLookup[Direction.RightDown] = 28
            }
            23 -> {
                transposeCellsLookup[Direction.LeftDown] = 28
                transposeCellsLookup[Direction.Left] = 22
                transposeCellsLookup[Direction.LeftUp] = 16
                transposeCellsLookup[Direction.RightUp] = 17
                transposeCellsLookup[Direction.Right] = 24
                transposeCellsLookup[Direction.RightDown] = 29
            }
            24 -> {
                transposeCellsLookup[Direction.LeftDown] = 29
                transposeCellsLookup[Direction.Left] = 23
                transposeCellsLookup[Direction.LeftUp] = 17
                transposeCellsLookup[Direction.RightUp] = 18
                transposeCellsLookup[Direction.Right] = 25
                transposeCellsLookup[Direction.RightDown] = 30
            }
            25 -> {
                transposeCellsLookup[Direction.LeftDown] = 30
                transposeCellsLookup[Direction.Left] = 24
                transposeCellsLookup[Direction.LeftUp] = 18
                transposeCellsLookup[Direction.RightUp] = 19
                transposeCellsLookup[Direction.Right] = 26
                transposeCellsLookup[Direction.RightDown] = 31
            }
            26 -> {
                transposeCellsLookup[Direction.LeftDown] = 31
                transposeCellsLookup[Direction.Left] = 25
                transposeCellsLookup[Direction.LeftUp] = 19
                transposeCellsLookup[Direction.RightUp] = 20
                transposeCellsLookup[Direction.Right] = 27
                transposeCellsLookup[Direction.RightDown] = 32
            }
            27 -> {
                transposeCellsLookup[Direction.LeftDown] = 32
                transposeCellsLookup[Direction.Left] = 26
                transposeCellsLookup[Direction.LeftUp] = 20
                transposeCellsLookup[Direction.RightUp] = 21
            }
            28 -> {
                transposeCellsLookup[Direction.LeftUp] = 22
                transposeCellsLookup[Direction.RightUp] = 23
                transposeCellsLookup[Direction.Right] = 29
                transposeCellsLookup[Direction.RightDown] = 33
            }
            29 -> {
                transposeCellsLookup[Direction.LeftDown] = 33
                transposeCellsLookup[Direction.Left] = 28
                transposeCellsLookup[Direction.LeftUp] = 23
                transposeCellsLookup[Direction.RightUp] = 24
                transposeCellsLookup[Direction.Right] = 30
                transposeCellsLookup[Direction.RightDown] = 34
            }
            30 -> {
                transposeCellsLookup[Direction.LeftDown] = 34
                transposeCellsLookup[Direction.Left] = 29
                transposeCellsLookup[Direction.LeftUp] = 24
                transposeCellsLookup[Direction.RightUp] = 25
                transposeCellsLookup[Direction.Right] = 31
                transposeCellsLookup[Direction.RightDown] = 35
            }
            31 -> {
                transposeCellsLookup[Direction.LeftDown] = 35
                transposeCellsLookup[Direction.Left] = 30
                transposeCellsLookup[Direction.LeftUp] = 25
                transposeCellsLookup[Direction.RightUp] = 26
                transposeCellsLookup[Direction.Right] = 32
                transposeCellsLookup[Direction.RightDown] = 36
            }
            32 -> {
                transposeCellsLookup[Direction.LeftDown] = 36
                transposeCellsLookup[Direction.Left] = 31
                transposeCellsLookup[Direction.LeftUp] = 31
                transposeCellsLookup[Direction.RightUp] = 27
            }
            33 -> {
                transposeCellsLookup[Direction.LeftUp] = 28
                transposeCellsLookup[Direction.RightUp] = 29
                transposeCellsLookup[Direction.Right] = 34
            }
            34 -> {
                transposeCellsLookup[Direction.LeftUp] = 29
                transposeCellsLookup[Direction.RightUp] = 30
                transposeCellsLookup[Direction.Right] = 33
                transposeCellsLookup[Direction.Left] = 35
            }
            35 -> {
                transposeCellsLookup[Direction.LeftUp] = 30
                transposeCellsLookup[Direction.RightUp] = 31
                transposeCellsLookup[Direction.Right] = 34
                transposeCellsLookup[Direction.Left] = 36
            }
            36 -> {
                transposeCellsLookup[Direction.LeftUp] = 31
                transposeCellsLookup[Direction.RightUp] = 32
                transposeCellsLookup[Direction.Left] = 35
            }
        }
        // endregion
    }
}