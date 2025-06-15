package dev.pedrohfreitas.accessgate.model;

import dev.pedrohfreitas.accessgate.enums.HttpTypeRequestEnum;
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
public class DeviceAccessRestCommander {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "device_acess_id")
	private DeviceAccess deviceAccess;
	
	@Column(length = 30, nullable = false)
	private String name;
	
	@Column(nullable = false)
	@Enumerated(EnumType.STRING)
	private HttpTypeRequestEnum requestMethod;
	
	@Column(name = "request_path",length = 300, nullable = false)
	private String requestPath;
	
	@Column(name = "header_body",length = 300)
	private String headerBody;
	
	@Column(name = "request_body",length = 500)
	private String requestBody;
	
}
