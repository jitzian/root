package root.code.challenge.util

import root.code.challenge.model.Calculation
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import kotlin.math.roundToInt
import kotlin.system.exitProcess

class CalculatorReport {

    //This function will calculate the difference between the 2 inputs (startTime and endTime)
    fun calculateTimeDifferenceInMinutes(timeStart: String?, timeEnd: String?): Float {
        var resultToReturn = 0F
        safeLet(timeStart, timeEnd) { start, end ->
            try {
                val sdf = SimpleDateFormat("HH:mm")
                val dateStart = sdf.parse(start)
                val dateEnd = sdf.parse(end)
                resultToReturn = (TimeUnit.MILLISECONDS.toMinutes(dateEnd.time.plus(-dateStart.time))).toFloat()
            } catch (pe: ParseException) {
                println("CalculatorReport::calculateTimeDifferenceInMinutes::${pe.message}")
                exitProcess(1)
            }
        }
        return resultToReturn
    }

    //In this function, given valid input, it returns the Distance and Velocity/Speed per driver as a Pair<miles, velocity>
    fun calculateDistanceAndVelocityPerDriver(listOfCalculations: ArrayList<Calculation>): Pair<Int, Long> {
        var totalMiles = 0F
        var totalTime = 0F
        val velocity: Long

        for (calculation in listOfCalculations) {
            with(calculation) {
                totalMiles += miles
                totalTime += timeInHours
            }
        }

        velocity = (totalMiles / totalTime).toLong()

        return Pair(totalMiles.roundToInt(), velocity)
    }

}