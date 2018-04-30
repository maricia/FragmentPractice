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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class Tab1Fragment extends android.support.v4.app.Fragment {
    private static final String TAG = "Tab1Fragment";
     View view;
     String title;
     TextView titleTextView;
     String mobiletitle;
    public Document doc = null;
    public Document mobile = null;
    String standingsTitle = "";
    ProgressDialog progressDialog;  //dialog message

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tab1_fragment, container, false);
        Log.d(TAG, "onCreateView 1: " );
        titleTextView = (TextView)view.findViewById(R.id.titleTextView);
        new ReadFromNASCAR().execute();  //call background thread to read website
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
       // Log.d(TAG, "onActivityCreated: 2" );
        view.findViewById(R.id.titleTextView);
    }

    public void displayTitle(String title){
        Log.d(TAG, "displayTitle: 5 " + title);
        titleTextView.setText(title);
    }

//innerclass for background process
    private class ReadFromNASCAR extends AsyncTask<String, Void, String> {
        private static final String TAG = "Experience";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
//TODO fix title and message
            progressDialog = ProgressDialog.show(getContext(),//Tab1Fragment.this,
                    "ProgressDialog",
                    " Just Waiting ");
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                //TODO add logic in case website is unavaible
                doc = Jsoup.connect("https://www.mrn.com/2018-monster-energy-nascar-cup-series-standings/").get();
                standingsTitle = doc.title();
                Element content = doc.getElementById("content");
                Elements tables = content.getElementsByTag("tr");
                for (Element row : tables) {
                    String rowtd = row.attr("td");
                    String celltext = rowtd.toString();
                }
                Log.d(TAG, "doInBackground: " + tables);



            } catch (IOException e) {
                e.printStackTrace();
            }
            Log.d(TAG, "doInBackground: 3 "+ doc);
            //Log.d(TAG, "doInBackground: mobile" + mobile);
            return standingsTitle ; //mobile.toString()
        }


        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressDialog.dismiss();  //dismiss loading dialog
            displayTitle(s);
        }
    }
}
