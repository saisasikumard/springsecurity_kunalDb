package com.obito.acciojob.SpringSecuitiryDBKunal.service;

import com.obito.acciojob.SpringSecuitiryDBKunal.Repository.PersonRepository;
import com.obito.acciojob.SpringSecuitiryDBKunal.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepository personRepository;

    PasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
    public String addStudent(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRepository.save(person);
        return "Person Added...";

    }

    public Person find(String userName) {
        Person person=personRepository.findByUserName(userName);

        if(person==null){
            throw new RuntimeException("User Doesnot Exists.....");
        }
        return personRepository.findByUserName(userName);
    }
}
