package com.tiy.RocketCheckIn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketCheckInApplicationTests {
	JSONController controller = new JSONController();

	@Autowired
	UserRepository userRepository;

	@Autowired
	EventsRepository eventsRepository;

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
		assertEquals(testEmail, retrievedUser.email);

		userRepository.delete(testUser);
		retrievedUser = userRepository.findOne(testUser.getId());
		assertNull(retrievedUser);

	}
	@Test
	public void eventisAdded(){
		String eventName = "event";
		String location = "place";
		String time = "now";
		String description = "this is a thing";

		Events testEvent = new Events(eventName, location, time, description);
		eventsRepository.save(testEvent);
		Events retrievedEvent = eventsRepository.findByEventName(eventName);
		assertEquals(location, retrievedEvent.location);

		eventsRepository.delete(testEvent);
		retrievedEvent = eventsRepository.findOne(retrievedEvent.getEventid());
		assertNull(retrievedEvent);

	}
	@Test
	public void loginTest(){
		//Testing if we can find user that already exists

//		String testEmail = "Testemail";
//		String testPassword = "TestPass";
//		String testFirstName = "TestName";
//		String testLastName = "TestLast";
//		String testTechSkills = "TestTechSkills";
//		Boolean isAdmin = false;
//
//
//		User testUser = new User(testFirstName,testLastName,testPassword,testEmail,testTechSkills,isAdmin);
//		userRepository.save(testUser);
//
//		User recievedUser = controller.login(testUser);
//		assertEquals(testUser.firstName, recievedUser.firstName);
//
//		userRepository.delete(testUser);
//		recievedUser = userRepository.findOne(testUser.getId());
//		assertNull(recievedUser);
//
//


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
