package com.mstc.student.aitpschedule;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.support.design.widget.TabLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.os.Handler;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity {


    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.splash_screen_layout);
        Handler h = new Handler();


        h.postDelayed(new Runnable() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void run() {
                setContentView(R.layout.activity_main);
                Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
                setSupportActionBar(toolbar);


                // Create the adapter that will return a fragment for each of the three
                // primary sections of the activity.
                mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

                // Set up the ViewPager with the sections adapter.
                mViewPager = (ViewPager) findViewById(R.id.container);
                mViewPager.setAdapter(mSectionsPagerAdapter);

                TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
                tabLayout.setupWithViewPager(mViewPager);

                //initiate the floating action button
                FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

                //set the onClick listener for the floating button
                fab.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        //Show the snackbar with a message to follow AITP on twitter
                        Snackbar snackbar = Snackbar.make(view,"", Snackbar.LENGTH_LONG)
                                .setAction("Follow us on Twitter @AITPHQ", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        startTwitter();
                                    }
                                });
                        //set the action text color
                        snackbar.setActionTextColor(Color.WHITE);

                        //get the snackBar view and set the text and the text color
                        View sbView = snackbar.getView();
                        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
                        textView.setTextColor(Color.WHITE);

                        snackbar.show();
                    }
                });
            }
        }, 2000);

    }


    //*******************************************************************************************************************
    //This method will check to see if the Twitter app is installed, if so, launch it to the AITP account, otherwise it
    //reverts to the default browser to open the Twitter website
    //*******************************************************************************************************************
    public Intent startTwitter(){

        Intent intent;

        try{
            //get the Twitter app if possible
            this.getPackageManager().getPackageInfo("com.twitter.android",0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("twitter://user?screen_name=aitphq"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        }catch (Exception e){
            //no twitter app, revert to browser
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/aitphq"));
        }

        this.startActivity(intent);
        return intent;
    }

    //*********************************************************************************************************************
    //This method will open Facebook app to the AITP page if the app is installed, otherwise open FB in the default browser
    //*********************************************************************************************************************

    public Intent startFacebook(){

        Intent intent;

        try{
            //get the Twitter app if possible
            this.getPackageManager().getPackageInfo("com.facebook.android",0);
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("facebook://user?screen_name=aitphq"));
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);


        }catch (Exception e){
            //no facebook app, revert to browser
            intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://facebook.com/aitphq"));
        }

        this.startActivity(intent);
        return intent;
    }
/*
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.menu_main, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            // Handle action bar item clicks here. The action bar will
            // automatically handle clicks on the Home/Up button, so long
            // as you specify a parent activity in AndroidManifest.xml.
            int id = item.getItemId();

            //noinspection SimplifiableIfStatement
            if (id == R.id.showCertification) {
                return true;
            } else if(id == R.id.showContest){
                return true;
            }else if(id == R.id.showFood){
                return true;
            }else if(id == R.id.showGeneral){
                return true;
            }else if(id == R.id.showSession){
                return true;
            } else if(id == R.id.contact_us){
                return true;
            } else if(id == R.id.exit){
                finish();
            }

            return super.onOptionsItemSelected(item);
        }*/
        /**
         * A placeholder fragment containing a simple view.
         */


        /**
         * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
         * one of the sections/tabs/pages.
         */
        public class SectionsPagerAdapter extends FragmentPagerAdapter {

            public SectionsPagerAdapter(FragmentManager fm) {
                    super(fm);
                }

            @Override
            public Fragment getItem(int position) {
                // getItem is called to instantiate the fragment for the given page.
                // Return a PlaceholderFragment (defined as a static inner class below).
                switch (position) {
                    case 0:
                        return Thursday.newInstance();
                    case 1:
                        return Friday.newInstance();
                    case 2:
                        return Saturday.newInstance();
                    case 3:
                        return Sunday.newInstance();
                    //case 4:
                        // return Twitter.newInstance();
                }

                return null;
            }

            @Override
            public int getCount() {
                // Show 3 total pages.
                return 4;
            }

            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "Thursday";
                    case 1:
                        return "Friday";
                    case 2:
                        return "Saturday";
                    case 3:
                        return "Sunday";
                    // case 4:
                    // return "Twitter";
                }
                return null;
            }
        }
}
