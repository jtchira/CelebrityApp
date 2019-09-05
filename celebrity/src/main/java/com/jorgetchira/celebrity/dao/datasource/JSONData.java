package com.jorgetchira.celebrity.dao.datasource;

import java.util.List;

/**
 * @author Jorge Tchira
 * 
 * Class that represent JSON data
 *
 */
public class JSONData {

	/**
	 * @author Jorge Tchira
	 *
	 * Inner Class that represent a JSON person data
	 */
	public static class JSONPerson {

		/**
		 * Person name
		 */
		private String name;
		
		/**
		 * Person acquaintances
		 */
		private List<String> acquaintances;

		/**
		 * @return the name
		 */
		public String getName() {
			return name;
		}

		/**
		 * @param name the name to set
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * @return the acquaintances
		 */
		public List<String> getAcquaintances() {
			return acquaintances;
		}

		/**
		 * @param acquaintances the acquaintances to set
		 */
		public void setAcquaintances(List<String> acquaintances) {
			this.acquaintances = acquaintances;
		}		

	}

	/**
	 * Represents the guest
	 */
	private List<JSONPerson> people;

	/**
	 * @return the people
	 */
	public List<JSONPerson> getPeople() {
		return people;
	}

	/**
	 * @param people the people to set
	 */
	public void setPeople(List<JSONPerson> people) {
		this.people = people;
	}


	

}
