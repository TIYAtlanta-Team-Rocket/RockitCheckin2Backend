package com.tiy.RocketCheckIn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.asm.Register;
import sun.rmi.runtime.Log;

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

    @RequestMapping(path="/login.json", method = RequestMethod.POST)
    public User login(@RequestBody User existUser){
        User returnUser;

        String password = existUser.password;
        String email = existUser.email;

        returnUser = users.findByEmailAndPassword(email,password);

        System.out.println(existUser.email);



        return returnUser;
    }
    @RequestMapping(path="/register.json", method = RequestMethod.POST)
    public LoginContainer register(@RequestBody User newUser){
        users.save(newUser);
        User sentUser = new User();
        User noUser = new User();
        noUser = null;
        LoginContainer loginContainer;
        if(sentUser == null){
            loginContainer = new LoginContainer("User Not Created",noUser);
        }else{
            loginContainer = new LoginContainer(null,sentUser);
        }

        return loginContainer;
    }
    @RequestMapping(path="/events.json", method = RequestMethod.POST)
    public ArrayList<Events> getEvents(HttpSession session){
       ArrayList<Events> eventsArrayList = new ArrayList<>();

        return eventsArrayList;
    }
    @RequestMapping(path="/attendees.json", method = RequestMethod.POST)
    public ArrayList<User> attendess(HttpSession session){
        ArrayList<User> userArrayList = new ArrayList<>();

        return userArrayList;
    }
    @RequestMapping(path="/checkin.json", method = RequestMethod.POST)
    public Boolean checkin(HttpSession session){
        Boolean ischeckedin = true;

        return ischeckedin;
    }
    @RequestMapping(path="/getuser.json", method = RequestMethod.POST)
    public User getUser(HttpSession session){
        User getUser = new User();

        return getUser;
    }

}
