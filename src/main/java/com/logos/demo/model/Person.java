package com.logos.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@Entity
@NamedQueries({ @NamedQuery(name = Person.FIND_BY_EMAIL, query = "SELECT p FROM Person p WHERE p.email = :email") })
public class Person {

	public static final String FIND_BY_EMAIL = "Person.findByEmail";

	@Id
	@GeneratedValue
	
	private Long id;
	private String name;
	private String email;
	private String password;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="CityID")
	private City city;
	
	/*@Column(name ="Authorize")
	private boolean authorize;*/
	
	

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "person_role",  joinColumns = 
			@JoinColumn(name = "Person_id",referencedColumnName="id" ) , 
			inverseJoinColumns =  @JoinColumn(name= "Role_id",referencedColumnName="id" ) )
	private List<Role> listrole;

	public List<Role> getListrole() {
		return listrole;
	}

	public void setListrole(List<Role> listrole) {
		this.listrole = listrole;
	}

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	/*public boolean isAuthorize() {
		return authorize;
	}

	public void setAuthorize(boolean authorize) {
		this.authorize = authorize;
	}*/
}
