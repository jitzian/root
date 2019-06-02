package root.code.challenge.util


import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test
import root.code.challenge.model.Calculation


class CalculatorReportTest {
    lateinit var subject: CalculatorReport
    @Before
    fun setup() {
        subject = CalculatorReport()
    }

    @Test
    fun whenValidStartTimeAndValidEndTimeAreProvidedThenReturnDifferenceBetweenThem() {
        assertEquals(30F, subject.calculateTimeDifferenceInMinutes("07:15", "07:45"))
    }

    @Test
    fun whenValidStartTimeAndInvalidEndTimeAreProvidedThenReturnZeroFloat() {
        assertEquals(0F, subject.calculateTimeDifferenceInMinutes("07:15", ""))
    }

    @Test
    fun whenInvalidStartTimeAndValidEndTimeAreProvidedThenReturnZeroFloat() {
        assertEquals(0F, subject.calculateTimeDifferenceInMinutes("", "07:45"))
    }

    @Test
    fun whenInvalidStartTimeAndInvalidEndTimeAreProvidedThenReturnZeroFloat() {
        assertEquals(0F, subject.calculateTimeDifferenceInMinutes("", ""))
    }

    @Test
    fun whenNullStartTimeAndValidEndTimeAreProvidedThenReturnZeroFloat() {
        assertEquals(0F, subject.calculateTimeDifferenceInMinutes(null, "07:15"))
    }

    @Test
    fun whenNullStartTimeAndInvalidEndTimeAreProvidedThenReturnZeroFloat() {
        assertEquals(0F, subject.calculateTimeDifferenceInMinutes(null, ""))
    }

    @Test
    fun whenValidStartTimeAndNullEndTimeAreProvidedThenReturnZeroFloat() {
        assertEquals(0F, subject.calculateTimeDifferenceInMinutes("07:15", null))
    }

    @Test
    fun whenInvalidStartTimeAndNullEndTimeAreProvidedThenReturnZeroFloat() {
        assertEquals(0F, subject.calculateTimeDifferenceInMinutes("", null))
    }

    @Test
    fun whenNullStartTimeAndNullEndTimeAreProvidedThenReturnZeroFloat() {
        assertEquals(0F, subject.calculateTimeDifferenceInMinutes(null, null))
    }

    @Test
    fun whenValidHistoryOfDrivingIsProvidedThenReturnValidTraveledDistanceInMilesAndSpeedMustBeGreaterThanZero() {
        val subbingValidArrayListOfCalculations = mutableListOf(
            Calculation(20F, 1.5F),
            Calculation(42F, .5F),
            Calculation(33F, .8F)
        )
        val (milesPerDriver, velocity) = subject.calculateDistanceAndVelocityPerDriver(subbingValidArrayListOfCalculations as ArrayList<Calculation>)
        assertEquals(95, milesPerDriver)
        assertNotEquals(0, velocity)
    }


    @Test
    fun whenValidHistoryOfDrivingIsProvidedWithMilesDrivenAsZeroAndTimeGreaterThanZeroThenReturnZeroAsMilesAndZeroAsVelocity() {
        val subbingValidArrayListOfCalculations = mutableListOf(
            Calculation(0F, 1.5F)
        )
        val (milesPerDriver, velocity) = subject.calculateDistanceAndVelocityPerDriver(subbingValidArrayListOfCalculations as ArrayList<Calculation>)
        assertEquals(0, milesPerDriver)
        assertEquals(0, velocity)
    }

    @Test
    fun whenEmptySetOfCalculationsIsProvidedThenReturnZeroAsMilesAndZeroAsVelocity() {
        val subbingValidArrayListOfCalculations = mutableListOf<Calculation>()
        val (milesPerDriver, velocity) = subject.calculateDistanceAndVelocityPerDriver(subbingValidArrayListOfCalculations as ArrayList<Calculation>)
        assertEquals(0, milesPerDriver)
        assertEquals(0, velocity)
    }


}