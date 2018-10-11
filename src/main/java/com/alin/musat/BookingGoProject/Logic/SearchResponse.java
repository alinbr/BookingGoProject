package com.alin.musat.BookingGoProject.Logic;

import com.alin.musat.BookingGoProject.Models.Ride;
import com.alin.musat.BookingGoProject.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * This object is returned by SearchEngine's method newSearch().
 */
public class SearchResponse {

    private List<Ride> resultsList;


    public SearchResponse() {
        resultsList = new ArrayList<>();
    }


    /**
     * Method used in Part 1 for Dave's cars.
     * It prints the results in 'CAR-TYPE - PRICE' format.
     */
    public void printResultsWhenSingleSupplier() {

        if (resultsList.size() == 0) {
            System.out.println("There are no results to display.");
            System.out.println("This might be because the server failed to give a valid response");
            System.out.println("Rerun the program to try again.");
        }

        for (Ride ride : resultsList) {
            System.out.println(ride.getCarType() + " - " + ride.getPrice());
        }
    }

    public void printResultsWhenAllSuppliers() {

        for (Map.Entry<String, Integer> entry : Utilities.maxPassengersOf.entrySet())
        {
            Ride cheapest = getCheapest(entry.getKey());

            if (cheapest != null) {
                System.out.println(cheapest.getCarType() + " - " + cheapest.getSupplier() + " - " + cheapest.getPrice());
            } else {
                System.out.println(entry.getKey() + " - no car found");
            }
        }

    }


    /**
     * Get cheapest car of [TYPE].
     * @param carType Car type
     * @return The cheapest option, if any.
     */
    public Ride getCheapest(String carType) {

        long minPrice = Long.MAX_VALUE;
        Ride cheapestResult = null;

        for (Ride result: resultsList)
        {
            if (result.getCarType().equals(carType) && result.getPrice() < minPrice) {
                minPrice = result.getPrice();
                cheapestResult = result;
            }
        }
        return cheapestResult;
    }


    /**
     * Sort the results in price descending order.
     */
    public void sortPriceDescending() {
        resultsList.sort((o1, o2) -> (o2.getPrice() - o1.getPrice()) > 0 ? 1 : -1);
    }

    /**
     * Remove cars that do not have enough seats.
     * @param numberOfPassengers Number of passengers.
     */
    public void removeIrrelevantResults(int numberOfPassengers) {
        resultsList.removeIf(o -> numberOfPassengers > Utilities.maxPassengersOf.get(o.getCarType()));
    }


    public List<Ride> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Ride> resultsList) { this.resultsList = resultsList; }



}
