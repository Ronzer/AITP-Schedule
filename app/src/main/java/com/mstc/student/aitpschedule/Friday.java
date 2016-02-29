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


public class Friday extends Fragment {
    private String show = "";
    final List<AitpEvent> fridayEventList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.friday_layout, container, false);
        ListView listViewAitpEvent;


        //final List<AitpEvent> fridayfridayEventList= new ArrayList<>();
        fridayEventList.add(new AitpEvent("Registration","Registration and Information","07:00am  - 04:00pm", "Grand ballroom Foyer",
                AitpEvent.EventCategory.GENERAL,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Contest Concierge","Bring-Your-Own-Computer Checkup and Contest Q & A Station!","07:30am - 02:00pm", "Rosemont Foyer",
                AitpEvent.EventCategory.GENERAL,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Conference Kickoff","Conference Kickoff Breakfast & Keynote CIO Panel\n " +
                "\"The New Digital CIO - Managing Digital Transformation\"\n\n" +
                "-Hardik Bhatt, State of Illinois CIO\n" +
                "-Guy Their, Arbonne International SVP & CIO\n" +
                "-Brian Duffy, MacLean Fogg company CIO\n" +
                "-John Fisher, Rethinking IT President & Founder","07:30am - 09:00am", "Grand EFGH",
                AitpEvent.EventCategory.SESSION,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("AITP NCC Career Fair", "AITP NCC Career Fair","9:00am - 04:00pm","Grand  Ballroom Foyer",
                AitpEvent.EventCategory.GENERAL,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Break", "Morning Break","09:00am  - 10:30am", "Grand ballroom Foyer",
                AitpEvent.EventCategory.FOOD,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Certification", "COMMON's CBCA Exam","09:00am  - 4:00pm", "Grand Ballroom Foyer",
                AitpEvent.EventCategory.GENERAL,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Contest", "Database Design","09:30am  - 1:00pm", "Rosemont: Lab B",
                AitpEvent.EventCategory.CONTEST,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Contest", "PC Troubleshooting (Qualifying Exam & Finals)","09:30am  - 1:00pm", "Rosemont: Lab A",
                AitpEvent.EventCategory.CONTEST,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Contest", "AITP Student Chapter Shirt and Banner judging","10:00am  - 11:00am", "Grand Ballroom Foyer",
                AitpEvent.EventCategory.CONTEST,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Session", "Spotlight on Technology Session 1: \n\"Big Data & Business Analytics\" \n\n" +
                "\"Leveraging Big Data for Driving Improved Business Results\"\n\n " +
                "-Dr. Phil Shelley, Datametica Director\n" +
                "-Srinivas Palthepu, Capital One Senior Manager, Enterprise Data Services\n" +
                "-Alex Zoghlin, Hyatt Hotels Corporation Global Head of Technology\n" +
                "-Haibo Lu, Cancer-IQ Chief Data Officer\n" +
                "-John Broshar, Datametica Director of Sales"
                ,"10:00am - 11:00am", "Grand C/B",
                AitpEvent.EventCategory.SESSION,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Session", "Spotlight on Technology Session 2: \n\"Mobility: Business and Technology Trends\"\n\n" +
                "-Geof Pejsa, U.S. Census Bureau Program Manager: Decennial Information Technology Division\n" +
                "-Umair Lateff, McDonald's Corporation Sr. Manager/Product Owner - Global Digital Technologies\n" +
                "-Al Connelly, Americaneagle.com Senior Developer/Technology Manager - Mobile Department\n" +
                "-Simon Hunt, BMW of North America LLC Director of Product Management & Analytics","11:15am  - 12:15pm", "Grand C/B",
                AitpEvent.EventCategory.SESSION,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Break", "AITP Student Chapter & Faculty Awards Luncheon","12:15pm - 1:30pm", "Grand EFGH",
                AitpEvent.EventCategory.FOOD,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Session", "Spotlight on Technology Session 3: Security\n" +
                "\"Securing the Business - New Threats, new Defenses and Navigating Resource Shortages\"\n\n" +
                "-Kevin Novak, Northern Trust Chief Information Security Officer\n" +
                "-Ryan McElrath, Americaneagle.com Chief Technology Officer (CTO)\n" +
                "-Kirk Lonbom, State of Illinois Chief Information Security Officer\n" +
                "-Laszio Gonc, CISSO, MVP Advisory Group, LLC Security, IT Risk & Compliance Practice Lead","2:00pm - 3:00pm", "Grand C/B",
                AitpEvent.EventCategory.SESSION,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Session", "Spotlight on Your AITP Chapter Successes & Triumphs\n\n" +
                "-Carrie Drephal, AITP Central District Director, Northeastern Wisconsin AITP Chapter","2:00pm - 3:00pm", "Grand A",
                AitpEvent.EventCategory.SESSION,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Contest", "Mobile Applications sponsored by USAA","2:00pm - 6:00pm", "Rosemont: Lab B",
                AitpEvent.EventCategory.CONTEST,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Contest", "Network Design sponsored by Progressive Insurance","2:00pm - 6:00pm", "Rosemont: Lab A",
                AitpEvent.EventCategory.CONTEST,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Contest", "Enterprise Systems sponsored by IBM","2:00pm - 6:00pm", "Rosemont: Lab C",
                AitpEvent.EventCategory.CONTEST,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Session", "Spotlight on Technology Session 4: Sustainablility & Innovation\n" +
                "\"Building a Sustainable Innovation Model\"\n" +
                "-Eric Yablonka, Univ. of Chicago Medical Center and Biological, VP & CIO\n" +
                "-Moises Noreno, Allstate Director of Strategic Innovation\n" +
                "-Marian Cook, State of Illinois Chief Strategy Officer, Enterprise IT\n" +
                "-Alex Cohen, U.S. Census Bureau Program Manager, Center for Applied Technology\n" +
                "-Eric Allen, Allstate Manager of Technology Strategy","3:30pm - 4:30pm", "Grand C/B",
                AitpEvent.EventCategory.SESSION,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Session", "Spotlight on IT Research Initiatives\n\"Student IT Project & Research Poster Sessions\"","3:30pm - 4:30pm", "Grand A",
                AitpEvent.EventCategory.SESSION,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Meeting", "VIP Networkiing Mixer\n" +
                " Sponsors, Exhibitors, Speakers, Faculty and Invited Guests ONLY", "5:00pm - 6:30pm", "Ventanas (View Level)",
                AitpEvent.EventCategory.GENERAL,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Contest", "Visual Studio.net Developer","6:30pm - 10:30pm", "Rosemont: Lab A",
                AitpEvent.EventCategory.CONTEST,this.getCalendar(2016, 3, 8, 10,0)));
        fridayEventList.add(new AitpEvent("Contest", "Business Analytics","6:30pm - 10:30pm", "Rosemont: Lab B",
                AitpEvent.EventCategory.CONTEST,this.getCalendar(2016, 3, 8, 10,0)));


        listViewAitpEvent = (ListView) v.findViewById(R.id.theListView);
        listViewAitpEvent.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3,fridayEventList));
        listViewAitpEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(fridayEventList.get(position).getSelected()) {
                    fridayEventList.get(position).setSelected(false);
                } else {
                    fridayEventList.get(position).setSelected(true);
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

        for (int count = 0; count < fridayEventList.size(); count++) {
            tempEvent = fridayEventList.get(count);
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

        for (int count = 0; count < fridayEventList.size(); count++) {
            tempEvent = fridayEventList.get(count);
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

        for (int count = 0; count < fridayEventList.size(); count++) {
            tempEvent = fridayEventList.get(count);
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

        for (int count = 0; count < fridayEventList.size(); count++) {
            tempEvent = fridayEventList.get(count);
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

        for (int count = 0; count < fridayEventList.size(); count++) {
            tempEvent = fridayEventList.get(count);
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

        for (int count = 0; count < fridayEventList.size(); count++) {
            tempEvent = fridayEventList.get(count);
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


    public static Friday newInstance() {

        return new Friday();
    }
}