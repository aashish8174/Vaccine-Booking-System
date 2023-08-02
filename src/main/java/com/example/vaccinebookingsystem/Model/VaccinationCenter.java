package com.example.vaccinebookingsystem.Model;

import com.example.vaccinebookingsystem.Enum.CenterType;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.ArrayList;
import java.util.List;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)// to make all entity of class private
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class VaccinationCenter {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment primary key
    int id;

    String centerName;
    CenterType centerType;
    String address;

   @OneToMany(mappedBy = "center",cascade = CascadeType.ALL)
   List<Doctor> doctorList = new ArrayList<>();
}
