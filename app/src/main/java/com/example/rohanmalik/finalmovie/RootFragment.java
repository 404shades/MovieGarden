package com.example.rohanmalik.finalmovie;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class RootFragment extends Fragment {
    private static final String TAG = "RootFragment";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.root_fragment,container,false);

        FragmentTransaction transaction  = getFragmentManager().beginTransaction();
        transaction.replace(R.id.root_frame,new UpcomingMovies());
        transaction.commit();
        return view;
    }
}
