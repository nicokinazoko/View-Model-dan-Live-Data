package com.example.cobafragment.view.fragment;

import android.annotation.SuppressLint;
import android.graphics.Movie;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cobafragment.R;
import com.example.cobafragment.adapter.MovieDiscoverAdapter;
import com.example.cobafragment.model.movies.MovieDiscoverResultsItem;
import com.example.cobafragment.view.viewmodel.MovieViewModel;

import java.util.ArrayList;

import static com.google.gson.reflect.TypeToken.get;


/**
 * A simple {@link Fragment} subclass.
 */
public class MovieFragment extends Fragment {

    private MovieDiscoverAdapter movieDiscoverAdapter;
    private RecyclerView rvMovieAdapter;
    private MovieViewModel movieViewModel;


    public MovieFragment(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @SuppressLint("FragmentLiveDataObserve")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        movieDiscoverAdapter                =   new MovieDiscoverAdapter(getContext());
        movieDiscoverAdapter.notifyDataSetChanged();

        rvMovieAdapter                      =   view.findViewById(R.id.fragmentmovie_rv);
        rvMovieAdapter.setLayoutManager(new GridLayoutManager(getContext(),2));

        movieViewModel                      =   new ViewModelProvider(this).get(MovieViewModel.class);
        movieViewModel.setMovieDiscover();
        movieViewModel.getMovieDiscover().observe(this,getMovieDiscover);

        rvMovieAdapter.setAdapter(movieDiscoverAdapter);
    }

    private Observer <ArrayList<MovieDiscoverResultsItem>> getMovieDiscover = new Observer<ArrayList<MovieDiscoverResultsItem>>() {
        @Override
        public void onChanged(ArrayList<MovieDiscoverResultsItem> movieDiscoverResultsItems) {

            if (movieDiscoverResultsItems != null)
            {
                movieDiscoverAdapter.setData(movieDiscoverResultsItems);
                Log.d("1234","Ada Datanya");
            }
        }
    };
}
