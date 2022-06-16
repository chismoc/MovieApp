package com.example.android.movieapp.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android.movieapp.Models.MovieModel;
import com.example.android.movieapp.Repositories.MovieRepository;

import java.util.List;

public class MovieListViewModel extends ViewModel {

    //this class is used for ViewModel
//Instance of MovieRepository
    private MovieRepository movieRepository;

    //Constructor

    public MovieListViewModel() {
        movieRepository = MovieRepository.getInstance();
    }

    //Getter

    public LiveData<List<MovieModel>> getMovies() {
        return movieRepository.getMovies();
    }
}
