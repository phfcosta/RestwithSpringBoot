package br.com.p8.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.p8.exception.ResourceNotFoundException;
import br.com.p8.model.Person;
import br.com.p8.request.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {

		return repository.save(person);

	}
	
	public List<Person> findAll() {
		
		return repository.findAll();

	}
	
	public Person findById(long id) {
		
		return repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
	}
	
	public Person update(Person person) {

		Person entity = repository.findById(person.getId())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		return repository.save(entity);

	}
	
	public void delete(long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		repository.delete(entity);

	}


	

	


}
