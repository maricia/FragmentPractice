package com.maricia.fragmentpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class workFragment extends android.support.v4.app.Fragment {
    private static final String TAG = "workFragment";
    View view;
    private RecyclerView rcview;
    private List<work> workList;
    private WorkRecyclerViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.exper_fragment, container, false);

        rcview = (RecyclerView) view.findViewById(R.id.skillRecyclerView);
        rcview.setLayoutManager(new LinearLayoutManager(getActivity()));

        workList = new ArrayList<>();
        workList.add(new work("2014-12 \n" + "present", "System Analyst II \n" + "University of Texas of the Permian Basin \n" + "IRPE", R.drawable.if_computer_black));
        workList.add(new work("2009-10 \n" + "2014-11", "Programmer Analyst \n Network Communications Specialist\n" +"Odessa College\n" + "IS / Network Services", R.drawable.if_educationschoollearnstudy));
        workList.add(new work("2005-01 \n" + "2009-05", "Sr. PC Support Specialist\n" + "City of Odessa\n" + "IT", R.drawable.ic_map_black_24dp));
        workList.add(new work("1993-08 \n" + "2001-12", "31U - Signal Support Specialist\n" + "US Army\n", R.drawable.ic_map_black_24dp));

        adapter = new WorkRecyclerViewAdapter(getContext(), workList , rcview);
        rcview.setAdapter(adapter);
        rcview.setItemAnimator(new DefaultItemAnimator());


        return view;
    }
}
