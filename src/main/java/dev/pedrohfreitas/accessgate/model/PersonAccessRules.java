package dev.pedrohfreitas.accessgate.model;

import java.time.LocalDateTime;

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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PersonAccessRules {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
	private Person person;
    
    @ManyToOne
    @JoinColumn(name = "access_rule_id")
	private AccessRule accessRule;
	
    @Column(name = "start_validity", nullable = false)
	private LocalDateTime startValidity;
	
    @Column(name = "end_validity")
	private LocalDateTime endValidity;
	
	@Builder.Default
	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private StatusCodeEnum status = StatusCodeEnum.INACTIVE;

}
