package com.peopledb.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peopledb.project.model.Person;
import com.peopledb.project.repository.PersonRepository;

import lombok.Data;

@Data
@Controller
@RequestMapping("/people")
public class PeopleController {

    private PersonRepository personRepository;

    @Autowired
    public PeopleController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @ModelAttribute("people")
    public Iterable<Person> getPeople() {
        return personRepository.findAll();
    }

    @GetMapping
    public String showPeoplePage(Model model){
        return "people";
    }

    @ModelAttribute
    public Person getPerson(){
        return new Person();
    }

    @PostMapping
    public String savePerson(Person person){
        System.out.println(person);
        personRepository.save(person);
        return "redirect:people";
    }
}
