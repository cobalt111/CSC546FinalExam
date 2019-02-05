data class Board(val initialEmptySlotNumber: Int?, val board: Board?) {
    var slots = mutableListOf<Slot>()

    init {
        if (board != null) {
            for (slotNumber in IntRange(0, Slot.NUMBER_OF_SLOTS)) {
                if (board.slots[slotNumber].filled)
                    slots.add(Slot(true, slotNumber))
                else slots.add(Slot(false, slotNumber))
            }
        }
        else {
            for (slotNumber in IntRange(0, Slot.NUMBER_OF_SLOTS)) {
                if (initialEmptySlotNumber != null && slotNumber == initialEmptySlotNumber)
                    slots.add(Slot(false, slotNumber))
                else slots.add(Slot(true, slotNumber))
            }
        }
    }

    fun print() {
        println("\n----------")
        var firstSlot = if (slots[0].hasPeg()) 1 else 0
        println("    $firstSlot    ")
        firstSlot = if (slots[1].hasPeg()) 1 else 0
        var secondSlot = if (slots[2].hasPeg()) 1 else 0
        println("   $firstSlot $secondSlot   ")
        firstSlot = if (slots[3].hasPeg()) 1 else 0
        secondSlot = if (slots[4].hasPeg()) 1 else 0
        var thirdSlot = if (slots[5].hasPeg()) 1 else 0
        println("  $firstSlot $secondSlot $thirdSlot  ")
        firstSlot = if (slots[6].hasPeg()) 1 else 0
        secondSlot = if (slots[7].hasPeg()) 1 else 0
        thirdSlot = if (slots[8].hasPeg()) 1 else 0
        var fourthSlot = if (slots[9].hasPeg()) 1 else 0
        println(" $firstSlot $secondSlot $thirdSlot $fourthSlot ")
        firstSlot = if (slots[10].hasPeg()) 1 else 0
        secondSlot = if (slots[11].hasPeg()) 1 else 0
        thirdSlot = if (slots[12].hasPeg()) 1 else 0
        fourthSlot = if (slots[13].hasPeg()) 1 else 0
        val fifthSlot = if (slots[14].hasPeg()) 1 else 0
        println("$firstSlot $secondSlot $thirdSlot $fourthSlot $fifthSlot")
        println("----------")
    }
}