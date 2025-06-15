package dev.pedrohfreitas.accessgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pedrohfreitas.accessgate.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
