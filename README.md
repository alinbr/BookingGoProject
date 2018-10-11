
# Booking Go Technical Graduate Test

## How to use

Clone the repository `https://github.com/alinbr/BookingGoProject`

Use Maven to build `mvn clean compile assembly:single`

Use Maven to test `mvn clean compile assembly:single`

### Part 1 A

Run
`java -cp target\BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part1A 1.1 2.1 3.1 4.1 5`

Replace 1.1 2.1 with desired longitude
Replace 3.1 4.1 with desired latitude
Replace 5 with the desired number of passengers. This argument is optional.

 ### Part 1 B
 
 Run
`java -cp target\BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part1B 1.1 2.1 3.1 4.1 5`

Replace 1.1 2.1 with desired longitude
Replace 3.1 4.1 with desired latitude
Replace 5 with the desired number of passengers. This argument is optional.

### Part 2

Run
`java -cp target\BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part2`

#### Example of request

`http://localhost:4567/bookinggo?pickup=1,1&dropoff=1,1.0&passengers=1`
