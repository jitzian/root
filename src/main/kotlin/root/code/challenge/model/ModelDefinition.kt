package root.code.challenge.model

data class Trip(
    var driver: String,
    var startTime: String,
    var endTime: String,
    var miles: Float
)

data class TotalTrip(var totalTime: Long, var totalDistance: Float)