package com.example.cobafragment.service;

import com.example.cobafragment.model.movies.MovieDiscoverResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface MovieRepositoriy {

    @GET("3/discover/movie?api_key=69fc5f499d218e456bfbac01bbef3dd6&language=en-US")
    Call<MovieDiscoverResponse> getMovieDiscover();


}
