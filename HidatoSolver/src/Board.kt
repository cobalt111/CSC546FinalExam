class Board(internal val startPosition: Int, internal val endPosition: Int) {

    /*
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
        for (i in 0..36)
            cells.add(Cell(0, i))
        cells[startPosition] = Cell(1, startPosition)
        cells[endPosition] = Cell(numberOfCells, endPosition)
    }

    internal fun print() {
        println()
        for (cell in cells)
            println(cell.number)
        println()
    }
}