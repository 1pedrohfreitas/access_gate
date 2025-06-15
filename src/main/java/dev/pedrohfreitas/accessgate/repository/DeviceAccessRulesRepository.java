package dev.pedrohfreitas.accessgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pedrohfreitas.accessgate.model.DeviceAccessRules;

public interface DeviceAccessRulesRepository extends JpaRepository<DeviceAccessRules, Long> {

}
