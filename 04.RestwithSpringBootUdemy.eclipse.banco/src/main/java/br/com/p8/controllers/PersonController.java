package br.com.p8.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.p8.model.Person;
import br.com.p8.services.PersonServices;

@RestController
@RequestMapping("/person")
public class PersonController {
	
	@Autowired
	private PersonServices personServices;
	
	
	
	@GetMapping
	public List<Person> findAll() throws Exception {

		return personServices.findAll();
		
	}
	
	@GetMapping("/{id}")
	public Person findById(@PathVariable(value="id") Long id) throws Exception {

		return personServices.findById(id);
		
	}
	
	@PostMapping
	public Person create(@RequestBody Person person) throws Exception {

		return personServices.create(person);
		
	}
	
	@PutMapping
	public Person update(@RequestBody Person person) throws Exception {

		return personServices.update(person);
		
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value="id") Long id) throws Exception {

		personServices.delete(id);
		
	}
	
	
}
