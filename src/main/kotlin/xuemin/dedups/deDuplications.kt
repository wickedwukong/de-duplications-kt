package xuemin.dedups


fun deDuplications(listOfStrings: List<String>, limit: Int): List<String> {
    val result = mutableListOf<String>()
    var i = 0
    while (i < listOfStrings.size) {
        val currentValue = listOfStrings[i]
        if (i + limit  < listOfStrings.size) {
            val currentWithLookAhead = listOfStrings.subList(i, i + limit + 1)
            if (isDuplicates(currentWithLookAhead)) {
                i += limit + 1
            } else {
                result.add(currentValue)
                i++
            }
        } else {
            result.addAll(listOfStrings.subList(i, listOfStrings.size))
            i = listOfStrings.size
        }
    }
    return result.toList()
}

private fun isDuplicates(currentWithLookAhead: List<String>): Boolean {
    return currentWithLookAhead.toSet().size == 1
}
