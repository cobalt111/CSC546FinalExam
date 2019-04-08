class Board(startPosition: Int) {

    /* Shape of the board:

            0 0 0 0
           0 0 0 0 0
          0 0 0 0 0 0
         0 0 0 0 0 0 0
          0 0 0 0 0 0
           0 0 0 0 0
            0 0 0 0
     */

    internal val numberOfCells = 37
    internal val cells = mutableListOf<Cell>()

    init {
        for (i in 0 until numberOfCells)
            cells.add(Cell(false, i))
        cells[startPosition].filled = true
        cells[startPosition].boardSlotNumber = startPosition


    }



    internal fun print() {
        println("""
            ${printCellsByLine(1)}
           ${printCellsByLine(2)}
          ${printCellsByLine(3)}
         ${printCellsByLine(4)}
          ${printCellsByLine(5)}
           ${printCellsByLine(6)}
            ${printCellsByLine(7)}
        """)
    }

    private fun printCellsByLine(line: Int): String {
        val builder = StringBuilder()
        var beginningOfLine = 0
        var endOfLine = 0
        when (line) {
            1 -> {
                beginningOfLine = 0
                endOfLine = 3
            }
            2 -> {
                beginningOfLine = 4
                endOfLine = 8
            }
            3 -> {
                beginningOfLine = 9
                endOfLine = 14
            }
            4 -> {
                beginningOfLine = 15
                endOfLine = 21
            }
            5 -> {
                beginningOfLine = 22
                endOfLine = 27
            }
            6 -> {
                beginningOfLine = 28
                endOfLine = 32
            }
            7 -> {
                beginningOfLine = 33
                endOfLine = 36
            }
            else -> {
            }
        }
        for (i in beginningOfLine..endOfLine) {
            if (cells[i].filled) builder.append("1 ")
            else builder.append("0 ")
        }
        return builder.toString()
    }
}