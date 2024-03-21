package com.aula7.services;

import com.aula7.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {
    private final AtomicLong counter = new AtomicLong();

    private Logger logger = Logger.getLogger(PersonService.class.getName());

    public Person findById(String id) {
        logger.info("Finding one person!");
        Person person = new Person();
        person.setId(counter.incrementAndGet());
        person.setFirstName("Weslley");
        person.setLastName("Francisco");
        person.setAddress("Cajazeiras, Paraíba, Brasil");
        person.setGender("Masculino");
        return person;
    }

    public List<Person> findAll() {
        logger.info("Finding all people!");
        List<Person> persons = new ArrayList<Person>();
        return persons;
    }

    public Person update(Person person) {
        logger.info("Updating one person!");
        return person;
    }

    public Person create(Person person) {
		logger.info("Creating one person!");
		return person;
	}

    public void delete(String id) {
		logger.info("Deleting one person!");
	}

}
