package com.example.newsshots.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetro {
    private static final String BASE_URL = "https://newsapi.org/v2/";
    private static Retrofit retrofit = null;
    private static Retrofit initRetro(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
    public static final MyApiInterface api = initRetro().create(MyApiInterface.class);
}
