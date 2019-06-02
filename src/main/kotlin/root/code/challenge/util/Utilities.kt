package root.code.challenge.util

// I created this function for validating 2 different type of arguments at the same time and check if both of them are not Null
// So, we can avoid having nested var?.let { it.let{.. } }. This makes code more readable in my opinion..
fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

// This function makes the sorting by velocity/speed from highest to lowest
// Initially I was using a Pair. However, I found it more straight forward if instead of concatenating the
// name of the driver at the very end, I'd do it using a Triple and everything fit in one single shot =D
fun sortListOfPairsFromHighestToLowest(list: List<Triple<String, Int, Long>>): List<Triple<String, Int, Long>>{
    val milesComparator = compareBy<Triple<String, Int, Long>> { it.second }
    list.sortedWith(milesComparator)
    return list.sortedWith(compareBy { it.second }).reversed()
}