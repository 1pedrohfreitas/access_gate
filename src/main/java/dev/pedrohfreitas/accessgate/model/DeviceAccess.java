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
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DeviceAccess {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(length = 30, nullable = false)
	private String name;

	@Column(name = "device_host_url", length = 300)
	private String deviceHostUrl;

	@Builder.Default
	@Column(nullable = false)
	@Enumerated(value = EnumType.STRING)
	private StatusCodeEnum status = StatusCodeEnum.INACTIVE;

	@OneToMany(mappedBy = "deviceAccess")
	Set<DeviceAccessRestCommander> deviceAccessRestCommanders;

	@OneToMany(mappedBy = "deviceAccess")
	Set<DeviceAccessRules> accessRules;

}
