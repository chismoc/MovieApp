package com.example.android.movieapp.Request;

import com.example.android.movieapp.Utils.Credentials;
import com.example.android.movieapp.Utils.MovieApi;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
//Singleton pattern
//calls for retrofit
public class RetrofitService {

    //Retrofit constructor
private static Retrofit.Builder retrofitBuilder =
            new Retrofit.Builder()
            .baseUrl(Credentials.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create());

private static Retrofit retrofit = retrofitBuilder.build();
//Api to be used
private static MovieApi movieApi = retrofit.create(MovieApi.class);
//contructor for moiveApi
public MovieApi getMovieApi(){
    return movieApi;
}
}
