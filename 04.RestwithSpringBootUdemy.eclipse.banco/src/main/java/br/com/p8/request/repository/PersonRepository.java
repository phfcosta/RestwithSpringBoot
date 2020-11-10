package br.com.p8.request.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.p8.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

}
