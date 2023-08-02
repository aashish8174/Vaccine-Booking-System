package com.example.vaccinebookingsystem.Service;

import com.example.vaccinebookingsystem.Exception.PersonNotFountExcption;
import com.example.vaccinebookingsystem.Model.Person;
import com.example.vaccinebookingsystem.Repository.PersonRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    PersonRepositry personRepositry;
    public Person addPerson(Person person) {
        Person savedPerson = personRepositry.save(person);
        return savedPerson;
    }

    public Person updateEmail(String oldEmail, String newEmail) {
        Person person = personRepositry.findByEmailId(oldEmail);
        if (person==null){
            throw new PersonNotFountExcption("emailID doesn't exist");
        }
        person.setEmailId(newEmail);
        personRepositry.save(person);
        return person;
    }

    public Person getPerson(String emailId) {
       Person person = personRepositry.findByEmailId(emailId);
       if(person==null){
           throw new PersonNotFountExcption("emailID doesn't exits");
       }
       return person;
    }
}
