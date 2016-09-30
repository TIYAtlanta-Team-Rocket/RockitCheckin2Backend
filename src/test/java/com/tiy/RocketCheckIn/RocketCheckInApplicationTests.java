package com.tiy.RocketCheckIn;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketCheckInApplicationTests {

	@Autowired
	UserRepository userRepository;

	@Test
	public void contextLoads() {

	}

	@Test
	public void registerTest(){
		String testEmail = "Testemail";
		String testPassword = "TestPass";
		String testFirstName = "TestName";
		String testLastName = "TestLast";
		String testTechSkills = "TestTechSkills";
		Boolean isAdmin = false;

		User testUser = new User(testFirstName,testLastName,testPassword,testEmail,testTechSkills,isAdmin);
		userRepository.save(testUser);
		User retrievedUser = userRepository.findOne(testUser.getId());
		assertNotNull(retrievedUser);

		userRepository.delete(testUser);
		retrievedUser = userRepository.findOne(testUser.getId());
		assertNull(retrievedUser);

	}
	@Test
	public void eventisAdded(){
		//Testing if we can add Event

	}
	@Test
	public void loginTest(){
		//Testing if we can find user that already exists

	}
	@Test
	public void findListOfEventSByAttendee(){
		//Testing if we can find all the events that a user is checked in with
	}
	@Test
	public void findListOfUserbyEvent(){
		//Testing if we can find all the users that are checked in for one event
	}
	@Test
	public void addUserAssociatedToEventToUserEventTable(){
		//Testing if we can add and a new user and event to the  userevent table
	}





}
