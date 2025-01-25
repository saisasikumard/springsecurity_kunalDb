package com.obito.acciojob.SpringSecuitiryDBKunal.Repository;

import com.obito.acciojob.SpringSecuitiryDBKunal.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    public Person findByUserName(String username);
}
