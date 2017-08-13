package com.example.rohanmalik.finalmovie;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.MoviesTab.GenereAdapter;
import com.example.rohanmalik.finalmovie.MoviesTab.Generes;
import com.example.rohanmalik.finalmovie.MoviesTab.InTheratresBase;
import com.example.rohanmalik.finalmovie.MoviesTab.MovieDetailFragment;
import com.example.rohanmalik.finalmovie.MoviesTab.UpcomingMovieBase;
import com.example.rohanmalik.finalmovie.model.GeneresCo;
import com.example.rohanmalik.finalmovie.model.GeneresModel;
import com.example.rohanmalik.finalmovie.model.InTheatres;
import com.example.rohanmalik.finalmovie.model.IntheatresResponse;
import com.example.rohanmalik.finalmovie.model.UpcomingMovie;
import com.example.rohanmalik.finalmovie.model.upcomingMovieResponse;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rohan Malik on 27-07-2017.
 */

public class UpcomingMovies extends Fragment implements BaseSliderView.OnSliderClickListener,ViewPagerEx.OnPageChangeListener,ItemClickListener {
    private SliderLayout mSlider;
    UpcomingMovieBase baseClass;
    InTheratresBase theratresBase;
    TextView UpComingTitle;
    TextView RunningTitle;
    RecyclerView recycleUpcoming;
    PopularMovieAdapter adapter;
    PopularMovieAdapter adapter1;
    List<UpcomingMovieBase> listUpcoming;
    RecyclerView recycleCurrent;
    RecyclerView recycleGenere;
    List<Generes> generesList;
    Generes generesFall;
    GenereAdapter genereAdapter;



    List<InTheratresBase> inTheatresList;
    public UpcomingMovies() {

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.upcoming_movies, container, false);

        inTheatresList = new ArrayList<>();
        listUpcoming = new ArrayList<>();
        generesList = new ArrayList<>();
        recycleUpcoming = (RecyclerView)view.findViewById(R.id.recycler_upcoming_movie);
        recycleCurrent = (RecyclerView)view.findViewById(R.id.recycler_running_movie);
        recycleGenere = (RecyclerView)view.findViewById(R.id.recycleGeneres);
        LinearLayoutManager manager=  new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.HORIZONTAL,false);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(),3);
        recycleUpcoming.setLayoutManager(manager);
        recycleGenere.setLayoutManager(gridLayoutManager);
        recycleCurrent.setLayoutManager(layoutManager);
        adapter = new PopularMovieAdapter(2,listUpcoming,getContext(),this);
        adapter1 = new PopularMovieAdapter(inTheatresList,true,3,getContext(),this);
        genereAdapter = new GenereAdapter(generesList,getContext());
        recycleUpcoming.setAdapter(adapter);
        recycleCurrent.setAdapter(adapter1);
        recycleGenere.setAdapter(genereAdapter);
        UpComingTitle = (TextView)view.findViewById(R.id.TitleUpcomingMovie);
        RunningTitle = (TextView)view.findViewById(R.id.TitleInThetresMovie);
        UpComingTitle.setText("Upcoming Movies");
        RunningTitle.setText("In Theatres");
        Typeface tface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/huelic_b.ttf");
        RunningTitle.setTypeface(tface);
        UpComingTitle.setTypeface(tface);
        mSlider = (SliderLayout) view.findViewById(R.id.slider);
        final HashMap<String, String> urlMaps = new HashMap<>();
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<upcomingMovieResponse> call = service.getUpcomingMovies(Config.API_KEY);
        call.enqueue(new Callback<upcomingMovieResponse>() {
            @Override
            public void onResponse(Call<upcomingMovieResponse> call, Response<upcomingMovieResponse> response) {
                List<UpcomingMovie> upcomingMovies = response.body().getResults();
                urlMaps.put(upcomingMovies.get(1).getTitle(), upcomingMovies.get(1).getBackdrop_path());
                urlMaps.put(upcomingMovies.get(3).getTitle(), upcomingMovies.get(3).getBackdrop_path());
                urlMaps.put(upcomingMovies.get(5).getTitle(), upcomingMovies.get(5).getBackdrop_path());
                urlMaps.put(upcomingMovies.get(7).getTitle(), upcomingMovies.get(7).getBackdrop_path());
                urlMaps.put(upcomingMovies.get(9).getTitle(), upcomingMovies.get(9).getBackdrop_path());
                urlMaps.put(upcomingMovies.get(12).getTitle(), upcomingMovies.get(12).getBackdrop_path());
                takeOff(urlMaps);
                for(int i=0;i<20;i++){
                    baseClass = new UpcomingMovieBase(upcomingMovies.get(i).getPoster_path(),upcomingMovies.get(i).getRelease_date(),upcomingMovies.get(i).getId());
                    Log.i("NimoId",baseClass.getId()+"");
                    listUpcoming.add(baseClass);
                    adapter.notifyItemInserted(i);
                }

            }

            @Override
            public void onFailure(Call<upcomingMovieResponse> call, Throwable t) {
                Log.d("findOur", t.toString());
            }
        });

        Call<IntheatresResponse> call1 = service.getCurrent(Config.API_KEY,"US");
        call1.enqueue(new Callback<IntheatresResponse>() {
            @Override
            public void onResponse(Call<IntheatresResponse> call, Response<IntheatresResponse> response) {
                Log.d("Nini",call.request().url().toString());
                List<InTheatres> theatres = response.body().getResults();
                for (int i=0;i<theatres.size();i++){
                    theratresBase  = new InTheratresBase(theatres.get(i).getVote_average(),theatres.get(i).getPoster_path(),theatres.get(i).getId());
                    inTheatresList.add(theratresBase);
                    adapter1.notifyItemInserted(i);
                }

            }

            @Override
            public void onFailure(Call<IntheatresResponse> call, Throwable t) {
            }
        });


        Call<GeneresModel> call2 = service.getGeneresName(Config.API_KEY);
        call2.enqueue(new Callback<GeneresModel>() {
            @Override
            public void onResponse(Call<GeneresModel> call, Response<GeneresModel> response) {
                List<GeneresCo> generesCoList =  response.body().getGenres();
                for(int i=0;i<generesCoList.size();i++){
                    generesFall = new Generes(generesCoList.get(i).getId(),generesCoList.get(i).getName());
                    generesList.add(generesFall);
                    genereAdapter.notifyItemInserted(i);
                }
            }

            @Override
            public void onFailure(Call<GeneresModel> call, Throwable t) {

            }
        });




        return view;
    }

    private void takeOff(HashMap<String, String> urlMaps) {
        for (String name : urlMaps.keySet()) {
            TextSliderView textSliderView = new TextSliderView(getContext());
            View view1 = textSliderView.getView();
            TextView text = (TextView)view1.findViewById(R.id.description);
            Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),"fonts/huelic_b.ttf");
            text.setTypeface(tf);

            textSliderView.description(name)
                    .setScaleType(BaseSliderView.ScaleType.Fit)
                    .image("https://image.tmdb.org/t/p/w500" + urlMaps.get(name))
                    .setOnSliderClickListener(this);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", name);
            mSlider.addSlider(textSliderView);
        }
        mSlider.setPresetTransformer(SliderLayout.Transformer.FlipHorizontal);
        mSlider.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        mSlider.setCustomAnimation(new DescriptionAnimation());
        mSlider.setDuration(4000);
        mSlider.addOnPageChangeListener(this);

    }

    @Override
    public void onStop() {
        mSlider.stopAutoCycle();
        super.onStop();
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
    public void onItemClick(View view, long id) {
        MovieDetailFragment detailFragment = new MovieDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("MovieId",id);
        detailFragment.setArguments(bundle);
        FragmentTransaction transaction  =getFragmentManager().beginTransaction();
        transaction.replace(R.id.root_frame,detailFragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();
        Log.d("New","MAiN");
    }
}
