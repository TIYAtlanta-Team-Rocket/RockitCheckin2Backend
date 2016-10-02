package com.tiy.RocketCheckIn;


import javax.persistence.*;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue
    int id;

    @ManyToOne
    Events userEvents;

    @Column(nullable = true)
    String firstName;

    @Column(nullable = true)
    String lastName;

    @Column(nullable = false)
    String password;

    @Column(nullable = false, unique = true)
    String email;

    @Column(nullable = true)
    String techSkills;

    @Column(nullable = false)
    boolean adminFlag;


    public String getTechSkills() {
        return techSkills;
    }

    public void setTechSkills(String techSkills) {
        this.techSkills = techSkills;
    }

    public Events getUserEvents() {
        return userEvents;
    }

    public void setUserEvents(Events userEvents) {
        this.userEvents = userEvents;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String firstName, String lastName, String password, String email, String techSkills, boolean adminFlag) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.techSkills = techSkills;
        this.adminFlag = adminFlag;
    }
    public User(){

    }

    public boolean isAdminFlag() {
        return adminFlag;
    }

    public void setAdminFlag(boolean adminFlag) {
        this.adminFlag = adminFlag;
    }
}
