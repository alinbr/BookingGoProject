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


    public static void DoPart1DaveSearch(String[] args) {

    }

    public static void DoPart1AllSearch(String[] args) {

    }



}
