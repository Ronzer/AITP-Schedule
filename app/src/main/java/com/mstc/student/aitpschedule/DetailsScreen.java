package com.mstc.student.aitpschedule;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;

public class DetailsScreen extends Activity {

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        //Set the layout for the layout we created
        setContentView(R.layout.event_details_layout);

        //Get the Intent that called for this Activity to open
        Intent activityThatCalled = getIntent();

        String eventTitle = activityThatCalled.getExtras().getString("title");
        String eventDetails = activityThatCalled.getExtras().getString("details");
        String eventTime = activityThatCalled.getExtras().getString("time");
        String eventLocation = activityThatCalled.getExtras().getString("location");

        TextView title = (TextView)
                findViewById(R.id.event_name_text_view);
        TextView details = (TextView)
                findViewById(R.id.event_content_text_view);
        TextView time = (TextView)
              findViewById(R.id.event_time_text_view);

        TextView location = (TextView)
                findViewById(R.id.event_location_text_view);


        title.append(eventTitle);
        details.append(eventDetails);
        time.append(eventTime);
        location.append(eventLocation);
    }

    public void return_to_main(View view){
        finish();
    }
}
