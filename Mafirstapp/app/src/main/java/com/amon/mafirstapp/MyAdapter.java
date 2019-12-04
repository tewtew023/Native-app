package com.amon.mafirstapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private String[] mDataset;
    private Context mContext;
    private String[] pic;
    private String[] name;
    private String[] category;


    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case




        TextView category;
        ImageView imgView;
        public TextView title;
        public MyViewHolder(View v) {
            super(v);
            this.title = (TextView) itemView.findViewById(R.id.title);
            this.category = (TextView) itemView.findViewById(R.id.category);
        }

    }

    public MyAdapter(Context mContext, String[] pic , String[] name, String[] category) {

        this.mContext = mContext;
        this.category=category;
        this.pic=pic;
        this.name=name;


    }

    // Create new views (invoked by the layout manager)
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                     int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.my_text_view, parent, false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
//        holder.textView.setText(mDataset[position]);
        holder.title.setText(name[position]);
        holder.category.setText(category[position]);
//        holder.subtitle.setText(msubTitle[i]);
//        Picasso.with(mContext).load(mImage[i]).into(holder.imgView);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return name.length;
    }
}