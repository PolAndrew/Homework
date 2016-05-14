package com.logos.demo.service;

import java.util.List;

import com.logos.demo.model.Person;

public interface PersonService {
	
	List<Person> getAll();
	
	void save(Person person);
	
	Person findbyID(long id);
	
    Person findByName(String name);
}
