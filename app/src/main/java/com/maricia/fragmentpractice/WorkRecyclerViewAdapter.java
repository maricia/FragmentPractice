package com.maricia.fragmentpractice;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.List;

public class WorkRecyclerViewAdapter extends RecyclerView.Adapter<WorkRecyclerViewAdapter.MyViewHolder> {

    RecyclerView mRecyclerView;
    Context mContext;
    List<work> mDate;

    //constructor
    public WorkRecyclerViewAdapter(Context mContext, List<work> mDate, RecyclerView recyclerView) {
        this.mContext = mContext;
        this.mDate = mDate;
        this.mRecyclerView = mRecyclerView;
    }


    //create new view
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        //create a new view
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.item_exp, parent, false);


       // View v = LayoutInflater.from(mContext).inflate(R.layout.item_skills, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        //set the views sizes, margins, paddings and layout parameters

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.work_date_TextView.setText(mDate.get(position).getWork_date());
        holder.work_img.setImageResource(mDate.get(position).getWork_image());
        holder.work_name_TextView.setText(mDate.get(position).getWork_name());
    }

    @Override
    public int getItemCount() {
        return mDate.size();
    }





    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView work_date_TextView;
        private TextView work_name_TextView;
        private ImageView work_img;




        public MyViewHolder(View itemView) {
            super(itemView);
            work_date_TextView = (TextView) itemView.findViewById(R.id.work_date_textview);
            work_name_TextView = (TextView) itemView.findViewById(R.id.work_name_textview) ;
            work_img = (ImageView) itemView.findViewById(R.id.work_image);

        }
    }
}
