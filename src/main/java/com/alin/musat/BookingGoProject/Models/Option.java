package com.alin.musat.BookingGoProject.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Part of API response from suppliers.
 */
public class Option {

    @SerializedName("car_type")
    @Expose

    private String carType;
    @SerializedName("price")
    @Expose
    private long price;

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }


}
