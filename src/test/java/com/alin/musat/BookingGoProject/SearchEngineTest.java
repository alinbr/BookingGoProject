package com.alin.musat.BookingGoProject;

import com.alin.musat.BookingGoProject.Logic.SearchEngine;
import com.alin.musat.BookingGoProject.Logic.SearchResponse;
import com.alin.musat.BookingGoProject.Models.ApiResponse;
import com.alin.musat.BookingGoProject.Models.GeoLocation;
import com.alin.musat.BookingGoProject.Models.Option;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

public class SearchEngineTest {

    SearchEngine searchEngine = spy(SearchEngine.class);

    ApiResponse apiResponse = new ApiResponse();

    GeoLocation pickUp = new GeoLocation(1.1,1.1);
    GeoLocation dropOff = new GeoLocation(1.1,1.1);

    public final String exampleUrl = "https://techtest.rideways.com/dave?pickup=1.1,1.1&dropoff=1.1,1.1";

    @Before
    public void setUp() {

        ArrayList<Option> options = new ArrayList<>();
        options.add(new Option("MINIBUS",5));
        options.add(new Option("STANDARD", 20));

        apiResponse.setOptions(options);
    }

    @Test
    public void testSearchEngineMakeNew() throws IOException {

        searchEngine.addSupplier(Utilities.DAVE_API);

        doReturn(apiResponse).when(searchEngine).makeApiCall(new URL(exampleUrl));

        SearchResponse searchResponse = searchEngine.newSearch(pickUp, dropOff);

        assertEquals(2, searchResponse.getResultsList().size());
    }

    @Test
    public void testBuildUrl()
    {
        URL url = searchEngine.buildUrl(Utilities.DAVE_API,pickUp, dropOff);
        assertTrue(exampleUrl.equals(url.toString()));
    }

}
