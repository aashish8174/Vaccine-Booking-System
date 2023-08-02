package com.example.vaccinebookingsystem.Repository;

import com.example.vaccinebookingsystem.Model.VaccinationCenter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CenterRepository extends JpaRepository<CenterRepository,Integer> {

}
