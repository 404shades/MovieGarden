package com.example.rohanmalik.finalmovie.MoviesTab;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.constraint.solver.Cache;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohanmalik.finalmovie.Config;
import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.PopularMovieAdapter;
import com.example.rohanmalik.finalmovie.R;
import com.example.rohanmalik.finalmovie.model.Casts;
import com.example.rohanmalik.finalmovie.model.GeneresCo;
import com.example.rohanmalik.finalmovie.model.MovieDetailsBase;
import com.example.rohanmalik.finalmovie.model.Seasons;
import com.example.rohanmalik.finalmovie.model.Similar;
import com.example.rohanmalik.finalmovie.model.SimilarMovieModal;
import com.example.rohanmalik.finalmovie.model.TVDetails;
import com.example.rohanmalik.finalmovie.model.castResult;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class MovieDetailFragment extends Fragment {
    private static final String TAG = "MovieDetailFragment";
    ImageView imgback;
    ImageView imgfront;
    TextView overview_det;
    TextView release_date;
    TextView tagline;
    TextView titleDet;
    RecyclerView recycleType;
    RecyclerView recycleSimilar;
    List<Generes> generesList;
    List<SimilarList> similarLists;
    typeAdapter typeadapter;
    TextView textCast;
    Generes cogen;

    PopularMovieAdapter similarAdapter;
    RecyclerView recycleCast;
    CastAdapter castAdapter;
    List<CastList> castLists;
    CastList castItem;
    TextView textSimilar;
    SimilarList similrf;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.movie_details,container,false);


        recycleType = view.findViewById(R.id.type_movie_recycler);
        recycleCast = view.findViewById(R.id.recycler_cast);
        recycleSimilar = view.findViewById(R.id.recyclerSimilar);
        textCast = view.findViewById(R.id.titleCast);
        textSimilar = view.findViewById(R.id.typeSimilar);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager manager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recycleCast.setLayoutManager(layoutManager1);
        recycleType.setLayoutManager(layoutManager);
        recycleSimilar.setLayoutManager(manager);
        castLists = new ArrayList<>();
        generesList = new ArrayList<>();
        similarLists = new ArrayList<>();
        typeadapter = new typeAdapter(generesList,getContext());
        castAdapter = new CastAdapter(castLists,getContext());
        similarAdapter = new PopularMovieAdapter(similarLists,true,4,getContext());
        recycleType.setVerticalScrollBarEnabled(false);
        recycleType.setAdapter(typeadapter);
        recycleCast.setAdapter(castAdapter);
        recycleSimilar.setAdapter(similarAdapter);
       imgback =  (ImageView)view.findViewById(R.id.backCoverMovie);
        imgfront = (ImageView)view.findViewById(R.id.movie_posterdet);
        overview_det = view.findViewById(R.id.overview_det);
        release_date = view.findViewById(R.id.movie_release_date);
        titleDet = view.findViewById(R.id.detMovieTitle);
        tagline = view.findViewById(R.id.movie_tagline);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),"fonts/huelic_b.ttf");
        Typeface tface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/regular.otf");
        textCast.setTypeface(tf);
        textCast.setText("Casts in the Movie");
        overview_det.setTypeface(tface);
        release_date.setTypeface(tf);
        tagline.setTypeface(tf);
        titleDet.setTypeface(tf);
        textSimilar.setText("Similar Movies");
        textSimilar.setTypeface(tf);
        Bundle bundle = getArguments();
        Long movie_id = bundle.getLong("MovieId");
        Long TV_id = bundle.getLong("TVId");
        if(movie_id!=null) {
            ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
            Call<MovieDetailsBase> call = service.getMovieDetails(movie_id, Config.API_KEY, "casts,similar");
            call.enqueue(new Callback<MovieDetailsBase>() {
                @Override
                public void onResponse(Call<MovieDetailsBase> call, Response<MovieDetailsBase> response) {
                    MovieDetailsBase base = response.body();
                    List<GeneresCo> generesCoList = response.body().getGenres();
                    Casts casting = response.body().getCasts();
                    List<castResult> castResults = casting.getCast();
                    Similar simly = response.body().getSimilar();
                    List<SimilarMovieModal> similarMovieModalList = simly.getResults();
                    Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w500" + base.getPoster_path()).into(imgfront);
                    Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w500" + base.getBackdrop_path()).into(imgback);
                    overview_det.setText(base.getOverview());
                    release_date.setText(base.getRelease_date());
                    tagline.setText(base.getTagline());
                    titleDet.setText(base.getOriginal_title());
                    for (int i = 0; i < generesCoList.size(); i++) {
                        cogen = new Generes(generesCoList.get(i).getId(), generesCoList.get(i).getName());
                        generesList.add(cogen);
                        typeadapter.notifyItemInserted(i);
                    }
                    for (int i = 0; i < castResults.size(); i++) {
                        castItem = new CastList(castResults.get(i).getProfile_path(), castResults.get(i).getCharacter(), castResults.get(i).getName());
                        castLists.add(castItem);
                        Log.i("Nimasa", castResults.get(i).getName());
                        castAdapter.notifyDataSetChanged();
                    }
                    for(int i=0;i<similarMovieModalList.size();i++){
                        similrf = new SimilarList(similarMovieModalList.get(i).getPoster_path(),similarMovieModalList.get(i).getTitle(),similarMovieModalList.get(i).getVote_average());
                        similarLists.add(similrf);
                        similarAdapter.notifyItemInserted(i);
                    }
                }

                @Override
                public void onFailure(Call<MovieDetailsBase> call, Throwable t) {
                    Log.d("basss", t.toString());

                }
            });
        }

        return view;
    }
}
