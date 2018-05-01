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

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    RecyclerView mRecyclerView;
    Context mContext;
    List<skills> mDate;

    //constructor
    public RecyclerViewAdapter(Context mContext, List<skills> mDate, RecyclerView recyclerView) {
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
        View v = inflater.inflate(R.layout.item_skills, parent, false);


       // View v = LayoutInflater.from(mContext).inflate(R.layout.item_skills, parent, false);
        MyViewHolder viewHolder = new MyViewHolder(v);

        //set the views sizes, margins, paddings and layout parameters

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.skill_name_TextView.setText(mDate.get(position).getSkill());
        holder.img.setImageResource(mDate.get(position).getPhoto());
        holder.skill_seekBar.setProgress(mDate.get(position).getSkillamount());
      //  holder.skill_seekBar.setEnabled(false);
        holder.skill_seekBar.getThumb().setAlpha(0);
    }

    @Override
    public int getItemCount() {
        return mDate.size();
    }





    public static class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView skill_name_TextView;
        private ImageView img;
        private SeekBar skill_seekBar;



        public MyViewHolder(View itemView) {
            super(itemView);
            skill_name_TextView = (TextView) itemView.findViewById(R.id.skill_name_textview);
            img = (ImageView) itemView.findViewById(R.id.skills_image);
            skill_seekBar = itemView.findViewById(R.id.skill_seekbar);
        }
    }
}
