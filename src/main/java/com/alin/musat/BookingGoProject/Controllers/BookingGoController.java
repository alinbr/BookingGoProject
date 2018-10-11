package com.alin.musat.BookingGoProject.Controllers;

import com.alin.musat.BookingGoProject.Logic.SearchEngine;
import com.alin.musat.BookingGoProject.Logic.SearchResponse;
import com.alin.musat.BookingGoProject.Logic.Utilities;
import com.alin.musat.BookingGoProject.Models.GeoLocation;
import com.google.gson.Gson;
import spark.Spark;

import static spark.Spark.*;

public class BookingGoController {

    public  BookingGoController() {


        Spark.get("/bookinggo", "application/json", (request,response)->{

            SearchEngine searchEngine = new SearchEngine();
            searchEngine.addSupplier(Utilities.DAVE_API);
            searchEngine.addSupplier(Utilities.ERIC_API);
            searchEngine.addSupplier(Utilities.JEFF_API);

            response.type("application/json");

            // Get data from query
            String pickUp = request.queryParams("pickup");
            String dropOff = request.queryParams("dropoff");
            String numberOfPassengers = request.queryParams("passengers");

            // Check pick up
            if (pickUp == null) {
                response.status(400);
                return "{\"message\":\"Required String parameter 'pickup' is not present\"}";
            }

            GeoLocation pickUpLocation = extractLocation(pickUp);

            if (pickUpLocation == null) {
                response.status(400);
                return "{\"message\":\"Pick up is not valid. Example of valid pick up: 2.345,1.123\"}";
            }

            // Check drop off
            if (dropOff == null) {
                response.status(400);
                return "{\"message\":\"Required String parameter 'dropoff' is not present\"}";
            }

            GeoLocation dropOffLocation = extractLocation(dropOff);

            if (dropOffLocation == null) {
                response.status(400);
                return "{\"message\":\"Drop off is not valid. Example of valid drop off: 2.345,1.123\"}";
            }

            // Check passengers
            if (!checkPassengers(numberOfPassengers)) {
                response.status(400);
                return "{\"message\":\"Passengers number invalid. Please enter a positive integer.\"}";
            }

            SearchResponse searchResponse;

            if (numberOfPassengers == null) {
                searchResponse = searchEngine.newSearch(pickUpLocation, dropOffLocation);
            } else {
                searchResponse = searchEngine.newSearch(pickUpLocation, dropOffLocation,Integer.parseInt(numberOfPassengers));
            }

            return new Gson().toJson(searchResponse.getCheapestRides());
        });

        Spark.notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Invalid url. Please check documentation.\"}";
        });

        Spark.put("*", "application/json", (request,response)->{
            response.type("application/json");
            return "{\"message\":\"Invalid request. Please check documentation.\"}";
        });

        Spark.delete("*", "application/json", (request,response)->{
            response.type("application/json");
            return "{\"message\":\"Invalid request. Please check documentation.\"}";
        });

        Spark.post("*", "application/json", (request,response)->{
            response.type("application/json");
            return "{\"message\":\"Invalid request. Please check documentation.\"}";
        });
    }

    private static boolean checkPassengers(String numberOfPassengers) {

        if (numberOfPassengers == null || Utilities.isPositiveInteger(numberOfPassengers)) {
            return true;
        }

        return false;
    }


    private static GeoLocation extractLocation(String location) {

        String[] coordinates = location.split(",");

        if (!(Utilities.isDouble(coordinates[0]) && Utilities.isDouble(coordinates[1]))) {
            return null;
        }

        return new GeoLocation(Double.parseDouble(coordinates[0]),Double.parseDouble(coordinates[1]));
    }

}
