package com.aula8.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.aula8.dtos.PersonDTO;
import com.aula8.model.Person;
import com.aula8.services.PersonService;
import com.aula8.util.MediaType;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/person/v1")
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    private ModelMapper modelMapper;

    @GetMapping(value = "/{id}", produces = { 
        MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML })
    public ResponseEntity<PersonDTO> findById(@PathVariable(value = "id") Long id) {
        Person person = personService.findById(id);
        if (person == null) {
            return ResponseEntity.notFound().build();
        }
        PersonDTO personDTO = modelMapper.map(person, PersonDTO.class);
        return ResponseEntity.ok(personDTO);
    }

    @GetMapping(
        produces = { 
        MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML 
    }
        )
    public List<PersonDTO> findAll() {
        List<Person> persons = personService.findAll();
        return persons.stream()
                .map(person -> modelMapper.map(person, PersonDTO.class))
                .collect(Collectors.toList());
    }

    @PostMapping(consumes = { 
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML },
        produces = { 
        MediaType.APPLICATION_JSON, 
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML })
    public ResponseEntity<PersonDTO> create(@RequestBody PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO, Person.class);
        Person createdPerson = personService.create(person);
        PersonDTO createdPersonDTO = modelMapper.map(createdPerson, PersonDTO.class);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdPersonDTO);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id) {
        personService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(
        consumes = { 
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML
     }, produces = { 
        MediaType.APPLICATION_JSON,
        MediaType.APPLICATION_XML,
        MediaType.APPLICATION_YML })
    public ResponseEntity<PersonDTO> update(@RequestBody PersonDTO personDTO) {
        Person person = modelMapper.map(personDTO, Person.class);
        Person updatedPerson = personService.update(person);
        PersonDTO updatedPersonDTO = modelMapper.map(updatedPerson, PersonDTO.class);
        return ResponseEntity.ok(updatedPersonDTO);
    }
}
