package com.aula8.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aula8.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {}
