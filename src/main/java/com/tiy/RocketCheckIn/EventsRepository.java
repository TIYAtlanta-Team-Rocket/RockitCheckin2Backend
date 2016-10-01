package com.tiy.RocketCheckIn;

/**
 * Created by Yehia830 on 9/29/16.
 */
import org.springframework.data.repository.CrudRepository;
public interface EventsRepository extends CrudRepository<Events,Integer>  {
    Events findByEventName(String eventName);
}
