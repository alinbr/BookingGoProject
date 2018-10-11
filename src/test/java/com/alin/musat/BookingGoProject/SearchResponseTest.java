package com.alin.musat.BookingGoProject;

import com.alin.musat.BookingGoProject.Logic.SearchResponse;
import com.alin.musat.BookingGoProject.Models.Ride;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SearchResponseTest {


    @Test
    public void testSortPriceDescending() {

        SearchResponse searchResponse = new SearchResponse();

        Ride ride1 = new Ride("MINIBUS", 10, "dave");
        searchResponse.getResultsList().add(ride1);


        Ride ride2 = new Ride("MINIBUS", 20, "dave");
        searchResponse.getResultsList().add(ride2);

        searchResponse.sortPriceDescending();

        assertEquals(20, searchResponse.getResultsList().get(0).getPrice());

    }


    @Test
    public void testSortPriceDescendingEmptyResults() {

        SearchResponse searchResponse = new SearchResponse();

        searchResponse.sortPriceDescending();

        assertEquals(0, searchResponse.getResultsList().size());

    }


    @Test
    public void testRemoveIrrelevantResultsRemove() {

        SearchResponse searchResponse = new SearchResponse();

        Ride ride = new Ride("MINIBUS", 10, "dave");

        searchResponse.getResultsList().add(ride);

        searchResponse.removeIrrelevantResults(20);

        assertEquals(0, searchResponse.getResultsList().size());
    }

    @Test
    public void testRemoveIrrelevantResultsDontRemove() {

        SearchResponse searchResponse = new SearchResponse();

        Ride ride = new Ride("MINIBUS", 10, "dave");

        searchResponse.getResultsList().add(ride);

        searchResponse.removeIrrelevantResults(4);

        assertEquals(1, searchResponse.getResultsList().size());
    }

    @Test
    public void testGetCheapestValid() {

        SearchResponse searchResponse = new SearchResponse();

        Ride result1 = new Ride("MINIBUS", 10, "dave");
        searchResponse.getResultsList().add(result1);


        Ride result2 = new Ride("MINIBUS", 20, "dave");
        searchResponse.getResultsList().add(result2);

        Ride result = searchResponse.getCheapest("MINIBUS");

        assertEquals(10, result.getPrice());

    }

    @Test
    public void testGetCheapestEmptyResults() {

        SearchResponse searchResponse = new SearchResponse();

        Ride result = searchResponse.getCheapest("MINIBUS");

        assertNull(result);

    }



}
