package com.jorgetchira.celebrity.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jorgetchira.celebrity.dao.IPersonDAO;
import com.jorgetchira.celebrity.entity.Person;

/**
 * @author Jorge Tchira
 * 
 *         Business Service implementation
 *
 */
@Component
public class CelebrityService implements ICelebrityService {

	public final static String NO_CELEBRITY = "NONE OF THE GUESTS IS A CELEBRITY";

	/**
	 * Person DAO implementation reference
	 */
	@Autowired
	public IPersonDAO personDAO;

	/**
	 * Business service to find a celebrity
	 * 
	 * @return the celebrity
	 */
	public String findCelebrity() {
		List<Person> guests = getPersons();

		return compareAll(guests);
	}

	/**
	 * Business method to compare all guest
	 * 
	 * @return the celebrity
	 */
	public String compareAll(List<Person> guests) {
		List<Person> originalGuest = new ArrayList<Person>();
		originalGuest.addAll(guests);
		for (int cont = 0; cont + 1 < guests.size(); cont++) {

			if (!guests.get(cont).knowPerson(guests.get(cont + 1))) {
				guests.set(cont + 1, guests.get(cont));
			}
		}

		Person celebrity = guests.get(guests.size() - 1);

		return verifyCelebrity(celebrity, originalGuest) ? celebrity.getName() : NO_CELEBRITY;
	}

	/**
	 * Get the guests
	 * 
	 * @return List<Person> guests
	 */
	public List<Person> getPersons() {
		return personDAO.getAll();
	}

	/**
	 * Method that verifies if a person is a celebrity
	 * 
	 * @return true if the person is a celebrity, false otherwise
	 */
	public boolean verifyCelebrity(Person person, List<Person> guest) {
		boolean response = true;
		if (!person.getAcquaintancies().isEmpty()) {
			response = false;
		} else {
			for (Person personToAsk : guest) {
				if (!personToAsk.getName().equals(person.getName())) {
					if (!personToAsk.knowPerson(person)) {
						response = false;
					}
				}
			}
		}

		return response;
	}

}
