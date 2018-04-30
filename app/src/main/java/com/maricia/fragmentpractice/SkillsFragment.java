package com.maricia.fragmentpractice;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class SkillsFragment extends Fragment{
    private static final String TAG = "ExperienceFragment";
    View view;
    private RecyclerView skillRecyclerView;
    private List<skills> skillList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.skills_fragment, container, false);
       RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext(), skillList);
        skillRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        skillRecyclerView.setAdapter(recyclerViewAdapter);
        return view;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        skillList = new ArrayList<>();
        skillList.add(new skills("Java",90, R.drawable.ic_java_white));
        skillList.add(new skills("Python", 50 , R.drawable.ic_python_black) );
        skillList.add(new skills("Map Reduce",90,R.drawable.ic_map_reduce_black) );
        skillList.add(new skills("HTML/CSS", 100, R.drawable.ic_html_black) );
        skillList.add(new skills("Adobe",90,R.drawable.ic_adobe_red) );
        skillList.add(new skills("Android",90,R.drawable.ic_android_black_24dp) );
        skillList.add(new skills("Linux",70,R.drawable.ic_tux_black) );
        skillList.add(new skills("Windows",90,R.drawable.ic_windows_black) );
    }
}
