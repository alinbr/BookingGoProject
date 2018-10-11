package com.alin.musat.BookingGoProject.Logic;

import com.alin.musat.BookingGoProject.Models.GeoLocation;

import java.util.ArrayList;
import java.util.List;

/**
 * Main part of application.
 */
public class SearchEngine {


    private List<String> supplierEndPoints = new ArrayList<>();


    public SearchEngine() {}


    /**
     * Use this method to perform a new search.
     * @param pickUp Pick up geolocation
     * @param dropOff Drop off geolocation
     * @param numberOfPassengers Number of passengers.
     * @return Query response in for of a SearchResponse object.
     */
    public SearchResponse newSearch(GeoLocation pickUp, GeoLocation dropOff, int numberOfPassengers) {
        return null;
    }


    public void addSupplier(String endPoint) {
        supplierEndPoints.add(endPoint);
    }

    public void removeSupplier(String endPoint) {
        supplierEndPoints.removeIf(s -> s.equals(endPoint));
    }

}
