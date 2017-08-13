package com.example.rohanmalik.finalmovie;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.PixelCopy;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohanmalik.finalmovie.MoviesTab.InTheratresBase;
import com.example.rohanmalik.finalmovie.MoviesTab.SimilarList;
import com.example.rohanmalik.finalmovie.MoviesTab.UpcomingMovieBase;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Rohan Malik on 29-07-2017.
 */

public class PopularMovieAdapter extends RecyclerView.Adapter<PopularMovieAdapter.PopularHolder> {
    List<PopularMoviesList> popularMoviesLists;
    List<TVListPopular> tvListPopulars;
    List<UpcomingMovieBase> upcomingMovieBaseList;
    List<InTheratresBase> inTheratresBases;
    List<SimilarList> similarMovies;
    ItemClickListener itemClickListener;
    int flag;
    Boolean flag1=false;
    Context context;

    public PopularMovieAdapter(List<InTheratresBase> inTheratresBases, Boolean flag1,int flag, Context context,ItemClickListener itemClickListener) {
        this.inTheratresBases = inTheratresBases;
        this.flag1 = flag1;
        this.context = context;
        this.flag=flag;
        this.itemClickListener=itemClickListener;
    }
    public PopularMovieAdapter(List<SimilarList> similarMovies,Boolean flag1,int flag,Context context){
        this.similarMovies=similarMovies;
        this.flag1=flag1;
        this.context=context;
        this.flag=flag;
    }

    public PopularMovieAdapter(List<PopularMoviesList> popularMoviesLists, Context context, int flags) {
        this.popularMoviesLists = popularMoviesLists;
        this.context = context;
        this.flag=flag;
    }

    public PopularMovieAdapter(List<TVListPopular> tvListPopulars, int flag, Context context) {
        this.tvListPopulars = tvListPopulars;
        this.flag = flag;
        this.context = context;
    }

    public PopularMovieAdapter(int flag, List<UpcomingMovieBase> upcomingMovieBaseList, Context context,ItemClickListener itemClickListener) {
        this.upcomingMovieBaseList = upcomingMovieBaseList;
        this.flag = flag;
        this.context = context;
        this.itemClickListener = itemClickListener;
    }

    @Override
    public PopularHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.popular_home_design_list,parent,false);
        return new PopularHolder(view,itemClickListener);
    }

    @Override
    public void onBindViewHolder(PopularHolder holder, int position) {
        InTheratresBase inTheratres;
        PopularMoviesList popular;
        TVListPopular tvpopular;
        UpcomingMovieBase upcomingMovieBase;
        SimilarList similarList;
        if(flag==0) {
           popular = popularMoviesLists.get(position);
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500/" + popular.getThumbnail()).into(holder.imageView);
            holder.movieRating.setText(popular.getRating() + "");
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/huelic_b.ttf");
            holder.movieRating.setTypeface(tf);
        }
        else if (flag==1) {
            tvpopular = tvListPopulars.get(position);
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500/" + tvpopular.getPoster()).into(holder.imageView);
            holder.movieRating.setText(tvpopular.getVote() + "");
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/huelic_b.ttf");
            holder.movieRating.setTypeface(tf);
        }
        else if(flag==2){
            upcomingMovieBase = upcomingMovieBaseList.get(position);
            Log.d("Kikaa",upcomingMovieBase.getId()+"");
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + upcomingMovieBase.getPoster_path()).into(holder.imageView);
            holder.movieRating.setText(upcomingMovieBase.getReleaseDate() + "");
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/huelic_b.ttf");
            holder.movieRating.setTypeface(tf);

        }
        else if(flag==3){

            inTheratres = inTheratresBases.get(position);
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + inTheratres.getPoster_path()).into(holder.imageView);
            holder.movieRating.setText(inTheratres.getVoteAverage() + "");
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/huelic_b.ttf");
            holder.movieRating.setTypeface(tf);
        }
        else if(flag==4){
            similarList = similarMovies.get(position);
            Picasso.with(context).load("https://image.tmdb.org/t/p/w500" + similarList.getPoster_path()).into(holder.imageView);
            holder.movieRating.setText(similarList.getAvg()+"");
            Typeface tf = Typeface.createFromAsset(context.getAssets(), "fonts/huelic_b.ttf");
            holder.movieRating.setTypeface(tf);
        }
        }

    @Override
    public int getItemCount() {
        if(flag==0){return popularMoviesLists.size();}
        else if(flag==1) {return tvListPopulars.size();}
        else if(flag==2){return upcomingMovieBaseList.size();}
        else if(flag==3){return inTheratresBases.size();}
        else if(flag==4){return similarMovies.size();}
        else {return 10;}
    }

    class PopularHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageView;
        TextView movieRating;
        ItemClickListener lisenBaby;
        public PopularHolder(View itemView,ItemClickListener lisenBaby) {
            super(itemView);
            this.lisenBaby = lisenBaby;
            imageView = (ImageView)itemView.findViewById(R.id.popular_cover);
            itemView.setOnClickListener(this);
            movieRating =  (TextView)itemView.findViewById(R.id.category_count);
        }

        @Override
        public void onClick(View view) {
            long ID;
            int pos;
            if(flag==2){
                pos=getAdapterPosition();
                ID=upcomingMovieBaseList.get(pos).getId();
            }
            else if(flag==3){
                pos=getAdapterPosition();
                ID=inTheratresBases.get(pos).getId();
            }
            else {
                ID=12;
            }
            Log.d("MOvieIds",ID+"");
            lisenBaby.onItemClick(view,ID);

        }
    }
}
interface ItemClickListener{
    void onItemClick(View view,long id);
}
