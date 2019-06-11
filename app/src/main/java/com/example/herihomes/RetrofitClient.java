package com.example.herihomes;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static final String BASE_URL = "http:// 192.168.43.126/MyApi/public/";
    private  static RetrofitClient mInstance;
    private Retrofit retrofit;

    private  RetrofitClient () {
        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

//    public static synchronized RetrofitClient getInstance(){
//
//    }
}
