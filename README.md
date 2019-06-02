# ROOT

Let's write some code to track driving history for people.

The code will process an input file. You can either choose to accept the input via stdin (e.g. if you're using Ruby cat input.txt | ruby yourcode.rb), or as a file name given on the command line (e.g. ruby yourcode.rb input.txt). You can use any programming language that you want. Please choose a language that allows you to best demonstrate your programming ability.

Each line in the input file will start with a command. There are two possible commands.

The first command is Driver, which will register a new Driver in the app. Example:

Driver Dan

The second command is Trip, which will record a trip attributed to a driver. The line will be space delimited with the following fields: the command (Trip), driver name, start time, stop time, miles driven. Times will be given in the format of hours:minutes. We'll use a 24-hour clock and will assume that drivers never drive past midnight (the start time will always be before the end time). Example:

Trip Dan 07:15 07:45 17.3

Discard any trips that average a speed of less than 5 mph or greater than 100 mph.

Generate a report containing each driver with total miles driven and average speed. Sort the output by most miles driven to least. Round miles and miles per hour to the nearest integer.

Example input:

Driver Dan
Driver Alex
Driver Bob
Trip Dan 07:15 07:45 17.3
Trip Dan 06:12 06:32 21.8
Trip Alex 12:01 13:16 42.0


## Installation

Just import project

## Usage

TODO: Write usage instructions

## Documentation

#####ModelDefinition.kt: 
Data class that holds the miles and time in hours as a model class

#####Utilities.kt: 
This class holds to main functionalities
 - safeLet: Used to evaluate if 2 provided parameters that are required to perform an operation are not NULL. 
            With the use of this function we eliminate the need of doing nested var.let { .. var2.let{ ... } }
 - sortListOfPairsFromHighestToLowest: Receives a List<Triple <String, Int, Long>> and returns the same list
                                       sorted by the second parameter (Int=miles)   

#####CalculatorReport.kt: 
This is where the fun happens. Once valid input is captured from the keyboard then Timing between 2 given interval will be calculated (calculateTimeDifferenceInMinutes) and Distance will also be calculated (calculateDistanceAndVelocityPerDriver) making use of model class.

#####RootChallenge.kt: 
Nothing but main class that captures the input data from keyboard and prints results processed by CalculatorReport.kt 

## Running Tests

Just Run TestClass.kt

## License

TODO: Just playing