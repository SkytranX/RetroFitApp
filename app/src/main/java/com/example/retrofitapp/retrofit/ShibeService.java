package com.example.retrofitapp.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

//change class to interface
public interface ShibeService {

    //@Get   . in this instance
    //What happens behind ".../shibes"> shibes?count=10
    @GET(Constants.SHIBE_PATH)
    //getShibes(@Query("")) > "count" > int count
    //Call<> add List<String>
    Call<List<String>> getShibes(@Query("count") int count);
}
