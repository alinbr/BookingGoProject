package com.alin.musat.BookingGoProject;

import com.alin.musat.BookingGoProject.Logic.SearchEngine;
import com.alin.musat.BookingGoProject.Logic.SearchResponse;
import com.alin.musat.BookingGoProject.Models.GeoLocation;

import static com.alin.musat.BookingGoProject.Utilities.printHelpMessage;
import static com.alin.musat.BookingGoProject.Utilities.validateArguments;

public class Part1B {


    public static void main( String[] args ) {

        if (!validateArguments(args)) {
            printHelpMessage();
            System.exit(0);
        }

        SearchEngine searchEngine = new SearchEngine();
        searchEngine.addSupplier(Utilities.DAVE_API);
        searchEngine.addSupplier(Utilities.ERIC_API);
        searchEngine.addSupplier(Utilities.JEFF_API);

        GeoLocation pickUp = new GeoLocation(Double.parseDouble(args[0]), Double.parseDouble(args[1]));
        GeoLocation dropOff = new GeoLocation(Double.parseDouble(args[2]), Double.parseDouble(args[3]));

        SearchResponse searchResponse;
        if (args.length == 5) {
            int numberOfPassengers = Integer.parseInt(args[4]);
            searchResponse = searchEngine.newSearch(pickUp, dropOff, numberOfPassengers);
        } else {
            searchResponse = searchEngine.newSearch(pickUp, dropOff, 0);
        }

        searchResponse.printResultsWhenAllSuppliers();

    }
}
