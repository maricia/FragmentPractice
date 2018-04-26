package com.maricia.fragmentpractice;

import android.os.AsyncTask;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

public class ReadFromNASCAR extends AsyncTask<String, String, String> {
    private static final String TAG = "ReadFromNASCAR";
    public Document doc = null;
    public TextView titleTextView;
    Tab1Fragment tab1Fragment;
    //Fragment Tab1Fragment;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();


    }



    @Override
    protected String doInBackground(String... strings) {


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
        Log.d(TAG, "onPostExecute: " + s);
       // tab1Fragment.displayTitle(s);


    }




}
