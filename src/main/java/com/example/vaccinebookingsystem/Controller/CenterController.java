package com.example.vaccinebookingsystem.Controller;

import com.example.vaccinebookingsystem.Model.VaccinationCenter;
import com.example.vaccinebookingsystem.Service.CenterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/center")
public class CenterController {
    @Autowired
    CenterService centerService;

    @PostMapping
    public ResponseEntity addCenter(@RequestBody VaccinationCenter vaccinationCenter){
        VaccinationCenter vaccinationCenter1 = centerService.addCenter(vaccinationCenter);
    }
}
