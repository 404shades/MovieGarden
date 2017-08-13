package com.example.rohanmalik.finalmovie;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.MoviesTab.MovieDetailFragment;
import com.example.rohanmalik.finalmovie.TvShows.AiringTodayList;
import com.example.rohanmalik.finalmovie.TvShows.TVClickListener;
import com.example.rohanmalik.finalmovie.TvShows.TvAdapter;
import com.example.rohanmalik.finalmovie.TvShows.TvDetailFragment;
import com.example.rohanmalik.finalmovie.model.AIringTodayResponse;
import com.example.rohanmalik.finalmovie.model.TvAiringToday;
import com.example.rohanmalik.finalmovie.model.popularTvShows;
import com.example.rohanmalik.finalmovie.model.populatTvShowsResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rohan Malik on 27-07-2017.
 */

public class FavouriteMovies extends Fragment implements ViewPagerEx.OnPageChangeListener,BaseSliderView.OnSliderClickListener,TVClickListener{
    private SliderLayout mSlider;
    HashMap<String,String> urlMapsTv;
    RecyclerView recycleAiringTody;
    TvAdapter adapter;
    AiringTodayList air;
    List<AiringTodayList> airingTodayLists;


    List<TVListPopular> tvListPopularList;
    RecyclerView recyclerPopularTv;
    TvAdapter adapterPopular;
    TVListPopular tvPopular;

    public FavouriteMovies(){

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.favourites,container,false);
        airingTodayLists = new ArrayList<>();
        recycleAiringTody = (RecyclerView)view.findViewById(R.id.recyclerairingTodayTv);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recycleAiringTody.setLayoutManager(layoutManager);
        adapter = new TvAdapter(airingTodayLists,getContext(),this,0);
        recycleAiringTody.setAdapter(adapter);

        tvListPopularList = new ArrayList<>();
        recyclerPopularTv = (RecyclerView)view.findViewById(R.id.recyclerPopularTvTab);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerPopularTv.setLayoutManager(layoutManager1);
        adapterPopular = new TvAdapter(2,getContext(),tvListPopularList,this);
        recyclerPopularTv.setAdapter(adapterPopular);
        Typeface tface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/regular.otf");
        TextView textView = (TextView)view.findViewById(R.id.airingTodayTv);
        textView.setText("Airing Today");

        TextView textView1 = (TextView)view.findViewById(R.id.textPopularTvTab);
        textView1.setText("PopularTVShows");
        textView.setTypeface(tface);
        textView1.setTypeface(tface);
        mSlider = (SliderLayout)view.findViewById(R.id.sliderTv);
       urlMapsTv = new HashMap<>();


        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<AIringTodayResponse> call = service.getAiringToday(Config.API_KEY);
        call.enqueue(new Callback<AIringTodayResponse>() {
            @Override
            public void onResponse(Call<AIringTodayResponse> call, Response<AIringTodayResponse> response) {
                List<TvAiringToday> airingTodays = response.body().getResults();
                for (int i=0;i<airingTodays.size();i++){
                    air = new AiringTodayList(airingTodays.get(i).getVote_average(),airingTodays.get(i).getPoster_path(),airingTodays.get(i).getId());
                    airingTodayLists.add(air);
                    adapter.notifyItemInserted(i);
//
                }
            }

            @Override
            public void onFailure(Call<AIringTodayResponse> call, Throwable t) {

            }
        });

        Log.i("Btafir","lsadad");


        Call<populatTvShowsResponse> call1 = service.getPopularTvShows(Config.API_KEY);
        call1.enqueue(new Callback<populatTvShowsResponse>() {
            @Override
            public void onResponse(Call<populatTvShowsResponse> call, Response<populatTvShowsResponse> response) {
                List<popularTvShows> upperList= response.body().getResults();
                Log.i("JOTIKEY",upperList.size()+"");
                for(int i=0;i<upperList.size();i++){
                    tvPopular = new TVListPopular(upperList.get(i).getOriginal_name(),upperList.get(i).getPoster_path(),upperList.get(i).getId(),upperList.get(i).getVote_average(),upperList.get(i).getBackdrop_path());
                    tvListPopularList.add(tvPopular);
                    Log.d("JOMANA " + i,tvListPopularList.size()+"");
                    adapterPopular.notifyItemInserted(i);
                    urlMapsTv.put(upperList.get(i).getOriginal_name(),upperList.get(i).getBackdrop_path());
                }
                displayDataa(urlMapsTv);
            }

            @Override
            public void onFailure(Call<populatTvShowsResponse> call, Throwable t) {

            }
        });


        return view;
    }
    public void displayDataa(HashMap<String,String>urlMapsTv){
        for(String name : urlMapsTv.keySet()){
            TextSliderView textSliderView = new TextSliderView(getContext());
            textSliderView.description(name)
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .image("https://image.tmdb.org/t/p/w500" + urlMapsTv.get(name))
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            mSlider.addSlider(textSliderView);
        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.RotateDown);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(4000);
        mSlider.addOnPageChangeListener(this);
    }

    @Override
    public void onSliderClick(BaseSliderView slider) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    @Override
    public void tvItemClicked(View view, long id) {
        TvDetailFragment detailFragment = new TvDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("TVId",id);
        detailFragment.setArguments(bundle);
        FragmentTransaction transaction  =getFragmentManager().beginTransaction();
        transaction.replace(R.id.rootTvDet,detailFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
        transaction.addToBackStack(null);
        transaction.commit();

    }
}
