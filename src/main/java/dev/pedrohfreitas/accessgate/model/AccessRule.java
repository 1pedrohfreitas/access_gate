package dev.pedrohfreitas.accessgate.model;

import java.util.Set;

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
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccessRule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 30, nullable = false)
	private String name;

	@OneToMany(mappedBy = "accessRule")
	private Set<AccessCardRules> accessCards;
	
	@OneToMany(mappedBy = "accessRule")
	private Set<DeviceAccessRules> devices;
	
	@OneToMany(mappedBy = "accessRule")
	private Set<PersonAccessRules> people;
	
	@Builder.Default
	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private StatusCodeEnum status = StatusCodeEnum.INACTIVE;

}
