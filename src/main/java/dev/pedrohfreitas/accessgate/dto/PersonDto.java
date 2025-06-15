package dev.pedrohfreitas.accessgate.dto;

import java.util.Date;

import dev.pedrohfreitas.accessgate.enums.PersonTypeEnum;
import dev.pedrohfreitas.accessgate.enums.StatusCodeEnum;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonDto {

	private Long id;

	@NotNull
	private String fullName;

	private String aliasName;
	
	private String identityDocument;

	private Date dateOfBirth;

	private Integer gender;

	private PersonTypeEnum personType;

	private StatusCodeEnum status;

}
