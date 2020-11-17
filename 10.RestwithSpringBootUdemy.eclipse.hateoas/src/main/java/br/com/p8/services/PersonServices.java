package br.com.p8.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.p8.converter.DozerConverter;
import br.com.p8.data.model.Person;
import br.com.p8.data.vo.PersonVO;
import br.com.p8.exception.ResourceNotFoundException;
import br.com.p8.request.repository.PersonRepository;

@Service
public class PersonServices {

	@Autowired
	PersonRepository repository;
	
	public PersonVO create(PersonVO person) {
		
		var entity = DozerConverter.parseObject(person, Person.class);
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);

		return vo;

	}
	
	public List<PersonVO> findAll() {
		
		return DozerConverter.parseListObjects(repository.findAll(), PersonVO.class);

	}
	
	public PersonVO findById(long id) {
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		return DozerConverter.parseObject(entity, PersonVO.class);
	}
	
	public PersonVO update(PersonVO person) {

		var entity = repository.findById(person.getKey())
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));

		entity.setFirstName(person.getFirstName());
		entity.setLastName(person.getLastName());
		entity.setAddress(person.getAddress());
		entity.setGender(person.getGender());
		var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
		return vo;
	}
	
	public void delete(long id) {
		Person entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No records found for this Id"));
		repository.delete(entity);

	}


	

	


}
