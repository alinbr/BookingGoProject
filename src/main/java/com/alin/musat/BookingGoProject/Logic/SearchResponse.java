package com.alin.musat.BookingGoProject.Logic;

import com.alin.musat.BookingGoProject.Models.Result;

import java.util.ArrayList;
import java.util.List;

/**
 * This object is returned by SearchEngine's method newSearch().
 */
public class SearchResponse {

    private List<Result> resultsList;


    public SearchResponse() {
        resultsList = new ArrayList<>();
    }


    /**
     * Method used in Part 1 for Dave's cars.
     * It prints the results in 'CAR-TYPE - PRICE' format.
     */
    public void printResultsWhenSingleSupplier() {
        for (Result result : resultsList) {
            System.out.println(result.getCarType() + " - " + result.getPrice());
        }
    }


    /**
     * Sort the results in price descending order.
     */
    public void sortPriceDescending() {
        resultsList.sort((o1, o2) -> (o2.getPrice() - o1.getPrice()) > 0 ? 1 : -1);
    }


    public List<Result> getResultsList() {
        return resultsList;
    }

    public void setResultsList(List<Result> resultsList) { this.resultsList = resultsList; }

}
