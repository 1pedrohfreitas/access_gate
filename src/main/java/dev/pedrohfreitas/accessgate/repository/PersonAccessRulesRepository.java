package dev.pedrohfreitas.accessgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pedrohfreitas.accessgate.model.PersonAccessRules;

public interface PersonAccessRulesRepository extends JpaRepository<PersonAccessRules, Long> {

}
