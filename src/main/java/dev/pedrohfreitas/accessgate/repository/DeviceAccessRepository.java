package dev.pedrohfreitas.accessgate.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.pedrohfreitas.accessgate.model.DeviceAccess;

public interface DeviceAccessRepository extends JpaRepository<DeviceAccess, Long> {

}
