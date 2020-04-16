package com.example.cobafragment.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {

    private Retrofit retrofit;

    public MovieRepositoriy getApiMovie()
    {
        String BASE_URL             =   "https://api.themoviedb.org";
        if(retrofit ==   null)
        {
            retrofit                =   new Retrofit
                                        .Builder()
                                        .baseUrl(BASE_URL)
                                        .addConverterFactory(GsonConverterFactory.create())
                                        .build();
        }
        return retrofit.create(MovieRepositoriy.class);
    }

}
