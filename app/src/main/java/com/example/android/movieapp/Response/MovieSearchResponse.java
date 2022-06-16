package com.example.android.movieapp.Response;
//Get multiple movie(movie List) - popular movies

import com.example.android.movieapp.Models.MovieModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class MovieSearchResponse {
    //search for word result
    @SerializedName("total_results")
    @Expose
    private int total_count;

    @SerializedName("results")
    @Expose

    private List<MovieModel> movies;

    //getters
    public int getTotal_count() {
        return total_count;
    }

    public List<MovieModel> getMovies() {
        return movies;
    }

    @Override
    public String toString() {
        return "MovieSearchResponse{" +
                "total_count=" + total_count +
                ", movies=" + movies +
                '}';
    }
}
