package com.jorgetchira.celebrity.entity;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jorge Tchira
 * 
 * Unit test for Person Class 
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTest {
	
	public static final String PERSON_NAME_1 = "Alex";
	public static final String PERSON_NAME_2 = "Diego";
	public static final String PERSON_NAME_3 = "Carlos";
	
	/**
	 * Verify that a person known another person
	 */
	@Test
	public void personKnowPerson() {
		Person person = new Person("PERSON_NAME_1");
		Map<String, Person> acquaintances = new HashMap<String, Person>();
		acquaintances.put(PERSON_NAME_2, new Person(PERSON_NAME_2));
		person.setAcquaintancies(acquaintances);
		assertTrue(person.knowPerson(new Person(PERSON_NAME_2)));  
	}
	
	/**
	 * Verify that a person dont known another person
	 */
	@Test
	public void personDontKnowPerson() {
		Person person = new Person("PERSON_NAME_1");
		Map<String, Person> acquaintances = new HashMap<String, Person>();
		acquaintances.put(PERSON_NAME_2, new Person(PERSON_NAME_2));
		person.setAcquaintancies(acquaintances);
		assertFalse(person.knowPerson(new Person(PERSON_NAME_3)));  
	}
	


}
