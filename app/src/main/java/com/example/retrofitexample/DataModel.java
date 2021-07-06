package com.example.retrofitexample;

import com.google.gson.annotations.SerializedName;

public class DataModel {

    //Model of the data to be returned from web service api

    private int userId;
    private int id;
    private String title;

    //Example of using a different name for a piece of data than the JSON returns
    @SerializedName("completed")
    private boolean status;


    public int getUserId() {
        return userId;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public boolean isStatus() {
        return status;
    }
}
