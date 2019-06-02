package root.code.challenge.util

import root.code.challenge.model.Calculation
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit
import kotlin.math.roundToLong

class CalculatorReport {

    fun calculateTimeDifferenceInMinutes(timeStart: String, timeEnd: String): Float {
        val sdf = SimpleDateFormat("HH:mm")
        val dateStart = sdf.parse(timeStart)
        val dateEnd = sdf.parse(timeEnd)
        return (TimeUnit.MILLISECONDS.toMinutes(dateEnd.time.plus(-dateStart.time))).toFloat()
    }

    fun calculateDistanceAndVelocityPerDriver(driver: String, listOfCalculations: ArrayList<Calculation>) : String{
        var totalMiles = 0F
        var totalTime = 0F
        val velocity: Long

        for (calculation in listOfCalculations){
            with(calculation){
                totalMiles += miles
                totalTime += timeInHours
            }
        }

        velocity = (totalMiles / totalTime).toLong()
        return "$driver: ${totalMiles.roundToLong()} miles @ $velocity mph"
    }

}