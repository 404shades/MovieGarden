package com.example.rohanmalik.finalmovie.Introduction;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohanmalik.finalmovie.Config;
import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.R;
import com.example.rohanmalik.finalmovie.model.RequestToken;

import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rohan Malik on 13-08-2017.
 */

public class Slide3 extends Fragment {
SessionManager manager;
    public Slide3() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        manager =  (SessionManager)context;


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.intro_slide3,container,false);
        CircleImageView imageView = (CircleImageView)view.findViewById(R.id.ClickMe);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
                Call<RequestToken> call = service.getRequestToken(Config.API_KEY);
                call.enqueue(new Callback<RequestToken>() {
                    @Override
                    public void onResponse(Call<RequestToken> call, Response<RequestToken> response) {
                        Log.d("MOKSHKADWAR",call.request().url() + "");
                        String requestToken = response.body().getRequest_token();
                        manager.getSession(requestToken);
                        loadWeb(requestToken);
                    }

                    @Override
                    public void onFailure(Call<RequestToken> call, Throwable t) {
                        Log.d("MOTIKABHN",t.toString());
                    }
                });
            }
        });
        return view;
    }

    private void loadWeb(String requestToken) {
        WebAuthFragment fragment  =  new WebAuthFragment();
        Bundle bundle=  new Bundle();
        bundle.putString("RequestToken",requestToken);
        fragment.setArguments(bundle);
        FragmentTransaction transaction  =getFragmentManager().beginTransaction();
        transaction.replace(R.id.RootNew,fragment);
        transaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
