package com.alin.musat.BookingGoProject;

import com.alin.musat.BookingGoProject.Logic.SearchEngine;
import com.alin.musat.BookingGoProject.Logic.SearchResponse;
import com.alin.musat.BookingGoProject.Models.GeoLocation;

import static com.alin.musat.BookingGoProject.Utilities.*;

/**
 * Part 1 - Console Application
 *
 */
public class ConsoleApp
{
    public static void main( String[] args )
    {

        if (!validateArguments(args)) {

            printHelpMessage();

            System.exit(0);
        }

        if (args[0].equals("dave")) {
            DoPart1DaveSearch(args);
        } else if (args[0].equals("all")) {
            DoPart1AllSearch(args);
        }

    }


    /**
     * Part 1 - Search results for Dave's taxi.
     * @param args "dave", longitude, latitude and number of passengers.
     */
    public static void DoPart1DaveSearch(String[] args) {

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.addSupplier(Utilities.DAVE_API);

        GeoLocation pickUp = new GeoLocation(Double.parseDouble(args[1]), Double.parseDouble(args[2]));
        GeoLocation dropOff = new GeoLocation(Double.parseDouble(args[3]),Double.parseDouble(args[4]));
        int numberOfPassengers = Integer.parseInt(args[5]);

        SearchResponse searchResponse = searchEngine.newSearch(pickUp, dropOff, numberOfPassengers);

    }

    /**
     * Part 1 - Search results for all suppliers.
     * @param args "all", longitude, latitude and number of passenger.
     */
    public static void DoPart1AllSearch(String[] args) {

    }



}
