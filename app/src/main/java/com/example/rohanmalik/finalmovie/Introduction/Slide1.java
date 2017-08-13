package com.example.rohanmalik.finalmovie.Introduction;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohanmalik.finalmovie.Config;
import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.R;
import com.example.rohanmalik.finalmovie.model.UserDetails;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rohan Malik on 13-08-2017.
 */

public class Slide1 extends Fragment {
    public Slide1() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro_slide1,container,false);
        Typeface tf = Typeface.createFromAsset(getActivity().getAssets(),"fonts/huelic_b.ttf");
        Typeface tface = Typeface.createFromAsset(getActivity().getAssets(),"fonts/regular.otf");
        final TextView textWelcome = (TextView)view.findViewById(R.id.WelcomeUserText);
        textWelcome.setTypeface(tface);
        TextView textMovieGarden = (TextView)view.findViewById(R.id.MovieGarden);
        textMovieGarden.setText("Movie Garden");
        textMovieGarden.setTypeface(tf);
        Log.d("timeCheck","FirstOne");
        SharedPreferences shrd = getActivity().getSharedPreferences("abcd", Context.MODE_PRIVATE);
        String user = shrd.getString("SessionId",null);
        if(user==null){
            textWelcome.setText("Welcome User");
        }
        else {
            ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
            Call<UserDetails> call = service.getUserDetails(Config.API_KEY, user);
            call.enqueue(new Callback<UserDetails>() {
                @Override
                public void onResponse(Call<UserDetails> call, Response<UserDetails> response) {
                    String name = response.body().getUsername();
                    textWelcome.setText("Welcome " + name);
                }

                @Override
                public void onFailure(Call<UserDetails> call, Throwable t) {

                }
            });
        }
        return view;
    }
}
