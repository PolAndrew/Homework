package com.logos.demo.service.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.logos.demo.dao.PersonDao;
import com.logos.demo.model.Person;
import com.logos.demo.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Inject
	private PersonDao personDao;

	@Secured(value = "ROLE_USER")
	public List<Person> getAll() {
		return personDao.findAll();
	}

	@Override
	public void save(Person person) {
		personDao.save(person);
	}

	@Override
	public Person findbyID(long id) {
		
		return personDao.findById(id);
	}

	@Override
	public Person findByName(String name) {
		// TODO Auto-generated method stub
		return personDao.findByName(name);
	}

	

}
