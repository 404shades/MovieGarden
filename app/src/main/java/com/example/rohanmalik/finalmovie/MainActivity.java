package com.example.rohanmalik.finalmovie;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.TvShows.RootFragTv;
import com.example.rohanmalik.finalmovie.model.popularMovie;
import com.example.rohanmalik.finalmovie.model.popularMovieResponse;
import com.example.rohanmalik.finalmovie.model.popularTvShows;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity{
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    RootFragTv rootFragTv;
    Popularmovies popularmovies;
    RootFragment rootFrag;
    List<Fragment> mFragmentList;
    ViewPagerAdapter adapter;
    CoordinatorLayout mLayout;













    private String API_KEY = "1a43f1f22e3cf15ce2cfd8ca5af13e6f";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);







        mFragmentList= new ArrayList<>();
        long startMs = System.currentTimeMillis();

        mViewPager = (ViewPager)findViewById(R.id.viewPager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        popularmovies = new Popularmovies();
//        Blurry.with(MainActivity.this)
//                .radius(25)
//                .sampling(10)
//                .async()
//                .onto((ViewGroup) findViewById(R.id.mainBackground));
//        Log.d(getString(R.string.app_name),
//                "TIME " + String.valueOf(System.currentTimeMillis() - startMs) + "ms");

         rootFrag= new RootFragment();
        rootFragTv = new RootFragTv();
        mFragmentList.add(popularmovies);
        AssetManager manager = getAssets();
        mFragmentList.add(rootFrag);
        mFragmentList.add(rootFragTv);
        final Random random = new Random();
        adapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mViewPager.setOffscreenPageLimit(3);
//        mViewPager.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View view, MotionEvent motionEvent) {
//                return false;
//            }
//        });
//        mLayout = (CoordinatorLayout)findViewById(R.id.mainBackground);
//        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
//        Call<popularMovieResponse> call = service.getPopularMovies(API_KEY);
//        call.enqueue(new Callback<popularMovieResponse>() {
//            @Override
//            public void onResponse(Call<popularMovieResponse> call, Response<popularMovieResponse> response) {
//                List<popularMovie> moviesbg = response.body().getResults();
//                int val = random.nextInt(moviesbg.size());
//                String pathbg = moviesbg.get(5).getPosterPath();
//                Picasso.with(MainActivity.this).load("https://image.tmdb.org/t/p/w500/" + pathbg).into(new Target() {
//                    @Override
//                    public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
//                        mLayout.setBackgroundDrawable(new BitmapDrawable(getApplicationContext().getResources(),bitmap));
//                    }
//
//                    @Override
//                    public void onBitmapFailed(Drawable errorDrawable) {
//
//                    }
//
//                    @Override
//                    public void onPrepareLoad(Drawable placeHolderDrawable) {
//
//                    }
//                });
//
//            }

//            @Override
//            public void onFailure(Call<popularMovieResponse> call, Throwable t) {
//
//            }
//        });
//
    }
    class ViewPagerAdapter extends FragmentPagerAdapter{
        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }
        @Override
        public Fragment getItem(int position) {
            Bundle bundle  = new Bundle();
            bundle.putCharSequence("title",getPageTitle(position));
            return mFragmentList.get(position);
        }
        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position){
                case 0:
                    return "Home";
                case 1:
                    return "Movies";
                case 2:
                    return "Tv Series";
            }
            return null;
        }
    }
}