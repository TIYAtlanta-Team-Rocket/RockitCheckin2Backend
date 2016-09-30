package com.tiy.RocketCheckIn;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yehia830 on 9/30/16.
 */
@RestController
public class JSONController {
    @RequestMapping(path="/login", method = RequestMethod.POST)
    public User login(HttpSession session){
       User user = new User();

        return user;
    }
    @RequestMapping(path="/register", method = RequestMethod.POST)
    public User register(HttpSession session){
        User user = new User();

        return user;
    }
    @RequestMapping(path="/events", method = RequestMethod.POST)
    public ArrayList<Events> getEvents(HttpSession session){
       ArrayList<Events> eventsArrayList = new ArrayList<>();

        return eventsArrayList;
    }
    @RequestMapping(path="/attendees", method = RequestMethod.POST)
    public ArrayList<User> attendess(HttpSession session){
        ArrayList<User> userArrayList = new ArrayList<>();

        return userArrayList;
    }
    @RequestMapping(path="/checkin", method = RequestMethod.POST)
    public Boolean checkin(HttpSession session){
        Boolean ischeckedin = true;

        return ischeckedin;
    }
    @RequestMapping(path="/getuser", method = RequestMethod.POST)
    public User getUser(HttpSession session){
        User getUser = new User();

        return getUser;
    }

}
