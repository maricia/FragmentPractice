package com.maricia.fragmentpractice;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Tab1Fragment extends android.support.v4.app.Fragment{
    private static final String TAG = "Tab1Fragment";
     TextView titleTextView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.tab1_fragment, container, false);

        new ReadFromNASCAR().execute();




        return view;
    }


    public void displayTitle(String title){

        titleTextView = titleTextView.findViewById(R.id.titleTextView);
        titleTextView.setText(title);

    }



}
