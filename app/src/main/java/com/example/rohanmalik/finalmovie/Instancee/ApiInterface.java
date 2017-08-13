package com.example.rohanmalik.finalmovie.Instancee;

import com.example.rohanmalik.finalmovie.MoviesTab.CastList;
import com.example.rohanmalik.finalmovie.model.AIringTodayResponse;
import com.example.rohanmalik.finalmovie.model.Company;
import com.example.rohanmalik.finalmovie.model.GeneresModel;
import com.example.rohanmalik.finalmovie.model.IntheatresResponse;
import com.example.rohanmalik.finalmovie.model.MovieDetailsBase;
import com.example.rohanmalik.finalmovie.model.RequestToken;
import com.example.rohanmalik.finalmovie.model.SessionIDmodal;
import com.example.rohanmalik.finalmovie.model.TVDetails;
import com.example.rohanmalik.finalmovie.model.TrailerRest;
import com.example.rohanmalik.finalmovie.model.UserDetails;
import com.example.rohanmalik.finalmovie.model.popularMovie;
import com.example.rohanmalik.finalmovie.model.popularMovieResponse;
import com.example.rohanmalik.finalmovie.model.popularMovieTrailers;
import com.example.rohanmalik.finalmovie.model.populatTvShowsResponse;
import com.example.rohanmalik.finalmovie.model.upcomingMovieResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Rohan Malik on 28-07-2017.
 */

public interface ApiInterface {
    @GET("movie/popular")
    Call<popularMovieResponse> getPopularMovies(@Query("api_key") String api_key);
    @GET("movie/{id}/videos")
    Call<TrailerRest> getTrailers(@Path("id") Long id, @Query("api_key") String api_key);
    @GET("collection/{id}")
    Call<Company> getCollections(@Path("id") Integer id, @Query("api_key") String api_key);
    @GET("tv/popular")
    Call<populatTvShowsResponse> getPopularTvShows(@Query("api_key") String api_key);
    @GET("movie/upcoming")
    Call<upcomingMovieResponse> getUpcomingMovies(@Query("api_key") String api_key);
    @GET("movie/now_playing")
    Call<IntheatresResponse> getCurrent(@Query("api_key") String api_key,@Query("region") String region);
    @GET("genre/movie/list")
    Call<GeneresModel> getGeneresName(@Query("api_key") String api_key);
    @GET("tv/airing_today")
    Call<AIringTodayResponse> getAiringToday(@Query("api_key") String api_key);
    @GET("movie/{id}")
    Call<MovieDetailsBase> getMovieDetails(@Path("id")Long id,@Query("api_key") String api_key,@Query("append_to_response") String response);
    @GET("tv/{id}")
    Call<TVDetails> getTvDetails(@Path("id")Long id,@Query("api_key") String api_key,@Query("append_to_response") String response);
    @GET("authentication/token/new")
    Call<RequestToken> getRequestToken(@Query("api_key") String api_key);
    @GET("authentication/session/new")
    Call<SessionIDmodal> getSessionID(@Query("api_key") String key, @Query("request_token") String request);
    @GET("account")
    Call<UserDetails> getUserDetails(@Query("api_key") String apiKey, @Query("session_id") String session);
}
