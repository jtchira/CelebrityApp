package com.jorgetchira.celebrity.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jorgetchira.celebrity.dao.datasource.JSONData;
import com.jorgetchira.celebrity.dao.datasource.JSONData.JSONPerson;
import com.jorgetchira.celebrity.dao.datasource.JSONHandler;
import com.jorgetchira.celebrity.entity.Person;

/**
 * @author Jorge Tchira
 *
 * Person DAO implementation
 */
@Component
public class PersonDAO implements IPersonDAO{
	
	/**
	 * Reference to data source JSON handler
	 */
	@Autowired
	public JSONHandler handler;
	
	/**
	 * Get the guests
	 * 
	 * @return List<Person> guests
	 */
	public List<Person> getAll(){
		
		JSONData jsonData = handler.getData();
		List<Person> people = new ArrayList<Person>();
		
		for(JSONPerson jsonPerson : jsonData.getPeople()) {
			Person person = new Person();
			person.setName(jsonPerson.getName());
			Map<String, Person> acquaintances = new HashMap<String, Person>();
			for(String name: jsonPerson.getAcquaintances()) {
				acquaintances.put(name, new Person(name));
			}
			person.setAcquaintancies(acquaintances);
			people.add(person);
		}
		
		return people;
		
	}

}
