package com.alin.musat.BookingGoProject;

import java.util.HashMap;
import java.util.Map;

public class Utilities {

    public static final String DAVE_API = "https://techtest.rideways.com/dave";
    public static final String ERIC_API = "https://techtest.rideways.com/eric";
    public static final String JEFF_API = "https://techtest.rideways.com/jeff";


    /**
     * Static map of every car type and their max number of passengers.
     */
    public static final Map<String, Integer> maxPassengersOf = new HashMap<>();

    static {
        maxPassengersOf.put("STANDARD", 4);
        maxPassengersOf.put("EXECUTIVE", 4);
        maxPassengersOf.put("LUXURY", 4);
        maxPassengersOf.put("PEOPLE_CARRIER", 6);
        maxPassengersOf.put("LUXURY_PEOPLE_CARRIER", 6);
        maxPassengersOf.put("MINIBUS", 16);
    }


    /**
     * Checks if a string can be converted to a positive integer.
     * @param str The string to be converted.
     * @return True if the string can be converted.
     */
    public static boolean isPositiveInteger(String str) {
        try {
            Integer number = Integer.parseInt(str);
            return number >= 0;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Checks if a string can be converted to a double.
     * @param str The string to be converted
     * @return True if the string can be converted.
     */
    public static boolean isDouble(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * Validates the command line arguments.
     * @param args The command line arguments.
     * @return True if the arguments are valid.
     */
    public static boolean validateArguments(String[] args) {
        if (args.length != 6 ||
                !(args[0].equals("dave") || args[0].equals("all")) ||
                !isDouble(args[1]) ||
                !isDouble(args[2]) ||
                !isDouble(args[3]) ||
                !isDouble(args[4]) ||
                !isPositiveInteger(args[5])) {

            return false;
        }

        return true;
    }

    /**
     * Utility method to print a help message if the command line arguments are wrong.
     */
    public static void printHelpMessage() {
        System.out.println("Invalid arguments!");
        System.out.println("e.g: [part] 23.43 12.34 12.4 12.345 4");
        System.out.println("[part] can be either 'dave' or 'all'");
        System.out.println("Next 4 numbers indicate the long & latitude.");
        System.out.println("Last argument is the number of passengers.");
    }


}
