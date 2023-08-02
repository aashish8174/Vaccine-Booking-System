package com.example.vaccinebookingsystem.Controller;

import com.example.vaccinebookingsystem.Enum.DoseType;
import com.example.vaccinebookingsystem.Model.Dose;
import com.example.vaccinebookingsystem.Service.DoseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dose")
public class DoseController {

    @Autowired
    DoseService doseService;
    @PostMapping("/getDose1")
    public ResponseEntity getDose1(@RequestParam ("id") int personId,@RequestParam ("doseType") DoseType doseType){
      try  {
            Dose doseTaken = doseService.getDose1(personId, doseType);
            return new ResponseEntity(doseTaken,HttpStatus.CREATED);
        }
      catch (Exception e ){
          return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
      }
    }

    @PostMapping("/getDose2")
    public ResponseEntity getDose2(@RequestParam ("id") int personId,
                                   @RequestParam("doseType") DoseType doseType){
        try {
          Dose doseTk2 =  doseService.getDose2(personId, doseType);
          return new ResponseEntity<>(doseTk2,HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity(e.getMessage(),HttpStatus.BAD_REQUEST);
        }

    }
}
