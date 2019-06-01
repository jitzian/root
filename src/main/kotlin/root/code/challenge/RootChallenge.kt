package root.code.challenge

import root.code.challenge.GlobalConstants.Companion.byeByeMessage
import root.code.challenge.GlobalConstants.Companion.space
import root.code.challenge.model.TotalTrip
import root.code.challenge.model.Trip
import root.code.challenge.util.CalculatorReport
import root.code.challenge.util.safeLet

val setOfDrivers = LinkedHashSet<String>()
val driverStatisticsMap = mutableMapOf<String, TotalTrip>()

fun main() {

    var inputLine: String

    captureFromKeyboard@ while (true) {
        inputLine = readLine().toString()

        when (inputLine) {
            //quit
            GlobalConstants.quitCommand.toLowerCase() -> {
                println(byeByeMessage)
                for ((key, value) in driverStatisticsMap) {
                    println("$key = $value")
                }
                break@captureFromKeyboard
            }

            else -> {
                checkInput(inputLine)
                continue@captureFromKeyboard
            }
        }
    }
}

fun checkInput(input: String) {
    val arrayOfInput = input.split(space)
    when (arrayOfInput.size) {
        2 -> {
            setOfDrivers.add(arrayOfInput[1])
        }
        5 -> {
            val trip = Trip(arrayOfInput[1],
                arrayOfInput[2],
                arrayOfInput[3],
                arrayOfInput[4].toFloat()
            )

            if (!driverStatisticsMap.containsKey(arrayOfInput[1])) {
                driverStatisticsMap[arrayOfInput[1]] = TotalTrip(CalculatorReport().calculateTimeDifferenceInMinutes(trip), arrayOfInput[4].toFloat())
            } else {
                safeLet(driverStatisticsMap[arrayOfInput[1]]?.totalTime?.plus(arrayOfInput[4].toFloat())?.toLong(),
                    driverStatisticsMap[arrayOfInput[1]]?.totalDistance?.plus(arrayOfInput[4].toFloat())){
                        time, distance ->
                    val newTotalTrip = TotalTrip(time, distance)
                    driverStatisticsMap.replace(arrayOfInput[1], newTotalTrip)
                }
            }

        }
    }
}
