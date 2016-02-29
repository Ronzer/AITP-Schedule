package com.mstc.student.aitpschedule;

import java.util.List;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class EventListAdapter extends ArrayAdapter<AitpEvent> {
    private int resource;
    private LayoutInflater  inflater;
    Button detailsButton;
    public  EventListAdapter( Context ctx, int resourceId, List<AitpEvent> objects) {
        super( ctx, resourceId, objects );
        resource = resourceId;
        inflater = LayoutInflater.from( ctx );


    }
    @Override
    public View getView (final int position, View convertView, final ViewGroup parent ) {


        convertView = inflater.inflate( resource, null );
        AitpEvent Event = getItem( position );
        TextView eventTitleTV = (TextView) convertView.findViewById(R.id.eventTitleTextView);
        eventTitleTV.setText(Event.getEvent());
        ImageView checkbox = (ImageView) convertView.findViewById(R.id.eventDotImageView);

        if(!Event.getSelected()){
            checkbox.setImageResource(R.drawable.unchecked2);
        }else {
            checkbox.setImageResource(R.drawable.checked2);
        }

        TextView eventTimeTV = (TextView) convertView.findViewById(R.id.eventTimeTextView);
        eventTimeTV.setText(Event.getDateTime());
        detailsButton=(Button) convertView.findViewById(R.id.detailsButton);

        detailsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent getThursdayDetails = new Intent(parent.getContext(), DetailsScreen.class);
                AitpEvent clickedEvent = getItem(position);

                String title = clickedEvent.getEvent();
                String description = clickedEvent.getDescription();
                String time = clickedEvent.getTime();
                String location = clickedEvent.getLocation();

                getThursdayDetails.putExtra("title", title);
                getThursdayDetails.putExtra("details", description);
                getThursdayDetails.putExtra("time", time);
                getThursdayDetails.putExtra("location", location);

                parent.getContext().startActivity(getThursdayDetails);
            }
        });









        return convertView;
    }
}
