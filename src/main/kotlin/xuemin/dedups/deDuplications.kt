package xuemin.dedups

fun deDuplications(listOfStrings: List<String>, limit: Int): List<String> {
   val result = mutableListOf<String>()

    var currentIndex = 0
    while (currentIndex < listOfStrings.size) {
        var count = 0
        val currentValue = listOfStrings[currentIndex]

        while (currentIndex + count < listOfStrings.size && listOfStrings[currentIndex + count] == currentValue) {
            count++
        }

        if (count <= limit) {
            repeat(count) { result.add(currentValue) }
        }
        currentIndex += count
    }
    return result.toList()
}
