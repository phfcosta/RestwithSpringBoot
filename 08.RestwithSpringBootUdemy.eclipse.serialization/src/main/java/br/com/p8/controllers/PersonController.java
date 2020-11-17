package br.com.p8.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.p8.data.vo.PersonVO;
import br.com.p8.services.PersonServices;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices personServices;
	
	
	
	@GetMapping
	public List<PersonVO> findAll() throws Exception {

		return personServices.findAll();
		
	}
	
	@GetMapping("/{id}")
	public PersonVO findById(@PathVariable(value="id") Long id) throws Exception {

		return personServices.findById(id);
		
	}
	
	@PostMapping
	public PersonVO create(@RequestBody PersonVO person) throws Exception {

		return personServices.create(person);
		
	}
	
	@PutMapping
	public PersonVO update(@RequestBody PersonVO person) throws Exception {

		return personServices.update(person);
		
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value="id") Long id) throws Exception {

		personServices.delete(id);
		
	}
	
	
}
