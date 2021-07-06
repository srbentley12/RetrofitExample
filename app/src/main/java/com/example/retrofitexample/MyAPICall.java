package com.example.retrofitexample;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyAPICall {

    //JSON data link
    // fixed: https://run.mocky.io/v3/      variable: 68d52101-8247-4fce-bef4-f69ac267ea0e

    @GET("v3/68d52101-8247-4fce-bef4-f69ac267ea0e")
    Call<DataModel> getData();

}
