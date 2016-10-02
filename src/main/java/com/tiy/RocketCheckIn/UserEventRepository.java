package com.tiy.RocketCheckIn;

/**
 * Created by Yehia830 on 9/29/16.
 */
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface UserEventRepository extends CrudRepository<UserEvent,Integer> {
    ArrayList<UserEvent> findByUser(User user);
    ArrayList<UserEvent> findByEvents(Events events);
//    ArrayList<UserEvent> findUsersByEvent(Events event);

}
