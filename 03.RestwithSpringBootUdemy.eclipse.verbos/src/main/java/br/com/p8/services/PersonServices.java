package br.com.p8.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Service;

import br.com.p8.model.Person;

@Service
public class PersonServices {

	private final AtomicLong counter = new AtomicLong();

	public Person create(Person person) {

		return person;

	}
	
	public Person update(Person person) {

		return person;

	}
	
	public void delete(String id) {



	}


	public Person findById(String id) {
		Person person = new Person();

		person.setId(counter.incrementAndGet());
		person.setFirstName("John");
		person.setLastName("Doe");
		person.setAddress("endereço");
		person.setGender("Male");
		return person;
	}

	public List<Person> findAll() {

		List<Person> persons = new ArrayList<Person>();

		for (int i = 0; i < 7; i++) {

			Person person = mockPerson(i);
			persons.add(person);

		}
		return persons;

	}

	private Person mockPerson(int i) {
		Person person = new Person();

		person.setId(counter.incrementAndGet());
		person.setFirstName("Person Name" + i);
		person.setLastName("Last Name" + i);
		person.setAddress("endereço" + i);
		person.setGender("Male");
		return person;
	}

}
