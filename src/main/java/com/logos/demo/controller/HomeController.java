package com.logos.demo.controller;

import java.lang.invoke.MethodHandles;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.logos.demo.model.Person;
import com.logos.demo.service.PersonService;


@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(MethodHandles.lookup().lookupClass());

	@Inject
	private PersonService personService;
	
	@RequestMapping(value = { "/", "/home" }, method = RequestMethod.GET)
	public String home(Model model, HttpServletRequest request) {

		String s = "";
		return "home";
	}
	
	@RequestMapping(value = {  "/registration" }, method = RequestMethod.GET)
	public String registration(Model model, HttpServletRequest request) {

		String s = "";
		return "registration";
	}
	
	@RequestMapping(value = "registration/save", method = RequestMethod.POST)
	public String save(@RequestParam String name, String email, String password) {
		
		personService.save(new Person(name,email,password));
		return "redirect:/home";
	}
	
}
