package com.peopledb.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.peopledb.project.model.Person;
import com.peopledb.project.repository.PersonRepository;

import jakarta.validation.Valid;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

@Data
@Controller
@RequestMapping("/people")
@Log4j2
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
    public String showPeoplePage(Model model) {
        return "people";
    }

    @ModelAttribute
    public Person getPerson() {
        return new Person();
    }

    @PostMapping
    public String savePerson(@Valid Person person, Errors errors, @RequestParam MultipartFile photoFilename){
        log.info(person);
        log.info("Filename: " + photoFilename.getOriginalFilename());
        log.info("File size: " + photoFilename.getSize());
        log.info("Errors: " + errors);
        if (!errors.hasErrors()) {
            personRepository.save(person);
            return "redirect:people";
        } 
        return "people";
    }

    @PostMapping(params = "delete=true")
    public String deletePeople(@RequestParam Optional<List<Long>> selections){
        log.info(selections);
        if(selections.isPresent()) {
            personRepository.deleteAllById(selections.get());
        }
        return "redirect:people";
    }

    @PostMapping(params = "edit=true")
    public String updatePerson(@RequestParam Optional<List<Long>> selections, Model model){
        if(selections.isPresent()) {
            Optional<Person> person = personRepository.findById(selections.get().get(0));
            model.addAttribute("person", person);
        }
        return "people";
    }
}
