package com.alin.musat.BookingGoProject.Models;

/**
 * Simple object to encapsulate CAR-TYPE - PRICE - SUPPLIER.
 */
public class Result {

    private String carType;

    private long price;

    private String supplier;


    public Result(String carType, long price, String supplier) {
        this.carType = carType;
        this.price = price;
        this.supplier = supplier;

    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) { this.carType = carType; }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

}
