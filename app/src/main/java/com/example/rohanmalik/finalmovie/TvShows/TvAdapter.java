package com.example.rohanmalik.finalmovie.TvShows;

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
import com.example.rohanmalik.finalmovie.TVListPopular;
import com.example.rohanmalik.finalmovie.model.AIringTodayResponse;
import com.squareup.picasso.Picasso;

import java.io.Flushable;
import java.util.List;

/**
 * Created by Rohan Malik on 03-08-2017.
 */

public class TvAdapter extends RecyclerView.Adapter<TvAdapter.TvHolder>{
    List<AiringTodayList> airingTodayLists;
    List<TVSeasons> tvSeasonsList;
    TVClickListener tvListener;
    List<TVListPopular> tvListPopulars;
    Context context;
    int flag;

    public TvAdapter(List<AiringTodayList> airingTodayLists, Context context,TVClickListener tvListener,int flag) {
        this.airingTodayLists = airingTodayLists;
        this.context = context;
        this.tvListener=tvListener;
        this.flag=flag;
    }
    public TvAdapter(List<TVSeasons> tvSeasonsList,int flag,Context context){
        this.tvSeasonsList=tvSeasonsList;
        this.context=context;
        this.flag=flag;
    }
    public TvAdapter(int flag,Context context,List<TVListPopular> tvListPopulars,TVClickListener tvListener){
        this.flag=flag;
        this.tvListPopulars=tvListPopulars;
        this.context=context;
        this.tvListener=tvListener;
    }

    @Override
    public TvHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_home_design_list,parent,false);
        return new TvHolder(view,tvListener);
    }

    @Override
    public void onBindViewHolder(TvHolder holder, int position) {
        AiringTodayList airingToday;
        TVSeasons tvseason;
        TVListPopular tvPopular;
        if(flag==0) {
            airingToday = airingTodayLists.get(position);
            holder.textView.setText(airingToday.getVoteAverage() + "");
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + airingToday.getPoster()).into(holder.imageView);
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/huelic_b.ttf");
            holder.textView.setTypeface(tf);
        }
        else if(flag==1){
            tvseason = tvSeasonsList.get(position);
            holder.textView.setText(tvseason.getSeasonNumber() + "");
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + tvseason.getPoster_path()).into(holder.imageView);
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/huelic_b.ttf");
            holder.textView.setTypeface(tf);
        }
        else if(flag==2){
            tvPopular = tvListPopulars.get(position);
            holder.textView.setText(tvPopular.getVote() + "");
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + tvPopular.getPoster()).into(holder.imageView);
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/huelic_b.ttf");
            holder.textView.setTypeface(tf);
        }
    }

    @Override
    public int getItemCount() {
        if(flag==0){return airingTodayLists.size();}
        else if (flag==1){return tvSeasonsList.size();}
        else if(flag==2){return tvListPopulars.size();}
        else {return 20;}
    }

    class TvHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        ImageView imageView;
        TextView textView;
        TVClickListener tvClickListener;

        public TvHolder(View itemView,TVClickListener tvClickListener) {
            super(itemView);
            imageView = (ImageView)itemView.findViewById(R.id.popular_cover);
            textView = (TextView)itemView.findViewById(R.id.category_count);
            this.tvClickListener=tvClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int pos = getAdapterPosition();
            long id;
            if(flag==1) {
                 id = airingTodayLists.get(pos).getId();
            }
            else if(flag==2){
                id=tvListPopulars.get(pos).getId();
            }
            else {
                id=110;
            }
            tvClickListener.tvItemClicked(view,id);
        }
    }
}

