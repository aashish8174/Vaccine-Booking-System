package com.example.vaccinebookingsystem.Service;

import com.example.vaccinebookingsystem.Enum.DoseType;
import com.example.vaccinebookingsystem.Exception.DoseAllreadyTakenException;
import com.example.vaccinebookingsystem.Exception.PersonNotFountExcption;
import com.example.vaccinebookingsystem.Exception.TakeDose1first;
import com.example.vaccinebookingsystem.Model.Dose;
import com.example.vaccinebookingsystem.Model.Person;
import com.example.vaccinebookingsystem.Repository.DoseRepository;
import com.example.vaccinebookingsystem.Repository.PersonRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class DoseService {
    @Autowired
    DoseRepository doseRepository;
    @Autowired
    PersonRepositry personRepositry;
    public Dose getDose1(int personId, DoseType doseType) {
        Optional<Person> optionalPerson = personRepositry.findById   (personId);
        if(!optionalPerson.isPresent()){
            throw new PersonNotFountExcption("Invalid PersonId");
        }
        Person person = optionalPerson.get();
        // check if dose 1 taken
        if(person.isDose1Taken()){
            throw new DoseAllreadyTakenException("Dose 1 already Taken");
        }
        // create dose
        Dose dose = new Dose();
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        dose.setDoseType(doseType);
        dose.setPerson(person);
        person.setDose1Taken(true);

        personRepositry.save(person);

        return doseRepository.save(dose);
    }

    public Dose getDose2(int personId, DoseType doseType) {
        Optional<Person> optionalDose = personRepositry.findById(personId);
        if(optionalDose.isEmpty()){
            throw new PersonNotFountExcption("Invalid personId");
        }
        Person person = optionalDose.get();
        if (!person.isDose1Taken()){
            throw new TakeDose1first("Dose1 is note taken ");
        }
        if(person.isDose2Taken() && person.isDose1Taken()){
            throw new DoseAllreadyTakenException("dose 2 already taken");
        }

        Dose dose = new Dose();
        person.setDose2Taken(true);
        person.setDose1Taken(true);
        dose.setDoseType(doseType);
        dose.setPerson(person);
        dose.setDoseId(String.valueOf(UUID.randomUUID()));
        personRepositry.save(person);
       return doseRepository.save(dose);
    }
}
