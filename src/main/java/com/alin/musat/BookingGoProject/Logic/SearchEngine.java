package com.alin.musat.BookingGoProject.Logic;

import com.alin.musat.BookingGoProject.Models.ApiResponse;
import com.alin.musat.BookingGoProject.Models.GeoLocation;
import com.alin.musat.BookingGoProject.Models.Option;
import com.alin.musat.BookingGoProject.Models.Ride;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Main part of application.
 */
public class SearchEngine {

    private static final int timeoutMilliseconds = 2000;

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

        SearchResponse searchResponse = new SearchResponse();

        for(String supplierEndPoint: supplierEndPoints) {

            URL url = buildUrl(supplierEndPoint, pickUp, dropOff);

            try {
                ApiResponse response = makeApiCall(url);

                if (response == null) continue;

                for (Option options: response.getOptions())  {
                    Ride newRide = new Ride(options.getCarType(), options.getPrice(), response.getSupplierId());
                    searchResponse.getResultsList().add(newRide);
                }
            }
            catch (java.net.SocketTimeoutException e)
            {
                System.out.println("Connection timeout.");
                continue;
            } catch (IOException e) {
                System.out.println("Could not read the response.");
                continue;
            }

        }

        searchResponse.removeIrrelevantResults(numberOfPassengers);
        searchResponse.sortPriceDescending();

        return searchResponse;



    }

    /**
     * Use this method to perform a new search without limit of passengers.
     * @param pickUp Pick up geolocation
     * @param dropOff Drop off geolocation
     * @return Query response in for of a SearchResponse object.
     */
    public SearchResponse newSearch(GeoLocation pickUp, GeoLocation dropOff) {
        // By calling this method with zero number of passengers, it will display all results.
        return this.newSearch(pickUp, dropOff, 0);
    }


    /**
     * Make the actual http call.
     * @param url The url to call.
     * @return The ApiResponse
     * @throws IOException If the connection get interrupted.
     */
    public ApiResponse makeApiCall(URL url) throws IOException {

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        connection.setConnectTimeout(timeoutMilliseconds);


        int responseCode = connection.getResponseCode();

        if (responseCode != 200) {
            System.out.println("Response code was " + responseCode + " for " + url.toString());
            System.out.println("Skipped this supplier");
            return null;
        }

        String responseString = readResponse(connection);

        return deserializeResponse(responseString);
    }

    /**
     * Deserialize api response into ApiResponse Object.
     * @param responseString Response string from API call.
     * @return Response deserialized.
     */
    private ApiResponse deserializeResponse(String responseString) {
        GsonBuilder builder = new GsonBuilder();
        builder.setPrettyPrinting();

        Gson gson = builder.create();

        return  gson.fromJson(responseString, ApiResponse.class);
    }

    /**
     * Opens an input stream from connection and read the response.
     * @param connection HTTP connection
     * @return Full response in string.
     * @throws IOException
     */
    private String readResponse(HttpURLConnection connection) throws IOException {

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return  response.toString();

    }

    /**
     * Builds the URL from supplier end point and locations.
     * @param supplierEndPoint Supplier Eend point.
     * @param pickUp Pick up geolocation.
     * @param dropOff Drop off geolocation.
     * @return Built URL.
     */
    public URL buildUrl(String supplierEndPoint, GeoLocation pickUp, GeoLocation dropOff)
    {
        StringBuilder stringBuilder = new StringBuilder(supplierEndPoint);

        stringBuilder.append("?pickup=");
        stringBuilder.append(pickUp.getLatitude());
        stringBuilder.append(",");
        stringBuilder.append(pickUp.getLongitude());

        stringBuilder.append("&");

        stringBuilder.append("dropoff=");
        stringBuilder.append(dropOff.getLatitude());
        stringBuilder.append(",");
        stringBuilder.append(dropOff.getLongitude());

        try {
            return new URL(stringBuilder.toString());
        } catch (MalformedURLException e) {
            e.printStackTrace();
            System.out.println("Could not build URL.");
        }

        return null;
    }


    public void addSupplier(String endPoint) {
        supplierEndPoints.add(endPoint);
    }


}
