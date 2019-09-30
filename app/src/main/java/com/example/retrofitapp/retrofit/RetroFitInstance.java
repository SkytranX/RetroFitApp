package com.example.retrofitapp.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroFitInstance {
    //Step #1 Create a Private Constructor // insure singleton
    private RetroFitInstance() {
        //Private Constructor
    }
    // Step:2: Create Inner class to provide (instance) of RetroFit
    private  static class  RetrofitInstanceHolder {
        // Create a Retrofit INSTANCE
        static Retrofit INSTANCE = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    // STep #3 PUBLIC static method to access the instance of Retrofit
     public static Retrofit getInstance(){
        return RetrofitInstanceHolder.INSTANCE;
     }

    // Step 3 cont: this is an optimized way for Retrofit
    //<S> S is a name special case where name could not be named
    public static <S> S createService(Class<S> serviceClass){
        return RetrofitInstanceHolder.INSTANCE.create(serviceClass);
     }




}
