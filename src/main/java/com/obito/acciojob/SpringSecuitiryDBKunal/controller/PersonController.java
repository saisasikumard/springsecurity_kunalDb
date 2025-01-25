package com.obito.acciojob.SpringSecuitiryDBKunal.controller;

import com.obito.acciojob.SpringSecuitiryDBKunal.entity.Person;
import com.obito.acciojob.SpringSecuitiryDBKunal.service.PersonService;
import jakarta.persistence.GeneratedValue;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/person")
public class PersonController {
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    @Autowired
    private PersonService personService;
   // @PostMapping("/add")
   @PostMapping("/add")
    public String addStudent(@RequestBody Person person){
       logger.info("Inside addStudent method...");
       return  personService.addStudent(person);

    }
    @GetMapping("/find")
    public Person find(@RequestParam("userName") String userName){
        return personService.find(userName);
    }
    @GetMapping("/public")
    public String welcome(){
        logger.info("Entered in welcome method");
        return "Welcome to public space..";
    }
}
