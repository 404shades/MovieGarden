package com.example.rohanmalik.finalmovie.MoviesTab;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohanmalik.finalmovie.R;
import com.example.rohanmalik.finalmovie.model.Company;
import com.squareup.picasso.Picasso;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


/**
 * Created by Rohan Malik on 04-08-2017.
 */

public class CastAdapter extends RecyclerView.Adapter<CastAdapter.CastHolder>{
    List<CastList> sadList;
    Context context;
    public CastAdapter(List<CastList> sadList, Context context) {
        this.sadList = sadList;
        this.context = context;
    }
    @Override
    public CastHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View viee = LayoutInflater.from(parent.getContext()).inflate(R.layout.cast_list,parent,false);
        return new CastHolder(viee);
    }

    @Override
    public void onBindViewHolder(CastHolder holder, int position) {
            CastList castfu = sadList.get(position);
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + castfu.getProfile()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return sadList.size();
    }

    class CastHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        public CastHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.cast_mpvie);
        }
    }
}