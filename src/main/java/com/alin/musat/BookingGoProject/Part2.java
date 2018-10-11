package com.alin.musat.BookingGoProject;

import static spark.Spark.*;

public class Part2 {

    public static void main(String[] args) {

        get("/hello", (req, res)->"Hello, world");

        get("/hello/:name", (req,res)->{
            return "Hello, "+ req.params(":name");
        });
    }

}
