package com.peopledb.project.repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.peopledb.project.model.Person;

// @Component
public class PersonDataLoader implements ApplicationRunner {

    private PersonRepository personRepository;

    public PersonDataLoader(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if (personRepository.count() == 0) {
            List<Person> people = List.of(
                    new Person(null, "11111", "111111", "1@gmail.com", LocalDate.of(1950, 5, 28), new BigDecimal("50000")),
                    new Person(null, "22222", "222222", "2@gmail.com", LocalDate.of(1906, 5, 28), new BigDecimal("60000")),
                    new Person(null, "Carl", "Cat", "3@gmail.com", LocalDate.of(2003, 5, 28), new BigDecimal("70000")),
                    new Person(null, "John", "Rat", "4@gmail.com", LocalDate.of(2000, 5, 28), new BigDecimal("80000")));
            personRepository.saveAll(people);
        }
    }

}
