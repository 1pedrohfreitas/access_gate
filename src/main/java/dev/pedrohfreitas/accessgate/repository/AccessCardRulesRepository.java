package dev.pedrohfreitas.accessgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pedrohfreitas.accessgate.model.AccessCardRules;

public interface AccessCardRulesRepository extends JpaRepository<AccessCardRules, Long> {

}
