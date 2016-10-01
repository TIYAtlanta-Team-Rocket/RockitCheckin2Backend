package com.tiy.RocketCheckIn;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "events")
public class Events {
    @Id
    @GeneratedValue
    int eventid;

    @Column(nullable = false)
    String eventName;

    @Column(nullable = false)
    String location;

    @Column(nullable = false)
    String time;

    @Column(nullable = false)
    String description;

    public Events() {
    }

    public Events(String eventName, String location, String time, String description) {
        this.eventName = eventName;
        this.location = location;
        this.time = time;
        this.description = description;
    }

    public int getEventid() {
        return eventid;
    }

    public void setEventid(int eventid) {
        this.eventid = eventid;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
