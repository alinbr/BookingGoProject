package com.alin.musat.BookingGoProject;

public class Utilities {


    public static boolean validateArguments(String[] args) {
        return  true;
    }

    public static void printHelpMessage() {
        System.out.println("Invalid arguments!");
        System.out.println("e.g: [part] 23.43 12.34 12.4 12.345 4");
        System.out.println("[part] can be either 'dave' or 'all'");
        System.out.println("Next 4 numbers indicate the long & latitude.");
        System.out.println("Last argument is the number of passengers.");
    }



}
