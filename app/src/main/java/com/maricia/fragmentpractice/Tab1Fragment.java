package com.maricia.fragmentpractice;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;


public class Tab1Fragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab1Fragment";
     View view;
     Tab1Fragment tab1Fragment;
     String title;
     TextView titleTextView;





    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab1_fragment, container, false);
        Log.d(TAG, "onCreateView: " );
        titleTextView = (TextView)view.findViewById(R.id.titleTextView);
        new ReadFromNASCAR().execute();
        titleTextView.setText("test");
        return view;
    }



    public void displayTitle(String title){
        Log.d(TAG, "displayTitle: 2 " + title);
        tab1Fragment.titleTextView.setText(title);

        // showText(title);
      //  tab1Fragment = (Tab1Fragment) getChildFragmentManager().findFragmentById(R.id.titleTextView);
       //now to display it on the screen as a title
        // titleTextView = getView().findViewById(R.id.titleTextView);
       //titleTextView.setText(title);
    }


    private class ReadFromNASCAR extends AsyncTask<String, Void, String> {
        private static final String TAG = "ReadFromNASCAR";
        public Document doc = null;
        public TextView titleTextView;

        ProgressDialog progressDialog;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog = ProgressDialog.show(getContext(),//Tab1Fragment.this,
                    "ProgressDialog",
                    " Just Waiting ");
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                doc = Jsoup.connect("https://www.nascar.com/standings/monster-energy-nascar-cup-series/").get();
            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "doInBackground: "+ doc.title());

            return doc.title();
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();
           // titleTextView.setText(s);

        }
    }
}
