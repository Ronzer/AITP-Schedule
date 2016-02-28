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
import java.util.Calendar;
import java.util.List;

public class Sunday extends Fragment {
    private String show = "";
    final List<AitpEvent> sundayEventList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.sunday_layout, container, false);

        ListView listViewAitpEvent;

        sundayEventList.add(new AitpEvent("Meeting", "AITP NCC Conference Committee Meeting and Breakfast(6:30am) \n " +
                "*Committee Members Only please", "6:30am  - 10:00am", "Hartsfield * Dulles",
                AitpEvent.EventCategory.GENERAL,this.getCalendar(2016, 3, 10, 6,30)));


        listViewAitpEvent = (ListView) v.findViewById(R.id.theListView);
        listViewAitpEvent.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, sundayEventList));


        listViewAitpEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if(sundayEventList.get(position).getSelected()) {
                    sundayEventList.get(position).setSelected(false);
                } else {
                    sundayEventList.get(position).setSelected(true);
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

        for (int count = 0; count < sundayEventList.size(); count++) {
            tempEvent = sundayEventList.get(count);
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

        for (int count = 0; count < sundayEventList.size(); count++) {
            tempEvent = sundayEventList.get(count);
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

        for (int count = 0; count < sundayEventList.size(); count++) {
            tempEvent = sundayEventList.get(count);
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

        for (int count = 0; count < sundayEventList.size(); count++) {
            tempEvent = sundayEventList.get(count);
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
        final List<AitpEvent> allList = new ArrayList<>();
        AitpEvent tempEvent;
        ListView contestListView;

        for (int count = 0; count < sundayEventList.size(); count++) {
            tempEvent = sundayEventList.get(count);
            allList.add(tempEvent);
        }
        contestListView = (ListView) v.findViewById(R.id.theListView);
        contestListView.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, allList));
    }
    //***********************************************************************************************
    //This method filters the current days events and only shows events of the general Category
    //*********************************************************************************************

    public void showGeneral(View v) {
        show= "GENERAL";
        final List<AitpEvent> generalList = new ArrayList<>();
        AitpEvent tempEvent;
        ListView contestListView;

        for (int count = 0; count < sundayEventList.size(); count++) {
            tempEvent = sundayEventList.get(count);
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
    public static Sunday newInstance() {

        return new Sunday();
    }
}
