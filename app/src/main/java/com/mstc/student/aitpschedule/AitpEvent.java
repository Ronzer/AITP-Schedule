package com.mstc.student.aitpschedule;

import android.util.EventLogTags;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.text.ParseException;

public class AitpEvent {
    public  enum EventCategory{ GENERAL,FOOD,CONTEST,CERTIFICATION,SESSION}
    public SimpleDateFormat  sdfDateTime= new SimpleDateFormat("MM-dd-yyyy hh:mm:ss");
    public SimpleDateFormat  sdfDate= new SimpleDateFormat("MM-dd-yyyy");

    private String event;
    private String description;
    private String time;
    private String location;
    private EventCategory category;
    private Calendar eventDateTime;
    private String eventDateString = "";

    public AitpEvent(String aEvent, String aDescription, String aTime, String aLocation, EventCategory aCategory, Calendar aEventDateTime) {
        super();

        this.category  = aCategory;
        this.event = aEvent;
        this.description = aDescription;
        this.time = aTime;
        this.location = aLocation;

        eventDateTime = aEventDateTime;




    }
    public String getDate() {

        eventDateString = sdfDate.format(this.eventDateTime.getTime());
        return eventDateString;
    }

    public EventCategory getCategory() {
        return category;
    }
    public String getLocation() {
        return location;
    }
    public String getEvent() {
        return event;
    }

    public String getTime() {
        return time;
    }
    public String getDescription() {
        return description;
    }


    public void setEvent(String eventText) {
        this.event = eventText;
    }

    public void setTime(String timeText) {
        this.time = timeText;
    }


    public void setDescription(String descriptionText) {
        description = descriptionText;
    }

    public void setLocation(String locationText) {
        location = locationText;
    }
    public void setCategory(EventCategory categoryText) {
        category = categoryText;
    }


}