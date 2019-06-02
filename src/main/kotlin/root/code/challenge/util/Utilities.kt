package root.code.challenge.util

fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

//fun sortListOfPairsFromHighestToLowest(list: List<Pair<Int, Long>>): List<Pair<Int, Long>>{
//    return list.sortedWith(compareBy { it.second }).reversed()
//}
fun sortListOfPairsFromHighestToLowest(list: List<Pair<Int, Long>>): List<Pair<Int, Long>>{
    val milesComparator = compareBy<Pair<Int, Long>> { it.first }
    list.sortedWith(milesComparator)
    return list.sortedWith(compareBy { it.first }).reversed()
}