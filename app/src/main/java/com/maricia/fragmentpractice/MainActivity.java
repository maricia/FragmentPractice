package com.maricia.fragmentpractice;


import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TextView;

import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.constants.Style;
import com.mapbox.mapboxsdk.maps.MapboxMap;


public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private SectionsPageAdapter mSectionsPageAdapter;

    private ViewPager mViewPager;
    private TextView mailTextView2;
    private MapboxMap mapboxMap;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "onCreate: starting" );

        // Mapbox Access token
        Mapbox.getInstance(getApplicationContext(),getString(R.string.map_box_token));

        mSectionsPageAdapter = new SectionsPageAdapter(getSupportFragmentManager());  // sections page adapter
        //Set up the View Pager with sections adapter
        mViewPager = (ViewPager) findViewById(R.id.container);

        setupViewPager(mViewPager);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.if_tool);
        tabLayout.getTabAt(2).setIcon(R.drawable.if_12);
        tabLayout.getTabAt(1).setIcon(R.drawable.if_rotation_job_seeker_employee_unemployee_work);
        tabLayout.getTabAt(3).setIcon(R.drawable.ic_public_white);

        /*
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        */

    }

    private void setupViewPager(ViewPager viewPager){
        SectionsPageAdapter adapter = new SectionsPageAdapter(getSupportFragmentManager());
        adapter.addFragment(new SkillsFragment(), "Skills");
        adapter.addFragment(new workFragment(), "Work");
        adapter.addFragment(new EducationFragment(), "Edu");
        adapter.addFragment(new WebsiteFragment(), "Website");
        viewPager.setAdapter(adapter);
        //tabLayout.setupWithViewPager(viewPager);


    }

    private void setupEmail(){
        String TO = "maricia.a.alleman@gmail.com";
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "From App");
    }


    //button
    public void onClick(View arg0){
        mailTextView2 =this.findViewById(R.id.mailTextView2);
        setupEmail();
    }

    public void setMapboxMap(MapboxMap map) {
        // we need to set mapboxmap on the parent activity,
        // for auto-generated ui tests
        mapboxMap = map;
        mapboxMap.setStyleUrl(Style.DARK);
        mapboxMap.moveCamera(CameraUpdateFactory.zoomTo(18));
    }
}
