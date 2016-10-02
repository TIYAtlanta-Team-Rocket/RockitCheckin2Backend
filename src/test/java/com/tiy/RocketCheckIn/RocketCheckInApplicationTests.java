package com.tiy.RocketCheckIn;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@SpringBootTest
public class RocketCheckInApplicationTests {
	JSONController controller = new JSONController();

	@Autowired
	UserRepository userRepository;

	@Autowired
	EventsRepository eventsRepository;

	@Autowired
	UserEventRepository userEventRepository;

	@Test
	public void contextLoads() {

	}

	@Test
	public void registerTest(){
		String testEmail = "Testemail3";
		String testPassword = "TestPass";
		String testFirstName = "TestName";
		String testLastName = "TestLast";
		String testTechSkills = "TestTechSkills";
		boolean isAdmin = true;

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
		String testEmail = "Testemail6";
		String testPassword = "TestPass";
		String testFirstName = "TestName";
		String testLastName = "TestLast";
		String testTechSkills = "TestTechSkills";
		boolean isAdmin = false;
		User testUser = new User(testFirstName,testLastName,testPassword,testEmail,testTechSkills,isAdmin);

		userRepository.save(testUser);
		User retrievedUser = userRepository.findByEmailAndPassword(testEmail,testPassword);
		assertNotNull(retrievedUser);

		userRepository.delete(testUser);
		retrievedUser = userRepository.findOne(testUser.getId());
		assertNull(retrievedUser);

	}

	@Test
	public void findEventsbyUser(){
		String eventName = "testEvent";
		String eventLocation = "the house";
		String eventTime = "all day";
		String eventDescription = "this is an event";
		Events testingEvent = new Events(eventName,eventLocation,eventTime,eventDescription);

		String testEmail = "Testemail3";
		String testPassword = "TestPass";
		String testFirstName = "TestName";
		String testLastName = "TestLast";
		String testTechSkills = "TestTechSkills";
		boolean isAdmin = false;
		User testUser = new User(testFirstName,testLastName,testPassword,testEmail,testTechSkills,isAdmin);

		userRepository.save(testUser);
		eventsRepository.save(testingEvent);



		UserEvent userEvent = new UserEvent(testUser,testingEvent);

		userEventRepository.save(userEvent);

		Iterable<UserEvent> eventsFound = userEventRepository.findByUser(testUser);


		ArrayList<UserEvent> eventList = new ArrayList<UserEvent>();
		for (UserEvent currentEvent : eventsFound) {
			eventList.add(currentEvent);
		}

		UserEvent thisEvent = userEventRepository.findOne(testingEvent.eventid);


		assertEquals(testUser.email, eventList.get(0).user.email);

		userEventRepository.delete(userEvent);
		eventsRepository.delete(testingEvent);
		userRepository.delete(testUser);
	}
	@Test
	public void findUsersbyEvents(){
		String eventName = "testEvent";
		String eventLocation = "the house";
		String eventTime = "all day";
		String eventDescription = "this is an event";
		Events testingEvent = new Events(eventName,eventLocation,eventTime,eventDescription);

		String testEmail = "Testemail4";
		String testPassword = "TestPass";
		String testFirstName = "TestName";
		String testLastName = "TestLast";
		String testTechSkills = "TestTechSkills";
		boolean isAdmin = false;
		User testUser = new User(testFirstName,testLastName,testPassword,testEmail,testTechSkills,isAdmin);

		userRepository.save(testUser);
		eventsRepository.save(testingEvent);



		UserEvent userEvent = new UserEvent(testUser,testingEvent);

		userEventRepository.save(userEvent);

		Iterable<UserEvent> eventsFound = userEventRepository.findByEvents(testingEvent);


		ArrayList<UserEvent> eventList = new ArrayList<UserEvent>();
		for (UserEvent currentEvent : eventsFound) {
			eventList.add(currentEvent);
		}

		UserEvent thisEvent = userEventRepository.findOne(testingEvent.eventid);


		assertEquals(testUser.email, eventList.get(0).user.email);

		userEventRepository.delete(userEvent);
		eventsRepository.delete(testingEvent);
		userRepository.delete(testUser);

	}






}
