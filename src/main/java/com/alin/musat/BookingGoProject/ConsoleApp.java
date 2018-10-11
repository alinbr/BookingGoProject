package com.alin.musat.BookingGoProject;

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

    }

    /**
     * Part 1 - Search results for all suppliers.
     * @param args "all", longitude, latitude and number of passenger.
     */
    public static void DoPart1AllSearch(String[] args) {

    }



}
