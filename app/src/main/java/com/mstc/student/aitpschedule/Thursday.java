package com.mstc.student.aitpschedule;



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
import java.util.Calendar;
import java.util.List;


public class Thursday extends Fragment {

    final List<AitpEvent> thursdayEventList = new ArrayList<>();
    private String show = "";

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
                AitpEvent.EventCategory.GENERAL,this.getCalendar(2016, 3, 7, 10,0)));
        thursdayEventList.add(new AitpEvent("Registration", "Registration, Information and Career Fair Preview", "02:00pm - 09:00pm", "Grand Ballroom Foyer",
                AitpEvent.EventCategory.GENERAL,this.getCalendar(2016, 3, 7, 10, 0)));
        thursdayEventList.add(new AitpEvent("Contest Concierge", "Contest Concierge: Bring-Your-Own-Computer Checkup and Contest Q & A Station!", "02:00pm - 09:00pm", "Rosemont Foyer",
                AitpEvent.EventCategory.GENERAL, this.getCalendar(2016, 3, 7, 10,0)));
        thursdayEventList.add(new AitpEvent("Pre-Conference Workshop", "Pre-Conference Workshop: Sharpening your Interviewing & Networking Skills", "03:00pm - 04:00pm", "Grand C/B",
                AitpEvent.EventCategory.SESSION, this.getCalendar(2016, 3, 7, 10,0)));
        thursdayEventList.add(new AitpEvent("AITP Welcome to Chicago", "AITP Welcome to Chicago Scavenger Hunt & Reception", "04:00pm - 06:00pm", "Grand FGH",
                AitpEvent.EventCategory.GENERAL, this.getCalendar(2016, 3, 7, 10,0)));
        thursdayEventList.add(new AitpEvent("Contests", "Contests: Microsoft Office Solutions @ Systems Analysis & Design", "06:30pm  - 10:30pm", "Rosemont: Lab A/B",
                AitpEvent.EventCategory.CONTEST, this.getCalendar(2016, 3, 7, 10,0)));




        listViewAitpEvent = (ListView) v.findViewById(R.id.theListView);
        listViewAitpEvent.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, thursdayEventList));
        listViewAitpEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {


            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //listViewAitpEvent.setItemChecked(position, true);

                if(thursdayEventList.get(position).getSelected()) {
                    thursdayEventList.get(position).setSelected(false);
                } else {
                    thursdayEventList.get(position).setSelected(true);
                }

                loadList();
            }
        });
    return v;
}

    private void loadList() {
        switch(show){
            case "ALL":
                showAll(getView());
                break;
            case "FOOD":
                showFood(getView());
                break;
            case "SESSION":
                showSessions(getView());
                break;
            case "CERT":
                showCertifications(getView());
                break;
            case"CONTESTS":
                showContests(getView());
                break;
            case "GENERAL":
                showGeneral(getView());
                break;
            default:
                showAll(getView());
        }
    }

    private Calendar getCalendar(int year, int month, int day, int hour, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, year);
        c.set(Calendar.MONTH, month);
        c.set(Calendar.DAY_OF_MONTH, day);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND,0);
        return c;

    }

    //***********************************************************************************************
    //This method filters the current days events and only shows events of the contests Category
    //*********************************************************************************************
    public void showContests(View v) {
        show= "CONTESTS";
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
        show= "CERT";
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
        show= "SESSIONS";
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
        show= "FOOD";
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
        show= "ALL";
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
        show= "GENERAL";
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