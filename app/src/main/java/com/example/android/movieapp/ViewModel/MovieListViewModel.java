package com.example.android.movieapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.movieapp.Models.MovieModel;

import java.util.List;

public class MovieListViewModel  extends ViewModel {

    //this class is used for ViewModel

    //LiveData
    private MutableLiveData<List<MovieModel>> mMovies = new MutableLiveData<>();

    //Constructor

    public MovieListViewModel() {

    }

    //Getter


    public LiveData<List<MovieModel>> getMovies() {
        return mMovies;
    }
}
