package dev.pedrohfreitas.accessgate.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import dev.pedrohfreitas.accessgate.dto.PersonDto;
import dev.pedrohfreitas.accessgate.model.Person;
import dev.pedrohfreitas.accessgate.record.PersonRecord;
import dev.pedrohfreitas.accessgate.repository.PersonRepository;

@Service
public class PersonService {

	private final PersonRepository personRepository;

	private final ModelMapper modelMapper;

	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
		this.modelMapper = new ModelMapper();
	}

	public PersonRecord save(PersonDto personDto) {
		Person person = modelMapper.map(personDto, Person.class);
		return mapperModelToRecord(personRepository.save(person));
	}

	public Page<PersonRecord> findAll(Pageable pageable) {
		Page<Person> findResult = personRepository.findAll(pageable);
		List<PersonRecord> list = findResult.getContent().stream().map(item -> {
			return mapperModelToRecord(personRepository.save(item));
		}).toList();
		return new PageImpl<PersonRecord>(list, pageable, findResult.getTotalElements());
	}
	public Page<PersonRecord> findAllByExample(PersonDto body, Pageable pageable) {
		ExampleMatcher matcher = ExampleMatcher.matchingAll().withIgnoreCase()
				.withStringMatcher(ExampleMatcher.StringMatcher.EXACT);
		Example<Person> example = Example.of(modelMapper.map(body, Person.class), matcher);
		
		Page<Person> findResult = personRepository.findAll(example,pageable);
		List<PersonRecord> list = findResult.getContent().stream().map(item -> {
			return mapperModelToRecord(personRepository.save(item));
		}).toList();
		return new PageImpl<PersonRecord>(list, pageable, findResult.getTotalElements());
	}

	public PersonRecord getById(Long id) {
		Person person = personRepository.findById(id).orElseThrow();
		return mapperModelToRecord(personRepository.save(person));
	}

	public void deleteById(Long id) {
		personRepository.deleteById(id);
	}
	
	private PersonRecord mapperModelToRecord(Person person) {
		return new PersonRecord(person.getId(), person.getFullName(), person.getAliasName(),
				person.getIdentityDocument(), person.getDateOfBirth(), person.getGender(), person.getPersonType(),
				person.getStatus());
	}

}
