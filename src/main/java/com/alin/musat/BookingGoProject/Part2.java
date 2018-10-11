package com.alin.musat.BookingGoProject;

import com.alin.musat.BookingGoProject.Models.Ride;
import com.google.gson.Gson;
import spark.Spark;

import java.util.Scanner;

import static spark.Spark.*;

public class Part2 {

    public static void main(String[] args) {


        get("/bookinggo", "application/json", (request,response)->{

            response.type("application/json");

            String pickUp = request.queryParams("pickup");
            String dropOff = request.queryParams("dropoff");
            String numberOfPassengers = request.queryParams("passengers");

            if (pickUp == null) {
                response.status(400);
                return "{\"message\":\"Required String parameter 'pickup' is not present\"}";
            } else if (!checkPickUp(pickUp)) {
                response.status(400);
                return "{\"message\":\"Pick up is not valid. Example of valid pick up: 2.345,1.123\"}";
            }

            if (dropOff == null) {
                response.status(400);
                return "{\"message\":\"Required String parameter 'dropoff' is not present\"}";
            } else if (!checkDropOff(dropOff)) {
                response.status(400);
                return "{\"message\":\"Drop off is not valid. Example of valid drop off: 2.345,1.123\"}";
            }

            if (!checkPassengers(numberOfPassengers)) {
                response.status(400);
                return "{\"message\":\"Passengers number invalid. Please enter a positive integer.\"}";
            }
            

            Ride ride = new Ride("aaa", 123, "sadas");
            return new Gson().toJson(ride);
        });

        Spark.notFound((req, res) -> {
            res.type("application/json");
            return "{\"message\":\"Invalid url. Please check documentation.\"}";
        });



    }

    private static boolean checkPassengers(String numberOfPassengers) {
        return true;
    }

    private static boolean checkDropOff(String pickUp) {
        return true;
    }

    private static boolean checkPickUp(String pickUp) {
        return true;
    }

}
