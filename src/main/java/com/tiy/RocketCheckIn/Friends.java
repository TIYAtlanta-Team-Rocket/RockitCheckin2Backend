package com.tiy.RocketCheckIn;

import javax.persistence.*;
@Entity
@Table(name = "friends")
public class Friends {

    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    User user;

    @ManyToOne
    User userfriend;

    @Column
    boolean hasBeenAdded;



}
