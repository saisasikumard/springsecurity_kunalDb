package com.obito.acciojob.SpringSecuitiryDBKunal.config;

import com.obito.acciojob.SpringSecuitiryDBKunal.Repository.PersonRepository;
import com.obito.acciojob.SpringSecuitiryDBKunal.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    PersonRepository personRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Person person=personRepository.findByUserName(username);
        if(person==null){
            throw new RuntimeException("UserName not exist ...");
        }

        return new UserDetailsCreator(person);
    }
}
