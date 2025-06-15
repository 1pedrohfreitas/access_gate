package dev.pedrohfreitas.accessgate.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.pedrohfreitas.accessgate.dto.PersonDto;
import dev.pedrohfreitas.accessgate.dto.ResponseDto;
import dev.pedrohfreitas.accessgate.record.PersonRecord;
import dev.pedrohfreitas.accessgate.service.PersonService;

@RestController
@RequestMapping(name = "/person")
@CrossOrigin(origins = "*")
public class PersonController {
	
	private final PersonService personService;
	
	public PersonController(PersonService personService) {
		this.personService = personService;
	}
	
	@GetMapping(value = "getById/{id}", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseDto<PersonRecord>> getById(@PathVariable Long id){
		return new ResponseDto<PersonRecord>().getReponse(personService.getById(id), HttpStatus.OK);
	}
	
	@GetMapping(value = "findAll", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseDto<Page<PersonRecord>>> findAll(Pageable pageable){
		return new ResponseDto<Page<PersonRecord>>().getReponse(personService.findAll(pageable), HttpStatus.OK);
	}
	@PostMapping(value = "findAllByExample", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseDto<Page<PersonRecord>>> findAll(@RequestBody PersonDto body, Pageable pageable){
		return new ResponseDto<Page<PersonRecord>>().getReponse(personService.findAllByExample(body,pageable), HttpStatus.OK);
	}
	
	@PostMapping(value = "save", produces = { MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ResponseDto<PersonRecord>> save(@RequestBody PersonDto personDto){
		return new ResponseDto<PersonRecord>().getReponse(personService.save(personDto), personDto.getId() != null ? HttpStatus.OK : HttpStatus.CREATED);
	}

	@DeleteMapping(value = "deleteById/{id}")
	public ResponseEntity<ResponseDto<Void>> deleteById(@PathVariable Long id){
		personService.deleteById(id);
		return new ResponseEntity<ResponseDto<Void>>(HttpStatus.OK);
	}
}
