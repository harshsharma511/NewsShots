package com.example.newsshots.api;

import com.example.newsshots.model.NewsPojoRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MyApiInterface {
    @GET("top-headlines?country=in&apiKey=2d37575ab78c42f09ea6bc38c6dc755f")
    Call<NewsPojoRes> getIndianNews();
}
