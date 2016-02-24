package com.mstc.student.aitpschedule;

import android.util.EventLogTags;

public class AitpEvent {
    public  enum EventCategory{ GENERAL,FOOD,CONTEST,CERTIFICATION,SESSION}
    public AitpEvent(String event, String description, String time, String location, EventCategory category) {
        super();

        this.category  = category;
        this.event = event;
        this.description = description;
        this.time = time;
        this.location = location;

    }
    private String event;
    private String description;
    private String time;
    private String location;
    private EventCategory category;

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