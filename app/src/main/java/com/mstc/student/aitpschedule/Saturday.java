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

public class Saturday extends Fragment {

    final List<AitpEvent> saturdayEventList = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        
        View v = inflater.inflate(R.layout.saturday_layout, container, false);
        ListView listViewAitpEvent;
        
        saturdayEventList.add(new AitpEvent("Registration and Information", "Registration and Information on the days events.", "7:30am - 02:00pm", "Grand Ballroom Foyer",
                AitpEvent.EventCategory.GENERAL));
        saturdayEventList.add(new AitpEvent("Recognition & Breakfast", "Conference Recognition Breakfast plus the announcement " +
                "of the AITP chapter banner shirt & video contest winners.", "07:30am - 08:30am", "Grand EFGH",
                AitpEvent.EventCategory.GENERAL));
        saturdayEventList.add(new AitpEvent("Contest", "Security Qualification Exams", "9:00am - 10:30am", "Rosemont: Lab A",
                AitpEvent.EventCategory.CONTEST));
        saturdayEventList.add(new AitpEvent("Contest", "Java Developer sponsored by State Farm", "9:00am - 1:00pm", "Rosemont Lab B",
                AitpEvent.EventCategory.CONTEST));
        saturdayEventList.add(new AitpEvent("Contest", "Student 'Web Project' Finalist Presentations.", "9:00am - 12:00pm", "Grand A",
                AitpEvent.EventCategory.CONTEST));
        saturdayEventList.add(new AitpEvent("Certification", "Certification: ICCP Exams (Core & Specialty Exams)", "9:00am - 4:00pm", "O'Hare(Lobby Level)",
                AitpEvent.EventCategory.CERTIFICATION));
        saturdayEventList.add(new AitpEvent("Career Fair", "AITP NCC Career Fair with Morning Break", "9:00am - 12:00pm", "Grand Ballroom Foyer",
                AitpEvent.EventCategory.FOOD));
        saturdayEventList.add(new AitpEvent("Session", "Spotlight on Technology Session 5: IT Hiring Trends \n 10 Years from Now - IT Career Futures to Plan for Now! \n " +
                "Myles Miller, LEADUP CEO and Founder", "9:00am - 10:00am", "Grand C/B",
                AitpEvent.EventCategory.SESSION));
        saturdayEventList.add(new AitpEvent("Session", "Spotlight on Technology Session 6: IT Hiring Trends \n Job Search Re-imagined. \n " +
                "Chris Czarnik, Fox Valley Technical College Manager of Employment Connections", "10:30am - 11:30am", "Grand C/B",
                AitpEvent.EventCategory.SESSION));
        saturdayEventList.add(new AitpEvent("Contest", "Security Finals", "10:30am - 1:00pm", "Rosemont: Lab A",
                AitpEvent.EventCategory.CONTEST));
        saturdayEventList.add(new AitpEvent("Lunch Break", "Lunch and the Afternoon on your own as you Explore Chicagoland. \n\n " +
                "Here are some events or activities for you to consider: \n " +
                "- AITP NCC Great Chicago Challenge (hosted by Waukesha County Technical College) \n " +
                "- AITP NCC Bowling & Trivia Challenge at Kings Bowl(hosted by Grand Valley State University)", "11:30am - 6:00pm", "Chicagoland",
                AitpEvent.EventCategory.FOOD));
        saturdayEventList.add(new AitpEvent("Session", "Conference Closing Awards Banquet", "6:30pm - 9:00pm", "Grand EFGH",
                AitpEvent.EventCategory.SESSION));


        listViewAitpEvent = (ListView) v.findViewById(R.id.theListView);
        listViewAitpEvent.setAdapter(new EventListAdapter(getContext(), R.layout.row_layout_3, saturdayEventList));
        listViewAitpEvent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Intent getSaturdayDetails = new Intent(getActivity(), DetailsScreen.class);

                AitpEvent clickedEvent = saturdayEventList.get(position);
                String title = clickedEvent.getEvent();


                String description = clickedEvent.getDescription();
                String time = clickedEvent.getTime();
                String location = clickedEvent.getLocation();

                getSaturdayDetails.putExtra("title", title);
                getSaturdayDetails.putExtra("details", description);
                getSaturdayDetails.putExtra("time", time);
                getSaturdayDetails.putExtra("location", location);

                startActivity(getSaturdayDetails);
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

        for (int count = 0; count < saturdayEventList.size(); count++) {
            tempEvent = saturdayEventList.get(count);
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

        for (int count = 0; count < saturdayEventList.size(); count++) {
            tempEvent = saturdayEventList.get(count);
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

        for (int count = 0; count < saturdayEventList.size(); count++) {
            tempEvent = saturdayEventList.get(count);
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

        for (int count = 0; count < saturdayEventList.size(); count++) {
            tempEvent = saturdayEventList.get(count);
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

        for (int count = 0; count < saturdayEventList.size(); count++) {
            tempEvent = saturdayEventList.get(count);
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

        for (int count = 0; count < saturdayEventList.size(); count++) {
            tempEvent = saturdayEventList.get(count);
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
    public static Saturday newInstance() {

        return new Saturday();
    }
}
