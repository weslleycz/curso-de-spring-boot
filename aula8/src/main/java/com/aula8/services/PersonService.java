package com.aula8.services;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aula8.exceptions.ResourceNotFoundException;
import com.aula8.model.Person;
import com.aula8.repositories.PersonRepository;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(Long id) {
        logger.info("Finding one person!");
        return personRepository.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        Person entity = personRepository.findById(person.getId()).orElseThrow(() 
        -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());
        return personRepository.save(entity);
    }

    public Person create(Person person) {
        logger.info("Creating one person!");
        return personRepository.save(person);
    }

    public void delete(Long id) {
        logger.info("Deleting one person!");
        Person entity = personRepository.findById(id).orElseThrow(() 
        -> new ResourceNotFoundException("No records found for this ID!"));
        personRepository.delete(entity);
    }

}
