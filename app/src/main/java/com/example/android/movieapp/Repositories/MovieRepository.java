package com.example.android.movieapp.Repositories;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.android.movieapp.Models.MovieModel;
import com.example.android.movieapp.Request.MovieApiClient;

import java.util.List;

public class MovieRepository {
    //This class is acting as repository
    private static MovieRepository instance;

    private MovieApiClient movieApiClient;


    public static MovieRepository getInstance(){
if(instance == null){
    instance = new MovieRepository();
}
return instance;
    }

    private MovieRepository(){
        movieApiClient = MovieApiClient.getInstance();
    }
    public LiveData<List<MovieModel>>getMovies(){
        return movieApiClient.getMovies();
    }
}
