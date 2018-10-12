
# Booking Go Technical Graduate Test

## How to use

Clone the repository :
```
git clone https://github.com/alinbr/BookingGoProject
```

Use Maven to build:
```
mvn clean compile assembly:single
```

Use Maven to check the tests:
```
mvn test
```

### Part 1 A

Run

Windows:
```
java -cp target\BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part1A [lat1] [long1] [lat2] [long2] [passengers]
```

Unix: 
```
java -cp target/BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part1A [lat1] [long1] [lat2] [long2] [passengers]
```

Replace **[lat1] [long1]** with desired longitude.
Replace **[lat2] [long2]** with desired latitude.
Replace **[passengers]** with the desired number of passengers. This argument is optional.

e.g:
```
java -cp target/BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part1A 1.1 1.2 3.4 4.3 3
```


 ### Part 1 B
 
Run

Windows:
```
java -cp target\BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part1B [lat1] [long1] [lat2] [long2] [passengers]
```

Unix: 
```
java -cp target/BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part1B [lat1] [long1] [lat2] [long2] [passengers]
```

Replace **[lat1] [long1]** with desired longitude.
Replace **[lat2] [long2]** with desired latitude.
Replace **[passengers]** with the desired number of passengers. This argument is optional.

e.g:
```
java -cp target/BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part1A 1.1 1.2 3.4 4.3 3
```

### Part 2

Run this command to start the server:

Windows:
```
java -cp target\BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part2`
```

Unix: 
```
java -cp target/BookingGoProject-1.0-SNAPSHOT-jar-with-dependencies.jar com.alin.musat.BookingGoProject.Part2
```

#### Api documentation

```
http://localhost:4567/bokkinggo?pickup=[lat1],[long1]&dropoff=[lat2,long2]&passengers=[passengers]
```

Replace **[lat1] [long1]** with desired longitude.
Replace **[lat2] [long2]** with desired latitude.
Replace **[passengers]** with the desired number of passengers. This argument is optional.

E.g:
```
http://localhost:4567/bookinggo?pickup=1,1&dropoff=1,1.0&passengers=1
```
