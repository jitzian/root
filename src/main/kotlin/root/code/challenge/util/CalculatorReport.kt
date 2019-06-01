package root.code.challenge.util

import root.code.challenge.model.Trip
import java.text.SimpleDateFormat
import java.util.concurrent.TimeUnit


//v = d/t
class CalculatorReport {

    fun calculateTimeDifferenceInMinutes(trip: Trip): Long {

        val timeStart = trip.startTime
        val timeEnd = trip.endTime

        val sdf = SimpleDateFormat("HH:mm")
        val dateStart = sdf.parse(timeStart)
        val dateEnd = sdf.parse(timeEnd)

        return TimeUnit.MILLISECONDS.toMinutes(dateEnd.time.plus(-dateStart.time))

    }

    fun calculateVelocity(totalTime: Long, totalDistance: Float): Float = totalDistance / (totalTime / 60)


}