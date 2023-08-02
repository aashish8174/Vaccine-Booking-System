package com.example.vaccinebookingsystem.Repository;

import com.example.vaccinebookingsystem.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositry extends JpaRepository<Person,Integer>{

    Person findByEmailId(String oldEmail);// implementation is done by hibernate
}
