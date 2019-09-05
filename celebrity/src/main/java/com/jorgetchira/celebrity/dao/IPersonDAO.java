package com.jorgetchira.celebrity.dao;

import java.util.List;

import com.jorgetchira.celebrity.entity.Person;

/**
 * @author Jorge Tchira
 * 
 * Data Access Object for person entity
 *
 */
public interface IPersonDAO {
	
	/**
	 * Get the guests
	 * 
	 * @return List<Person> guests
	 */
	List<Person> getAll();

}
