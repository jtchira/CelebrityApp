package com.jorgetchira.celebrity.entity;

import java.util.Map;

/**
 * @author Jorge Tchira
 *
 *	This Class represent a Person
 */
public class Person {
	
		/**
		 * Person's name
		 */
		private String name;
		
		/**
		 * All person acquaintancies;
		 */
		private Map<String, Person> acquaintancies;
		
		

		/**
		 * Default Person construct
		 */
		public Person() {
			super();
			// TODO Auto-generated constructor stub
		}

		/**
		 * @param name
		 */
		public Person(String name) {
			super();
			this.name = name;
		}

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
		 * @return the acquaintancies
		 */
		public  Map<String, Person> getAcquaintancies() {
			return acquaintancies;
		}

		/**
		 * @param acquaintancies the acquaintancies to set
		 */
		public void setAcquaintancies( Map<String, Person> acquaintancies) {
			this.acquaintancies = acquaintancies;
		}
		
		/**
		 * @param xx for ask
		 * 
		 * @return a boolean (true if person is known, false otherwise)
		 */
		public boolean knowPerson(Person person) {
			return acquaintancies.get(person.name)!=null ? true:false;
		}
		
}
