package com.example.cobafragment.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.cobafragment.model.movies.MovieDiscoverResponse;
import com.example.cobafragment.model.movies.MovieDiscoverResultsItem;
import com.example.cobafragment.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieViewModel extends ViewModel {

    private ApiMain apiMain;

    private MutableLiveData<ArrayList<MovieDiscoverResultsItem>> listDiscoverMovie   =   new MutableLiveData<>();

    public void setMovieDiscover()
    {
        if(this.apiMain == null)
        {
            apiMain                                     =   new ApiMain();
        }

        apiMain.getApiMovie().getMovieDiscover().enqueue(new Callback<MovieDiscoverResponse>() {
            @Override
            public void onResponse(Call<MovieDiscoverResponse> call, Response<MovieDiscoverResponse> response) {

                MovieDiscoverResponse responseDiscover  =   response.body();
                if (responseDiscover != null && responseDiscover.getResults() != null)
                {
                    ArrayList<MovieDiscoverResultsItem> movieDiscoverResultsItems   =   responseDiscover.getResults();
                     listDiscoverMovie.postValue(movieDiscoverResultsItems);
                }
            }

            @Override
            public void onFailure(Call<MovieDiscoverResponse> call, Throwable t) {

            }
        });
    }


            public LiveData<ArrayList<MovieDiscoverResultsItem>> getMovieDiscover()
            {
                return listDiscoverMovie;
            }

}
