package com.example.android.movieapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.android.movieapp.Models.MovieModel;
import com.example.android.movieapp.Request.RetrofitService;
import com.example.android.movieapp.Response.MovieSearchResponse;
import com.example.android.movieapp.Utils.Credentials;
import com.example.android.movieapp.Utils.MovieApi;
import com.example.android.movieapp.ViewModel.MovieListViewModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MovieListActivity extends AppCompatActivity {

    Button btn;
    //ViewModel
    private MovieListViewModel movieListViewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);


        movieListViewModel = new ViewModelProvider(this).get(MovieListViewModel.class);


    }

    //Observing any data change
    private  void ObserveAnyChange(){
        movieListViewModel.getMovies().observe(this, new Observer<List<MovieModel>>() {
            @Override
            public void onChanged(List<MovieModel> movieModels) {
                //Observing for any data change

            }
        });

    }

    //get retrofit response from server
    private void GetRetrofitResponse() {
        MovieApi movieApi = RetrofitService.getMovieApi();

        Call<MovieSearchResponse> responseCall = movieApi
                .searchMovie(
                        Credentials.API_KEY,
                        "Jack Reacher",
                        1);

        responseCall.enqueue(new Callback<MovieSearchResponse>() {
            @Override
            public void onResponse(Call<MovieSearchResponse> call, Response<MovieSearchResponse> response) {

                if (response.code() == 200) {
                  //  Log.v("Tag", "the response" + response.body().toString());
                    List<MovieModel> movies = new ArrayList<>(response.body().getMovies());

                    for (MovieModel movie : movies) {
                    Log.v("Tag", "The List" + movie.getTitle());

                    }
                }else{
                    try {
                        Log.v("Tag","Error" + response.errorBody().string());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

            @Override
            public void onFailure(Call<MovieSearchResponse> call, Throwable t) {

            }
        });
    }

    private void GetRetrofitResponseById(){
        MovieApi movieApi = RetrofitService.getMovieApi();
        Call<MovieModel> responseCall = movieApi.getMovie(550,
                Credentials.API_KEY);

        responseCall.enqueue(new Callback<MovieModel>() {
            @Override
            public void onResponse(Call<MovieModel> call, Response<MovieModel> response) {
                if(response.code() == 200){
                    MovieModel movie = response.body();
                  //  Log.v("Tag","The Response" + movie.getTitle());

                }else{
                    try{
                        Log.v("Tag","Error" + response.errorBody().string());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<MovieModel> call, Throwable t) {

            }
        });
    }
}