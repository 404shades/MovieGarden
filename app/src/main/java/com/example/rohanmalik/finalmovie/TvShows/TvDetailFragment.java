package com.example.rohanmalik.finalmovie.TvShows;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rohanmalik.finalmovie.Config;
import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.MoviesTab.CastAdapter;
import com.example.rohanmalik.finalmovie.MoviesTab.CastList;
import com.example.rohanmalik.finalmovie.MoviesTab.GenereAdapter;
import com.example.rohanmalik.finalmovie.MoviesTab.Generes;
import com.example.rohanmalik.finalmovie.MoviesTab.typeAdapter;
import com.example.rohanmalik.finalmovie.R;
import com.example.rohanmalik.finalmovie.model.CreatedTv;
import com.example.rohanmalik.finalmovie.model.GeneresCo;
import com.example.rohanmalik.finalmovie.model.Seasons;
import com.example.rohanmalik.finalmovie.model.TVDetails;
import com.example.rohanmalik.finalmovie.model.VideoYou;
import com.example.rohanmalik.finalmovie.model.Vido;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragment;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rohan Malik on 06-08-2017.
 */

public class TvDetailFragment extends Fragment implements YouTubePlayer.OnInitializedListener {
    YouTubePlayerSupportFragment supportFragment;
    private static final int RECOVERY_REQUEST = 1;
    long id;
    String key;
    ImageView imageTvPoster;
    TextView textTitleTv;
    private YouTubePlayerView youtube;
    private TextView TvDetRelDate;
    private TextView TvDetOverview;
    private TextView textSeason;
    private List<Generes> generesCoList;
    RecyclerView recyclerGenres;
    typeAdapter genereAdapter;
    Generes generes;
    RecyclerView recyclerSeasons;
    TvAdapter tvSeasonAdapter;
    List<TVSeasons> seasonsList;
    List<CastList> createdList;
    CastList createdPerson;
    RecyclerView recyclerCreated;
    CastAdapter createdAdapter;
    TVSeasons seasonsTv;

    public TvDetailFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tv_details, container, false);
        Bundle bundle = getArguments();
        id = bundle.getLong("TVId");
        Log.d("JOKER", id + "");


        generesCoList = new ArrayList<>();
        recyclerGenres = view.findViewById(R.id.recycler_genres_tv);
        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        recyclerGenres.setLayoutManager(layoutManager);
        genereAdapter=  new typeAdapter(generesCoList,getContext());
        recyclerGenres.setAdapter(genereAdapter);
        textTitleTv = (TextView) view.findViewById(R.id.TvDetTitle);
        imageTvPoster = (ImageView) view.findViewById(R.id.imgTvDetail);
        TvDetRelDate = (TextView) view.findViewById(R.id.TvDetRelDate);
        textTitleTv = view.findViewById(R.id.textTvTitleSeasons);
        seasonsList = new ArrayList<>();
        recyclerSeasons = view.findViewById(R.id.recyclerSeasonsTvDet);
        LinearLayoutManager managerm = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerSeasons.setLayoutManager(managerm);
        tvSeasonAdapter = new TvAdapter(seasonsList,1,getContext());
        recyclerSeasons.setAdapter(tvSeasonAdapter);



        createdList = new ArrayList<>();
        recyclerCreated = view.findViewById(R.id.recyclerCompanyTv);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerCreated.setLayoutManager(linearLayoutManager);
        createdAdapter = new CastAdapter(createdList,getContext());
        recyclerCreated.setAdapter(createdAdapter);
        supportFragment = new YouTubePlayerSupportFragment();
        FragmentManager manager = getFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.YoutubePlayerTtv, supportFragment);
        transaction.commit();
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(), "fonts/regular.otf");
        textTitleTv.setTypeface(tf);
        textSeason = view.findViewById(R.id.textTvTitleSeasons);
        Typeface tface = Typeface.createFromAsset(getActivity().getAssets(), "fonts/huelic_b.ttf");
        TvDetOverview = (TextView) view.findViewById(R.id.TvDetOverview);
        TvDetOverview.setTypeface(tf);
        textSeason.setTypeface(tf);
        TvDetRelDate.setTypeface(tface);
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<TVDetails> call = service.getTvDetails(id, Config.API_KEY, "videos");
        call.enqueue(new Callback<TVDetails>() {
            @Override
            public void onResponse(Call<TVDetails> call, Response<TVDetails> response) {
                String poster = response.body().getPoster_path();
                VideoYou videoYou = response.body().getVideos();
                List<CreatedTv> createdByList = response.body().getCreated_by();
                List<Vido> vidos = videoYou.getResults();

                List<GeneresCo> generesCoList1 = response.body().getGenres();
                List<Seasons> sasonList = response.body().getSeasons();
                key = vidos.get(0).getKey();
                Log.d("NIMAMA", vidos.get(0).getKey());
                supportFragment.initialize(Config.YOUTUBE_API_KEY, TvDetailFragment.this);
                Picasso.with(getContext()).load("https://image.tmdb.org/t/p/w500" + poster).into(imageTvPoster);
                textTitleTv.setText(response.body().getName());
                TvDetRelDate.setText(response.body().getLast_air_date());
                TvDetOverview.setText(response.body().getOverview());
                textSeason.setText(response.body().getName() + " Seasons");
                for(int i=0;i<generesCoList1.size();i++){
                    generes = new Generes(generesCoList1.get(i).getId(),generesCoList1.get(i).getName());
                    generesCoList.add(generes);
                    genereAdapter.notifyItemInserted(i);
                }
                    for (int i = 0; i < sasonList.size(); i++) {
                        seasonsTv = new TVSeasons(sasonList.get(i).getPoster_path(), sasonList.get(i).getSeason_number());
                        seasonsList.add(seasonsTv);
                        tvSeasonAdapter.notifyItemInserted(i);
                    }
                for (int i=0;i<createdByList.size();i++){
                    createdPerson = new CastList(createdByList.get(i).getProfile_path());
                    createdList.add(createdPerson);
                    createdAdapter.notifyItemInserted(i);
                }
            }

            @Override
            public void onFailure(Call<TVDetails> call, Throwable t) {
                Log.d("MAAATA", t.toString());

            }
        });
        return view;
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
