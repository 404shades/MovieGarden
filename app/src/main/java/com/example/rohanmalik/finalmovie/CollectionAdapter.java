package com.example.rohanmalik.finalmovie;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rohanmalik.finalmovie.Instancee.ApiClient;
import com.example.rohanmalik.finalmovie.Instancee.ApiInterface;
import com.example.rohanmalik.finalmovie.model.Company;
import com.squareup.picasso.Picasso;

import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Rohan Malik on 01-08-2017.
 */

public class CollectionAdapter extends RecyclerView.Adapter<CollectionAdapter.CollectionHolder> {
    CollectionTopList collectionTopList;
    Random random  = new Random();
    Context context;

    public CollectionAdapter(Context context) {
        this.context = context;
    }

    @Override
    public CollectionHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.collection_home_list,parent,false);
        return new CollectionHolder(view);
    }

    @Override
    public void onBindViewHolder(CollectionHolder holder, int position) {
        getItems(holder,position);

    }

    private void getItems(final CollectionHolder hold, int pos) {
        int val = random.nextInt(CollectionId.collection.length);
        ApiInterface service = ApiClient.getClient().create(ApiInterface.class);
        Call<Company> call = service.getCollections(CollectionId.collection[val],Config.API_KEY);
        call.enqueue(new Callback<Company>() {
            @Override
            public void onResponse(Call<Company> call, Response<Company> response) {
                Company company = response.body();
                collectionTopList = new CollectionTopList(company.getCollection_name(),company.getOverview(),company.getPoster());
                hold.collTitle.setText(collectionTopList.getName());
                hold.collOver.setText(collectionTopList.getOverview());
                Picasso.with(context).load("https://image.tmdb.org/t/p/w500/" + collectionTopList.getThumbnail()).into(hold.imagePoster);
                Typeface tf = Typeface.createFromAsset(context.getAssets(),"fonts/huelic_b.ttf");
                Typeface tface = Typeface.createFromAsset(context.getAssets(),"fonts/regular.otf");
                hold.collTitle.setTypeface(tf);
                hold.collOver.setTypeface(tface);
            }

            @Override
            public void onFailure(Call<Company> call, Throwable t) {

            }
        });
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    class CollectionHolder extends RecyclerView.ViewHolder{
        ImageView imagePoster;
        TextView collTitle;
        TextView collOver;

        public CollectionHolder(View itemView) {
            super(itemView);
            imagePoster  = (ImageView)itemView.findViewById(R.id.collection_poster);
            collOver = (TextView)itemView.findViewById(R.id.collection_overview);
            collTitle = (TextView)itemView.findViewById(R.id.collectionTitle);
        }
    }
}
