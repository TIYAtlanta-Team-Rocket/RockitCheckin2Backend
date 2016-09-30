package com.tiy.RocketCheckIn;

/**
 * Created by Yehia830 on 9/29/16.
 */

import javax.persistence.*;
@Entity
@Table(name = "user_event")
public class UserEvent {

    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    User users;

    @ManyToOne
    Events event;


}
