package com.example.vaccinebookingsystem.Service;

import com.example.vaccinebookingsystem.Model.VaccinationCenter;
import com.example.vaccinebookingsystem.Repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CenterService {
    @Autowired
    CenterRepository centerRepository;
    public VaccinationCenter addCenter(VaccinationCenter vaccinationCenter) {
       VaccinationCenter vaccinationCenter1 = centerRepository.save(vaccinationCenter);
    }
}
