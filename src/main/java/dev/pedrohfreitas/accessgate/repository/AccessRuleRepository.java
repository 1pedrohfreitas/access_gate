package dev.pedrohfreitas.accessgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pedrohfreitas.accessgate.model.AccessRule;

public interface AccessRuleRepository extends JpaRepository<AccessRule, Long> {

}
