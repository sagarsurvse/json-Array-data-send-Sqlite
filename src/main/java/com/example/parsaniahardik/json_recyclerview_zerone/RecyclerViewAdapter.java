package com.example.parsaniahardik.json_recyclerview_zerone;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Aws on 11/03/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext ;
    private List<RogerModel> mData ;



    public RecyclerViewAdapter(MainActivity mContext, List<RogerModel> mData) {
        this.mContext = mContext;
        this.mData = mData;



    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.rv_item,parent,false) ;
        final MyViewHolder viewHolder = new MyViewHolder(view) ;
        viewHolder.view_container.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(mContext, SqliteActivity.class);

                i.putExtra("name",mData.get(viewHolder.getAdapterPosition()).getName());
                i.putExtra("city",mData.get(viewHolder.getAdapterPosition()).getCity());
                i.putExtra("country",mData.get(viewHolder.getAdapterPosition()).getCountry());



                mContext.startActivity(i);

            }
        });




        return viewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.name.setText(mData.get(position).getName());
        holder.city.setText(mData.get(position).getCity());
        holder.country.setText(mData.get(position).getCountry());
        Picasso.get().load(mData.get(position).getImgURL()).into(holder.iv);



    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView country, name, city;
        ImageView iv;
        LinearLayout view_container;








        public MyViewHolder(View itemView) {
            super(itemView);

            view_container = itemView.findViewById(R.id.container);

            name = itemView.findViewById(R.id.name);
            city = itemView.findViewById(R.id.city);
            country = itemView.findViewById(R.id.country);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

}
