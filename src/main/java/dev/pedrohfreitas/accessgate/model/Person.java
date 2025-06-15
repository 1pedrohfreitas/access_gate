package dev.pedrohfreitas.accessgate.model;

import java.util.Date;
import java.util.Set;

import dev.pedrohfreitas.accessgate.enums.PersonTypeEnum;
import dev.pedrohfreitas.accessgate.enums.StatusCodeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Person {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 100, nullable = false)
	private String fullName;

	@Column(length = 100)
	private String aliasName;
	
	@Column(length = 100)
	private String identityDocument;

	private Date dateOfBirth;

	@Builder.Default
	@Column(nullable = false)
	private Integer gender = 0;

	@Enumerated(value = EnumType.STRING)
	private PersonTypeEnum personType;

	@Enumerated(value = EnumType.STRING)
	private StatusCodeEnum status;

	@OneToMany(mappedBy = "person")
	private Set<AccessCard> accessCards;

	@OneToMany(mappedBy = "person")
	private Set<PersonAccessRules> accessRules;

}