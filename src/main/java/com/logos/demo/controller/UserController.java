package com.logos.demo.controller;

import java.security.Principal;

import javax.inject.Inject;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.logos.demo.model.Person;
import com.logos.demo.service.PersonService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Inject
	private PersonService personService;

	@RequestMapping(method = RequestMethod.GET)
	public String getAll(Model model, HttpServletRequest request) {

		model.addAttribute("context", request.getContextPath());
		model.addAttribute("personList", personService.getAll());
		
		return "users";
	}
	
	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String save(@RequestParam String name) {
		personService.save(new Person(name));
		return "redirect:/users";
	}
	
	@RequestMapping(value = "/mypage")
	public String open(Model model, Principal principal) {
	
		model.addAttribute("person", personService.findbyID(Long.parseLong(principal.getName())));
		
		return "mypage";
	}
	
	@RequestMapping(value = "/{id}")
	public String findById(Model model, @PathVariable long id){
		model.addAttribute("person", personService.findbyID(id));
		return "mypage";
	}
	@RequestMapping(value = "/name/{name}")
	public String findByname(Model model, @PathVariable String name ){
		model.addAttribute("person", personService.findByName(name));
		return "mypage";
	}

}
