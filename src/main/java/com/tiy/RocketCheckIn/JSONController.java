package com.tiy.RocketCheckIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
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
    @Autowired
    UserEventRepository userEvents;

    @Autowired
    UserRepository users;

    @Autowired
    FriendsRepository friends;

    @Autowired
    EventsRepository events;

    @RequestMapping(path = "/addTestData.json", method = RequestMethod.GET)
    public void addTestData(){
        User user1 = new User("jill", "stein", "password1", "email1", "techskills info", false);
        User user2 = new User("bobby", "marley", "password2", "email2", "techskills info", false);
        User user3 = new User("john", "denver", "password3", "email3", "techskills info", false);
        users.save(user1);
        users.save(user2);
        users.save(user3);
        Events events1 = new Events("event1", "nowheresville", "a day", "this is event 1");
        Events events2 = new Events("event2", "nowheresville", "a day", "this is event 2");
        Events events3 = new Events("event3", "nowheresville", "a day", "this is event 3");
        events.save(events1);
        events.save(events2);
        events.save(events3);
        User placeHolderUser = users.findByEmailAndPassword("email1", "password1");
        Events placeHolderEvent = events.findByEventName("event1");
        UserEvent placeHolderUserEvent = new UserEvent(placeHolderUser, placeHolderEvent);
        userEvents.save(placeHolderUserEvent);
        placeHolderUser = users.findByEmailAndPassword("email2", "password2");
        placeHolderEvent = events.findByEventName("event2");
        placeHolderUserEvent = new UserEvent(placeHolderUser, placeHolderEvent);
        userEvents.save(placeHolderUserEvent);
        placeHolderUser = users.findByEmailAndPassword("email3", "password3");
        placeHolderEvent = events.findByEventName("event3");
        placeHolderUserEvent = new UserEvent(placeHolderUser, placeHolderEvent);
        userEvents.save(placeHolderUserEvent);

        placeHolderUser = users.findByEmailAndPassword("email1", "password1");
        placeHolderEvent = events.findByEventName("event2");
        placeHolderUserEvent = new UserEvent(placeHolderUser, placeHolderEvent);
        userEvents.save(placeHolderUserEvent);

        placeHolderUser = users.findByEmailAndPassword("email2", "password2");
        placeHolderEvent = events.findByEventName("event1");
        placeHolderUserEvent = new UserEvent(placeHolderUser, placeHolderEvent);
        userEvents.save(placeHolderUserEvent);

    }

    @RequestMapping(path="/login.json", method = RequestMethod.POST)
    public User login(@RequestBody User existUser){
        User returnUser;

        String password = existUser.password;
        String email = existUser.email;

        returnUser = users.findByEmailAndPassword(email,password);
        System.out.println(returnUser.password);

        System.out.println(existUser.email);
        System.out.println(existUser.password);



        return returnUser;
    }
    @RequestMapping(path="/register.json", method = RequestMethod.POST)
    public boolean register(@RequestBody User newUser){
        newUser.isAdmin = false;
        users.save(newUser);
        System.out.println("fname: " + newUser.firstName + " lname: " + newUser.lastName + " email: " + newUser.email + " password: " + newUser.password);
        System.out.println("STOPPP ITTTT");
//        User sentUser = new User();
//        User noUser = new User();
//        noUser = null;
//        LoginContainer loginContainer;
//        if(sentUser == null){
//            loginContainer = new LoginContainer("User Not Created",noUser);
//        }else{
//            loginContainer = new LoginContainer(null,sentUser);
//        }


        return true;
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
