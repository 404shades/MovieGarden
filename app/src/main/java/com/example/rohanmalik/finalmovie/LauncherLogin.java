package com.example.rohanmalik.finalmovie;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.Introduction.RootWeb;
import com.example.rohanmalik.finalmovie.Introduction.SessionManager;
import com.example.rohanmalik.finalmovie.Introduction.Slide1;
import com.example.rohanmalik.finalmovie.Introduction.Slide2;
import com.example.rohanmalik.finalmovie.Introduction.Slide3;
import com.example.rohanmalik.finalmovie.model.RequestToken;
import com.example.rohanmalik.finalmovie.model.SessionIDmodal;
import com.github.paolorotolo.appintro.AppIntro;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LauncherLogin extends AppIntro implements SessionManager {
    String requestToken;
    String user;

    @Override
    protected void onCreate(@Nullable final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        addSlide(new Slide1());
        SharedPreferences shrd = getSharedPreferences("abcd",MODE_PRIVATE);
        final String user = shrd.getString("SessionId",null);
        if(user==null) {
            addSlide(new Slide2());
            addSlide(new RootWeb());
        }
        setSeparatorColor(Color.parseColor("#01D474"));
        showSkipButton(false);
        setProgressButtonEnabled(true);
        setVibrate(true);
        setVibrateIntensity(50);
        setSlideOverAnimation();
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(user==null) {
                    ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
                    Call<SessionIDmodal> call = service.getSessionID(Config.API_KEY, requestToken);
                    call.enqueue(new Callback<SessionIDmodal>() {
                        @Override
                        public void onResponse(Call<SessionIDmodal> call, Response<SessionIDmodal> response) {
                            String sessionIdd = response.body().getSession_id();
                            if (sessionIdd != null) {
                                SharedPreferences sharedPreferences = getSharedPreferences("abcd", MODE_PRIVATE);
                                SharedPreferences.Editor mEditor = sharedPreferences.edit();
                                mEditor.putString("SessionId", sessionIdd);
                                mEditor.apply();
                                Intent intent = new Intent(LauncherLogin.this, MainActivity.class);
                                startActivity(intent);
                            }

                        }

                        @Override
                        public void onFailure(Call<SessionIDmodal> call, Throwable t) {

                        }
                    });
                }
                else if(user!=null){
                    Intent intent = new Intent(LauncherLogin.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        setOffScreenPageLimit(0);
    }

    @Override
    public void getSession(String request) {
        requestToken = request;

    }
}
