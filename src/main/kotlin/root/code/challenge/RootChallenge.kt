package root.code.challenge

import root.code.challenge.GlobalConstants.Companion.byeByeMessage
import root.code.challenge.GlobalConstants.Companion.space
import root.code.challenge.model.Calculation
import root.code.challenge.util.CalculatorReport

val driver = mutableMapOf<String, ArrayList<Calculation>>()

fun main() {
    var inputLine: String

    captureFromKeyboard@ while (true) {
        inputLine = readLine().toString()

        when (inputLine) {
            //quit
            GlobalConstants.quitCommand.toLowerCase() -> {
                println(byeByeMessage)
                for ((key, totalTrip) in driver) {
                    println(CalculatorReport().calculateDistanceAndVelocityPerDriver(key, totalTrip))
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
        5 -> {
            if (!driver.containsKey(arrayOfInput[1])) {
                driver[arrayOfInput[1]] = arrayListOf(
                    Calculation(
                        arrayOfInput[4].toFloat(),
                        (CalculatorReport().calculateTimeDifferenceInMinutes(arrayOfInput[2], arrayOfInput[3])) / 60
                    )
                )
            } else {
                val listOfCalculation = driver[arrayOfInput[1]]
                val newCalculation = Calculation(
                    arrayOfInput[4].toFloat(),
                    (CalculatorReport().calculateTimeDifferenceInMinutes(arrayOfInput[2], arrayOfInput[3])) / 60
                )
                listOfCalculation?.add(newCalculation)
                listOfCalculation?.let { driver.replace(arrayOfInput[1], it) }
            }

        }
    }
}
