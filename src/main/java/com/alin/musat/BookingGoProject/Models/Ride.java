package com.alin.musat.BookingGoProject.Models;

/**
 * Simple object to encapsulate CAR-TYPE - PRICE - SUPPLIER.
 */
public class Ride {

    private String carType;

    private long price;

    private String supplier;


    public Ride(String carType, long price, String supplier) {
        this.carType = carType;
        this.price = price;
        this.supplier = supplier;

    }

    public long getPrice() {
        return price;
    }


    public String getCarType() {
        return carType;
    }

    public String getSupplier() {
        return supplier;
    }

}
