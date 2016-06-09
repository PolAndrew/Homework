package com.logos.demo.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logos.demo.dao.PersonDao;
import com.logos.demo.model.Person;
import com.logos.demo.model.Role;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Inject
	private PersonDao personDao;

	@Transactional
	public UserDetails loadUserByUsername(String email) {

		Person person = personDao.findByEmail(email);

		if (person == null)
			throw new UsernameNotFoundException("Error in email");

		Collection<SimpleGrantedAuthority> authorities= new ArrayList<>();
		/*for (Role role : person.getListrole()) {
			authorities.add(new SimpleGrantedAuthority(role.getRole()));
		}*/
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		return new User(person.getId().toString(), person.getPassword(), authorities);
	}

}