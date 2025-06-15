package dev.pedrohfreitas.accessgate.record;

import java.util.Date;

import dev.pedrohfreitas.accessgate.enums.PersonTypeEnum;
import dev.pedrohfreitas.accessgate.enums.StatusCodeEnum;

public record PersonRecord(Long id, String fullName, String aliasName, String identityDocument,
		Date dateOfBirth, Integer gender, PersonTypeEnum personType, StatusCodeEnum status) {

}
