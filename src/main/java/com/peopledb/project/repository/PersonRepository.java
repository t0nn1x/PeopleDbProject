package com.peopledb.project.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.peopledb.project.model.Person;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long>{
}
