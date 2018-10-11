package com.alin.musat.BookingGoProject;

import com.alin.musat.BookingGoProject.Logic.SearchResponse;
import com.alin.musat.BookingGoProject.Models.Result;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SearchResponseTest {


    @Test
    public void testSortPriceDescending() {

        SearchResponse searchResponse = new SearchResponse();

        Result result1 = new Result("MINIBUS", 10, "dave");
        searchResponse.getResultsList().add(result1);


        Result result2 = new Result("MINIBUS", 20, "dave");
        searchResponse.getResultsList().add(result2);

        searchResponse.sortPriceDescending();

        assertEquals(20, searchResponse.getResultsList().get(0).getPrice());

    }


    @Test
    public void testSortPriceDescendingEmptyResults() {

        SearchResponse searchResponse = new SearchResponse();

        searchResponse.sortPriceDescending();

        assertEquals(0, searchResponse.getResultsList().size());

    }



}
