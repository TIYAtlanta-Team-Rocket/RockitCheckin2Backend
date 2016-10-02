package com.tiy.RocketCheckIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpSession;
import java.util.ArrayList;

/**
 * Created by Yehia830 on 9/30/16.
 */


@RestController
public class JSONController {
    @Autowired
    UserEventRepository userEvents;

    @Autowired
    UserRepository users;

    @Autowired
    FriendsRepository friends;

    @Autowired
    EventsRepository events;

    @RequestMapping(path="/login.json", method = RequestMethod.POST)
    public LoginContainer login(@RequestBody User existUser){
        User returnUser;

        String password = existUser.password;
        String email = existUser.email;

        LoginContainer payload;
        String error = null;
        returnUser = users.findByEmailAndPassword(email,password);
        if (returnUser == null){
            error = "Password or email are incorrect please try again.";
            payload = new LoginContainer(error, returnUser);
            return payload;
        }

        payload = new LoginContainer(error, returnUser);
        return payload;
    }
    
    @RequestMapping(path="/register.json", method = RequestMethod.POST)
    public LoginContainer register(@RequestBody User newUser){
        System.out.println("fname: " + newUser.firstName + " lname: " + newUser.lastName + " email: " + newUser.email
                + " password: " + newUser.password + " adminFlag: " + newUser.adminFlag);
        User noUser = new User();
        noUser = null;
        LoginContainer loginContainer;
        if(newUser == null){
            loginContainer = new LoginContainer("User Not Created",noUser);
            System.out.println("error sent with null user");
        }else{
            users.save(newUser);
            loginContainer = new LoginContainer(null ,newUser);
            System.out.println("null error sent with existing user");
        }


        return loginContainer;
    }

    @RequestMapping(path="/addEvent.jason", method = RequestMethod.POST)
    public ArrayList<Events> addEvent(HttpSession session, @RequestBody Events newEvent){
        System.out.println("eventName: " + newEvent.eventName + " description: " + newEvent.description + " location: " + newEvent.location + " time: " + newEvent.time);
        events.save(newEvent);
        ArrayList<Events> eventsArrayList = new ArrayList<>();
        Iterable<Events> eventsAll = events.findAll();
        for(Events thisEvent: eventsAll){
            eventsArrayList.add(thisEvent);
        }

        return eventsArrayList;
    }

    @RequestMapping(path="/events.json", method = RequestMethod.POST)
    public ArrayList<Events> getEvents(HttpSession session){
       ArrayList<Events> eventsArrayList = new ArrayList<>();
        Iterable<Events> eventsAll = events.findAll();
        for(Events thisEvent: eventsAll){
            eventsArrayList.add(thisEvent);
        }

        return eventsArrayList;
    }
    @RequestMapping(path="/attendees.json", method = RequestMethod.POST)
    public ArrayList<User> attendess(@RequestBody Events events){
        ArrayList<User> userArrayList = new ArrayList<>();
        Iterable<UserEvent> userAll = userEvents.findByEvents(events);
        for(UserEvent userEvent : userAll){
            userArrayList.add(userEvent.user);
        }

        return userArrayList;
    }
    @RequestMapping(path="/checkin.json", method = RequestMethod.POST)
    public Boolean checkin(@RequestBody UserEvent userEvent){
        Boolean ischeckedin = true;
        userEvents.save(userEvent);


        return ischeckedin;
    }
    @RequestMapping(path="/checkedinevents.json", method = RequestMethod.POST)
    public ArrayList<Events> checkedInEvents(@RequestBody User user){
        ArrayList<Events> eventsByUser = new ArrayList<>();
        Iterable<UserEvent> eventsIterable = userEvents.findByUser(user);
        for(UserEvent userEvent: eventsIterable){
            eventsByUser.add(userEvent.events);
        }
        return eventsByUser;
    }
//    @RequestMapping(path="/getuser.json", method = RequestMethod.POST)
//    public User getUser(HttpSession session){
//        User getUser = new User();
//
//        return getUser;
//    }

}
