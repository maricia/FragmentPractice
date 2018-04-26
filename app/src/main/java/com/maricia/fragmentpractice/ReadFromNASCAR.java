/*
package com.maricia.fragmentpractice;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ReadFromNASCAR extends AsyncTask<Object, String, String> {
    private static final String TAG = "ReadFromNASCAR";
    public Document doc = null;
    public TextView titleTextView;



    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }



    @Override
    protected String doInBackground(Object... String) {


        try {
            doc = Jsoup.connect("https://www.nascar.com/standings/monster-energy-nascar-cup-series/").get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Log.d(TAG, "doInBackground: "+ doc.title());



        return java.lang.String.valueOf(doc.title());
    }




    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        Log.d(TAG, "onPostExecute: 1 " + s);
        Tab1Fragment tab1Fragment = new Tab1Fragment();
        //tab1Fragment.titleTextView.setText(s);
        tab1Fragment.displayTitle(s);
    }



*/
