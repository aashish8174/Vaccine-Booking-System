package com.example.vaccinebookingsystem.Repository;

import com.example.vaccinebookingsystem.Model.Dose;
import com.example.vaccinebookingsystem.Model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface DoseRepository extends JpaRepository<Dose,Integer> {

}
