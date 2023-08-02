package com.example.vaccinebookingsystem.Model;

import com.example.vaccinebookingsystem.Enum.Gender;
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
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment primary key
    int id;

    String name;

    int age;

    @Column(unique = true,nullable = false)//unique and not null
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    List<Appointment> doctors= new ArrayList<>();

    @ManyToOne
    @JoinColumn
    VaccinationCenter center;
}
