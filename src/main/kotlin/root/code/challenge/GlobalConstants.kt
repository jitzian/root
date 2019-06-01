package root.code.challenge

class GlobalConstants {
    companion object {
        private const val driverCommand = "Driver"
        private const val tripCommand = "Trip"
        const val space = " "
        val setOfCommands = mutableMapOf(1 to driverCommand, 2 to tripCommand)
        const val quitCommand = "quit"
        const val byeByeMessage = "Closing command"
    }
}