package com.example.android.movieapp.Utils;

import com.example.android.movieapp.Models.MovieModel;
import com.example.android.movieapp.Response.MovieSearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface MovieApi {

    //Search movies
    //  https://api.themoviedb.org/3/search/movie?api_key=880843f1bf799de7677a489143f9226b&query=Jack+Reacher

    @GET("/3/search/movie")
    Call<MovieSearchResponse> searchMovie(
            @Query("api_key") String key,
            @Query("query") String query,
            @Query("page") int page
    );

    //  https://api.themoviedb.org/3/movie/550?api_key=880843f1bf799de7677a489143f9226b

    @GET("/3/movie{id}?")
    Call<MovieModel> getMovie(
            @Path("id") int id,
            @Query("api_key") String api_key
    );

}
