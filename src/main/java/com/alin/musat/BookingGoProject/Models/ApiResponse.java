package com.alin.musat.BookingGoProject.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Response model from supplier's API.
 */
public class ApiResponse {

    @SerializedName("supplier_id")
    @Expose
    private String supplierId;

    @SerializedName("pickup")
    @Expose
    private String pickup;

    @SerializedName("dropoff")
    @Expose
    private String dropoff;

    @SerializedName("options")
    @Expose
    private ArrayList<Option> options = null;

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getPickup() {
        return pickup;
    }

    public void setPickup(String pickup) {
        this.pickup = pickup;
    }

    public String getDropoff() {
        return dropoff;
    }

    public void setDropoff(String dropoff) {
        this.dropoff = dropoff;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(ArrayList<Option> options) {
        this.options = options;
    }



}
