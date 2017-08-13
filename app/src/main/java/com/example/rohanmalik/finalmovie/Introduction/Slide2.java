package com.example.rohanmalik.finalmovie.Introduction;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohanmalik.finalmovie.R;

/**
 * Created by Rohan Malik on 13-08-2017.
 */

public class Slide2 extends Fragment {

    public Slide2() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro_slide2,container,false);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),"fonts/huelic_b.ttf");
        Typeface tface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/regular.otf");
        TextView textWelcome = (TextView)view.findViewById(R.id.MovieContentIntro);
        textWelcome.setText("Get Popular,Top Rated and Upcoming Movies");
        textWelcome.setTypeface(tface);
        TextView textMovieGarden = (TextView)view.findViewById(R.id.MovieIntroContinue);
        textMovieGarden.setText("Maintain a Watchlist, Rate any Movie and add To Favourites");
        textMovieGarden.setTypeface(tf);
        Log.d("timeCheck2","Slide2");
        return view;
    }
}
