package dev.pedrohfreitas.accessgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pedrohfreitas.accessgate.model.AccessCard;

public interface AccessCardRepository extends JpaRepository<AccessCard, Long> {

}
