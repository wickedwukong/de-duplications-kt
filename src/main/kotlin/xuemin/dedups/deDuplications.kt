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
            // If we are at the end of the list, we can just add the remaining elements
            result.add(currentValue)
            i++
        }
    }
    return result.toList()
}

fun isDuplicates(currentWithLookAhead: List<String>): Boolean {
    return currentWithLookAhead.toSet().size == 1
}
