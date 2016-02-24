package com.mstc.student.aitpschedule;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class EventListAdapter extends ArrayAdapter<AitpEvent> {
    private int resource;
    private LayoutInflater  inflater;
    public  EventListAdapter( Context ctx, int resourceId, List<AitpEvent> objects) {
        super( ctx, resourceId, objects );
        resource = resourceId;
        inflater = LayoutInflater.from( ctx );

    }
    @Override
    public View getView ( int position, View convertView, ViewGroup parent ) {
        convertView = inflater.inflate( resource, null );
        AitpEvent Event = getItem( position );
        TextView eventTitleTV = (TextView) convertView.findViewById(R.id.eventTitleTextView);
        eventTitleTV.setText(Event.getEvent());
        ImageView dotIV = (ImageView) convertView.findViewById(R.id.eventDotImageView);

        dotIV.setImageResource(R.drawable.red_arrow_right);

        TextView eventTimeTV = (TextView) convertView.findViewById(R.id.eventTimeTextView);
        eventTimeTV.setText(Event.getTime());










        return convertView;
    }
}
