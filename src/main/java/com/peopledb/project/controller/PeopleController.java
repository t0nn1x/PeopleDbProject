package com.peopledb.project.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.peopledb.project.model.Person;

import lombok.Data;

@Data
@Controller
@RequestMapping("/people")
public class PeopleController {

    @GetMapping
    public String getPeople(Model model){
        List<Person> people = List.of(
            new Person(10l, "Jake", "Snake", LocalDate.of(1950, 5, 28), new BigDecimal("50000")),
            new Person(20l, "Dude", "Dog", LocalDate.of(1906, 5, 28), new BigDecimal("60000")),
            new Person(30l, "Carl", "Cat", LocalDate.of(2003, 5, 28), new BigDecimal("70000")),
            new Person(40l, "John", "Rat", LocalDate.of(2000, 5, 28), new BigDecimal("80000"))
            );
        model.addAttribute("people", people);
        return "people";
    }
}
