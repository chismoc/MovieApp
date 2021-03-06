package com.example.android.movieapp.Response;

import com.example.android.movieapp.Models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//Class for single movie request
public class MovieResponse {
    //1.finding the movie object
    @SerializedName("results")
    @Expose
    private MovieModel movie;

    public MovieModel getMovie(){
        return movie;
    }

    @Override
    public String toString() {
        return "MovieResponse{" +
                "movie=" + movie +
                '}';
    }
}
