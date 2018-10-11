package com.alin.musat.BookingGoProject;

import com.alin.musat.BookingGoProject.Controllers.BookingGoController;
import com.despegar.http.client.GetMethod;
import com.despegar.http.client.HttpResponse;
import com.despegar.sparkjava.test.SparkServer;
import org.junit.ClassRule;
import org.junit.Test;
import spark.servlet.SparkApplication;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;

public class BookingGoControllerTest {

    public static class BookingGoContollerTestSparkApplication  implements SparkApplication {
        @Override
        public void init() {
            new BookingGoController();
        }
    }

    @ClassRule
    public static SparkServer<BookingGoContollerTestSparkApplication> testServer = new SparkServer<>(BookingGoControllerTest.BookingGoContollerTestSparkApplication.class, 4567);
    

    @Test
    public void testInvalidDropoff() throws Exception {

        String request = "/bookinggo?pickup=1,1&dropoff=1,a.0&passengers=1";

        GetMethod get = testServer.get(request, false);

        HttpResponse httpResponse = testServer.execute(get);
        System.out.println(new String(httpResponse.body()));
        assertEquals(400, httpResponse.code());
    }

    @Test
    public void testInvalidPickup() throws Exception {

        String request = "/bookinggo?pickup=a,1&dropoff=1,1.0&passengers=1";

        GetMethod get = testServer.get(request, false);

        HttpResponse httpResponse = testServer.execute(get);
        System.out.println(new String(httpResponse.body()));
        assertEquals(400, httpResponse.code());
    }

    @Test
    public void testInvalidPassengers() throws Exception {

        String request = "/bookinggo?pickup=1,1&dropoff=1,1.0&passengers=a";

        GetMethod get = testServer.get(request, false);

        HttpResponse httpResponse = testServer.execute(get);
        System.out.println(new String(httpResponse.body()));
        assertEquals(400, httpResponse.code());
    }


}
