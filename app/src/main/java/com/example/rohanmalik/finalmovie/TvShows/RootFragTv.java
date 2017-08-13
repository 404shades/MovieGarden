package com.example.rohanmalik.finalmovie.TvShows;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.rohanmalik.finalmovie.FavouriteMovies;
import com.example.rohanmalik.finalmovie.R;
import com.example.rohanmalik.finalmovie.UpcomingMovies;


/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class RootFragTv extends Fragment {
    public RootFragTv(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.root_tv,container,false);


        FragmentTransaction transaction  = getFragmentManager().beginTransaction();
        transaction.replace(R.id.rootTvDet,new FavouriteMovies());
        transaction.commit();
        return view;
    }
}
