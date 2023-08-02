package com.example.vaccinebookingsystem.Controller;

import com.example.vaccinebookingsystem.Model.Person;
import com.example.vaccinebookingsystem.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;
    @PostMapping("/addPerson")
    public ResponseEntity addPerson(@RequestBody Person person){
        try {
            Person personResponse=personService.addPerson(person);
            return new ResponseEntity(personResponse, HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }

    @PutMapping("/update")
    public ResponseEntity updateEmail( @RequestParam ("oldEmail") String oldEmail ,
                                       @RequestParam ("newEmail") String newEmail){
        try {
            Person person = personService.updateEmail(oldEmail, newEmail);
            return new ResponseEntity<>(person,HttpStatus.OK);
        }
        catch (Exception e){
           return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get")
    public ResponseEntity getPerson(@RequestParam String emailId){

        try{
            Person person = personService.getPerson(emailId);
            return new ResponseEntity(person,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

}
