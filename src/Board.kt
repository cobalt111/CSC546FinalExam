data class Board(val filledSlotLedger: List<Slot>) {
    var slots = mutableListOf<Slot>()

    init {
        for (slotNumber in IntRange(0, 14)) {
            slots.add(slotNumber, Slot(true, slotNumber))
            if (!filledSlotLedger[slotNumber].hasPeg())
                slots[slotNumber].filled = false
        }
    }
}