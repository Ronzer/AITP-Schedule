package com.mstc.student.aitpschedule;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;


public class Thursday extends Fragment {

    final List<AitpEvent> thursdayEventList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.thursday_layout, container, false);
        final ListView listViewAitpEvent;


        thursdayEventList.add(new AitpEvent("AITP NCC Setup", "AITP NCC Setup Crew  Work Room and Crew Lunch", "10:00am  - 02:00pm", "Grand E",
                AitpEvent.EventCategory.GENERAL));
        thursdayEventList.add(new AitpEvent("Registration", "Registration, Information and Career Fair Preview", "02:00pm - 09:00pm", "Grand Ballroom Foyer",
                AitpEvent.EventCategory.GENERAL));
        thursdayEventList.add(new AitpEvent("Contest Concierge", "Contest Concierge: Bring-Your-Own-Computer Checkup and Contest Q & A Station!", "02:00pm - 09:00pm", "Rosemont Foyer",
                AitpEvent.EventCategory.GENERAL));
        thursdayEventList.add(new AitpEvent("Pre-Conference Workshop", "Pre-Conference Workshop: Sharpening your Interviewing & Networking Skills", "03:00pm - 04:00pm", "Grand C/B",
                AitpEvent.EventCategory.SESSION));
        thursdayEventList.add(new AitpEvent("AITP Welcome to Chicago", "AITP Welcome to Chicago Scavenger Hunt & Reception", "04:00pm - 06:00pm", "Grand FGH",
                AitpEvent.EventCategory.GENERAL));
        thursdayEventList.add(new AitpEvent("Contests", "Contests: Microsoft Office Solutions @ Systems Analysis & Design", "06:30pm  - 10:30pm", "Rosemont: Lab A/B",
                AitpEvent.EventCategory.CONTEST));

        listViewAitpEvent = (ListView) v.findViewById(R.id.theListView);
        listViewAitpEvent.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, thursdayEventList));
        listViewAitpEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //listViewAitpEvent.setItemChecked(position, true);
                Intent getThursdayDetails = new Intent(getActivity(), DetailsScreen.class);
                AitpEvent clickedEvent = thursdayEventList.get(position);

                String title = clickedEvent.getEvent();
                String description = clickedEvent.getDescription();
                String time = clickedEvent.getTime();
                String location = clickedEvent.getLocation();

                getThursdayDetails.putExtra("title", title);
                getThursdayDetails.putExtra("details", description);
                getThursdayDetails.putExtra("time", time);
                getThursdayDetails.putExtra("location", location);

                startActivity(getThursdayDetails);
            }
        });
    return v;
}

    //***********************************************************************************************
    //This method filters the current days events and only shows events of the contests Category
    //*********************************************************************************************
    public void showContests(View v) {
        final List<AitpEvent> contestList = new ArrayList<>();
        AitpEvent tempEvent;
        ListView contestListView;

        for (int count = 0; count < thursdayEventList.size(); count++) {
            tempEvent = thursdayEventList.get(count);
            if (tempEvent.getCategory() == AitpEvent.EventCategory.CONTEST) {
                contestList.add(tempEvent);
            }
        }
        contestListView = (ListView) v.findViewById(R.id.theListView);
        contestListView.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, contestList));


    }
    //***********************************************************************************************
    //This method filters the current days events and only shows events of the Certifications Category
    //*********************************************************************************************
    public void showCertifications(View v) {
        final List<AitpEvent> certificationList = new ArrayList<>();
        AitpEvent tempEvent;
        ListView contestListView;

        for (int count = 0; count < thursdayEventList.size(); count++) {
            tempEvent = thursdayEventList.get(count);
            if (tempEvent.getCategory() == AitpEvent.EventCategory.CERTIFICATION) {
                certificationList.add(tempEvent);
            }
        }
        contestListView = (ListView) v.findViewById(R.id.theListView);
        contestListView.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, certificationList));
    }
    //***********************************************************************************************
    //This method filters the current days events and only shows events of the Session Category
    //*********************************************************************************************
    public void showSessions(View v) {
        final List<AitpEvent> sessionList = new ArrayList<>();
        AitpEvent tempEvent;
        ListView contestListView;

        for (int count = 0; count < thursdayEventList.size(); count++) {
            tempEvent = thursdayEventList.get(count);
            if (tempEvent.getCategory() == AitpEvent.EventCategory.SESSION) {
                sessionList.add(tempEvent);
            }
        }
        contestListView = (ListView) v.findViewById(R.id.theListView);
        contestListView.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, sessionList));
    }
    //***********************************************************************************************
    //This method filters the current days events and only shows events of the food Category
    //*********************************************************************************************
    public void showFood(View v) {
        final List<AitpEvent> foodList = new ArrayList<>();
        AitpEvent tempEvent;
        ListView contestListView;

        for (int count = 0; count < thursdayEventList.size(); count++) {
            tempEvent = thursdayEventList.get(count);
            if (tempEvent.getCategory() == AitpEvent.EventCategory.FOOD) {
                foodList.add(tempEvent);
            }
        }
        contestListView = (ListView) v.findViewById(R.id.theListView);
        contestListView.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, foodList));
    }
    //***********************************************************************************************
    //This method filters the current days events and only shows events of the food Category
    //*********************************************************************************************
    public void showAll(View v) {
        final List<AitpEvent> foodList = new ArrayList<>();
        AitpEvent tempEvent;
        ListView contestListView;

        for (int count = 0; count < thursdayEventList.size(); count++) {
            tempEvent = thursdayEventList.get(count);
            foodList.add(tempEvent);
        }
        contestListView = (ListView) v.findViewById(R.id.theListView);
        contestListView.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, foodList));
    }
    //***********************************************************************************************
    //This method filters the current days events and only shows events of the general Category
    //*********************************************************************************************

    public void showGeneral(View v) {
        final List<AitpEvent> generalList = new ArrayList<>();
        AitpEvent tempEvent;
        ListView contestListView;

        for (int count = 0; count < thursdayEventList.size(); count++) {
            tempEvent = thursdayEventList.get(count);
            if (tempEvent.getCategory() == AitpEvent.EventCategory.GENERAL) {
                generalList.add(tempEvent);
            }
        }
        contestListView = (ListView) v.findViewById(R.id.theListView);
        contestListView.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, generalList));
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_main, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.showCertification) {
            showCertifications(getView());
        } else if(id == R.id.showContest) {
            showContests(getView());
        }else if(id == R.id.showAll){
            showAll(getView());
        }else if(id == R.id.showFood){
            showFood(getView());
        }else if(id == R.id.showGeneral){
            showGeneral(getView());
        }else if(id == R.id.showSession){
            showSessions(getView());
        } else if(id == R.id.contact_us){
            return true;
        } else if(id == R.id.exit){
            getActivity().finish();
        }

        return super.onOptionsItemSelected(item);
    }




    public static Thursday newInstance() {return new Thursday();   }

}