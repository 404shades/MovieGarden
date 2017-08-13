package com.example.rohanmalik.finalmovie.MoviesTab;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rohanmalik.finalmovie.R;

import java.util.List;

/**
 * Created by Rohan Malik on 02-08-2017.
 */

public class GenereAdapter extends RecyclerView.Adapter<GenereAdapter.GenereHolder> {
    List<Generes> generesList;
    Context context;

    public GenereAdapter(List<Generes> generesList, Context context) {
        this.generesList = generesList;
        this.context = context;
    }

    @Override
    public GenereHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.generes_lis,parent,false);
        return new GenereHolder(view);
    }

    @Override
    public void onBindViewHolder(GenereHolder holder, int position) {
        Generes generes = generesList.get(position);
        holder.textView.setText(generes.getName());
        Typeface tface = Typeface.createFromAsset(context.getAssets(),"fonts/huelic_b.ttf");
        holder.textView.setTypeface(tface);
    }

    @Override
    public int getItemCount() {
        return generesList.size();
    }


    class GenereHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public GenereHolder(View itemView) {
            super(itemView);
            textView  = (TextView)itemView.findViewById(R.id.GeneresItem);
        }
    }
}
