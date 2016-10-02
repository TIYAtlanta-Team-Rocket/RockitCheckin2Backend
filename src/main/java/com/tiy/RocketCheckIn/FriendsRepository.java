package com.tiy.RocketCheckIn;

/**
 * Created by Yehia830 on 9/29/16.
 */
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface FriendsRepository extends CrudRepository<Friends,Integer> {
    ArrayList<Friends> findByUser(User thisUser);
}
