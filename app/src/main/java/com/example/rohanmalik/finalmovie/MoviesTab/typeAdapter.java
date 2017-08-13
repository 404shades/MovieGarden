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
 * Created by Rohan Malik on 04-08-2017.
 */

public class typeAdapter extends RecyclerView.Adapter<typeAdapter.TypeHolder> {
    List<Generes> typeList;
    Context context;

    public typeAdapter(List<Generes> typeList,Context context) {
        this.typeList = typeList;
        this.context=context;
    }

    @Override
    public TypeHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.type_list_movie_det,parent,false);
        return new TypeHolder(view);
    }

    @Override
    public void onBindViewHolder(TypeHolder holder, int position) {
        Generes generes = typeList.get(position);
        holder.textType.setText(generes.getName());
        Typeface tface = Typeface.createFromAsset(context.getAssets(),"fonts/huelic_b.ttf");
        holder.textType.setTypeface(tface);
    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }

    class TypeHolder extends RecyclerView.ViewHolder {
        TextView textType;
        public TypeHolder(View itemView) {
            super(itemView);
            textType = itemView.findViewById(R.id.type_movie_item);
        }
    }
}