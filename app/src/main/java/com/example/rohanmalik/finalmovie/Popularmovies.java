package com.example.rohanmalik.finalmovie;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.model.TrailerRest;
import com.example.rohanmalik.finalmovie.model.popularMovie;
import com.example.rohanmalik.finalmovie.model.popularMovieResponse;
import com.example.rohanmalik.finalmovie.model.popularMovieTrailers;
import com.example.rohanmalik.finalmovie.model.popularTvShows;
import com.example.rohanmalik.finalmovie.model.populatTvShowsResponse;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rohan Malik on 27-07-2017.
 */

public class Popularmovies extends Fragment implements YouTubePlayer.OnInitializedListener{
    private static final int RECOVERY_REQUEST = 1;
    private YouTubePlayer youtubePlayer;
    private YouTubePlayerView youtube;
    private ImageView image;
    private static final int flagMovie = 0;
    private static final int flagTv = 1;
    private TextView textTitle;
    private TextView category_count;
    private CardView cardView;
    private String API_KEY = "1a43f1f22e3cf15ce2cfd8ca5af13e6f";
    private String key;
    TVListPopular tvListPopular;
    private RecyclerView recyclerPopular;
    private List<PopularMoviesList> popularMoviesLists;
    private PopularMovieAdapter adapter;
    private RecyclerView recycleCollection;
    private TextView collectionTop;
    private List<Integer> collection_id;
    YouTubePlayerSupportFragment mYoutubePlayerFragment;
    PopularMoviesList popularMovies;
    RecyclerView collectionRecycle;
    CollectionAdapter collAdapter;
    private int[] collect;
    RecyclerView recycleTv;
    List<TVListPopular> tvListPopulars;
    Random random;
    public Popularmovies() {
        //Empty Constructor Required
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.popular_movies, container, false);
        popularMoviesLists = new ArrayList<>();
        adapter = new PopularMovieAdapter(popularMoviesLists,getContext(),flagMovie);
        collAdapter = new CollectionAdapter(getContext());
        collectionRecycle = (RecyclerView)view.findViewById(R.id.collection_Top_recycler);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        collectionRecycle.setLayoutManager(manager);
        collectionRecycle.setAdapter(collAdapter);
        recyclerPopular = (RecyclerView)view.findViewById(R.id.recyclerPopular);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerPopular.setLayoutManager(layoutManager);
        recyclerPopular.setAdapter(adapter);
        random = new Random();
        TextView textPopularMovies = (TextView)view.findViewById(R.id.typePopular);
       ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<popularMovieResponse> call = apiService.getPopularMovies(API_KEY);
        call.enqueue(new Callback<popularMovieResponse>() {
            @Override
            public void onResponse(Call<popularMovieResponse> call, Response<popularMovieResponse> response) {
                List<popularMovie> popularmovies = response.body().getResults();
                final int value = random.nextInt(popularmovies.size());
               String poster =  popularmovies.get(value).getPosterPath();
               Long movie_id = popularmovies.get(value).getId();
                Log.d("MOVIEsat",movie_id + "");
                textTitle.setText(popularmovies.get(value).getTitle());
                Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w500/" + poster).into(image);
                loadTrailer(movie_id);
                for(int i=0;i<20;i++){
                    popularMovies = new PopularMoviesList(popularmovies.get(i).getPosterPath(),popularmovies.get(i).getTitle(),popularmovies.get(i).getVoteAverage());
                    popularMoviesLists.add(popularMovies);
                    adapter.notifyItemInserted(i);
                }
            }

            @Override
            public void onFailure(Call<popularMovieResponse> call, Throwable t) {

            }
        });

        collect  = new int[6];
        mYoutubePlayerFragment = new YouTubePlayerSupportFragment();
        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.youTubePlayer, mYoutubePlayerFragment);
        fragmentTransaction.commit();
        image = (ImageView)view.findViewById(R.id.imageView);
        textTitle = (TextView) view.findViewById(R.id.movieTitlePoster);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),"fonts/huelic_b.ttf");
        Typeface tface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/regular.otf");
        textPopularMovies.setTypeface(tface);
        textPopularMovies.setText("Popular Movies");
        collectionTop = (TextView) view.findViewById(R.id.Collection_Top_Rated_home);
        collectionTop.setText("Top Rated Collections");
        collectionTop.setTypeface(tf);
        textTitle.setTypeface(tf);










        TextView titleTvPopular = (TextView)view.findViewById(R.id.typePopularTv);
        titleTvPopular.setTypeface(tf);
        titleTvPopular.setText("Popular Tv Shows");
        tvListPopulars = new ArrayList<>();
        recycleTv = (RecyclerView)view.findViewById(R.id.recyclerPopularTvShows);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recycleTv.setLayoutManager(layoutManager1);
        final PopularMovieAdapter tvAdapter=  new PopularMovieAdapter(tvListPopulars,flagTv,getContext());
        recycleTv.setAdapter(tvAdapter);
        Call<populatTvShowsResponse> call1 = apiService.getPopularTvShows(API_KEY);
        call1.enqueue(new Callback<populatTvShowsResponse>() {
            @Override
            public void onResponse(Call<populatTvShowsResponse> call, Response<populatTvShowsResponse> response) {
                List<popularTvShows> popularTvShowses = response.body().getResults();
                for(int i=0;i<20;i++){
                    tvListPopular = new TVListPopular(popularTvShowses.get(i).getOriginal_name(),popularTvShowses.get(i).getPoster_path(),popularTvShowses.get(i).getId(),popularTvShowses.get(i).getVote_average(),popularTvShowses.get(i).getBackdrop_path());
                    tvListPopulars.add(tvListPopular);
                    tvAdapter.notifyItemInserted(i);
                }

            }

            @Override
            public void onFailure(Call<populatTvShowsResponse> call, Throwable t) {
            Log.d("errorRep",t.toString());
            }
        });





        return view;
    }

    private void loadTrailer(Long movie_id) {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<TrailerRest> call = apiService.getTrailers(movie_id,API_KEY);
        call.enqueue(new Callback<TrailerRest>() {
            @Override
            public void onResponse(Call<TrailerRest> call, Response<TrailerRest> response) {
                List<popularMovieTrailers> trailers =  response.body().getResult();

                key = trailers.get(0).getKEy();
                Log.d("MainStream",key);
                mYoutubePlayerFragment.initialize(Config.YOUTUBE_API_KEY,Popularmovies.this);
            }

            @Override
            public void onFailure(Call<TrailerRest> call, Throwable t) {

            }
        });

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        if (!b) {
            youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.MINIMAL);
            youTubePlayer.cueVideo(key);
        }
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if (youTubeInitializationResult.isUserRecoverableError()) {
            youTubeInitializationResult.getErrorDialog(getActivity(), RECOVERY_REQUEST).show();
        } else {
            String error = String.format(getString(R.string.player_error), youTubeInitializationResult.toString());
            Toast.makeText(getContext(), error, Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RECOVERY_REQUEST) {
            getYoutubePlayerProvider().initialize(Config.YOUTUBE_API_KEY, this);
        }
    }

    protected YouTubePlayer.Provider getYoutubePlayerProvider() {
        return youtube;
    }

}