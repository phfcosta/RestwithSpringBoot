package br.com.p8.controllers;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.p8.data.vo.PersonVO;
import br.com.p8.data.vo.Teste;
import br.com.p8.services.PersonServices;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Person Endpoint", description = "Description Person", tags = {"Person Endpoint"})
@RestController
@RequestMapping("/api/person/v1")
public class PersonController {
	
	@Autowired
	private PersonServices personServices;
	
	@Autowired
	private Teste teste;
	
	
	@ApiOperation(value = "Find all People recorded")
	@GetMapping(produces= {"application/json","application/xml","application/x-yaml"})
	public List<PersonVO> findAll() throws Exception {
		
		teste.setMessage("inject pojo");
		System.out.println(teste.toString());

		List<PersonVO> persons = personServices.findAll();
		persons
			.stream()
			.forEach(
					p -> p.add(
							linkTo(
									methodOn(PersonController.class).findById(p.getKey())).withSelfRel()));
		return persons;
	}
	
	@GetMapping(value="/{id}",produces= {"application/json","application/xml","application/x-yaml"})
	public PersonVO findById(@PathVariable(value="id") Long id)  {

		PersonVO personVO = personServices.findById(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
		
	}
	
	@PostMapping(produces= {"application/json","application/xml","application/x-yaml"},
			consumes= {"application/json", "application/xml","application/x-yaml"})
	public PersonVO create(@RequestBody PersonVO person) throws Exception {

		PersonVO personVO = personServices.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
		
	}
	
	@PutMapping(produces= {"application/json","application/xml","application/x-yaml"},
			consumes= {"application/json","application/xml","application/x-yaml"})
	public PersonVO update(@RequestBody PersonVO person) throws Exception {

		PersonVO personVO = personServices.update(person);
		personVO.add(linkTo(methodOn(PersonController.class).findById(personVO.getKey())).withSelfRel());
		return personVO;
		
	}
	
	@ApiOperation(value = "Disable a specific person by your ID")
	@PatchMapping(value="/{id}",produces= {"application/json","application/xml","application/x-yaml"})
	public PersonVO disablePerson(@PathVariable(value="id") Long id)  {

		PersonVO personVO = personServices.disablePerson(id);
		personVO.add(linkTo(methodOn(PersonController.class).findById(id)).withSelfRel());
		return personVO;
		
	}
	
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable(value="id") Long id) throws Exception {

		personServices.delete(id);
		
	}
	
	
}
