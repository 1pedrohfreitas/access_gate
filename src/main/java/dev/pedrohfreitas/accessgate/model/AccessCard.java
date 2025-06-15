package dev.pedrohfreitas.accessgate.model;

import java.util.Set;

import dev.pedrohfreitas.accessgate.enums.CardTypeEnum;
import dev.pedrohfreitas.accessgate.enums.StatusCodeEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class AccessCard {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "person_id")
	private Person person;

	@Column(length = 30, nullable = false)
	private String code;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(name = "card_type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private CardTypeEnum cardType;

	@Builder.Default
	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private StatusCodeEnum status = StatusCodeEnum.INACTIVE;

	@OneToMany(mappedBy = "accessCard")
	private Set<AccessCardRules> accessRules;
}
