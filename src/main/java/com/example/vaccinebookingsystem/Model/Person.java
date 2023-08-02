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

public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment primary key
    int id;

    String name;

    int adhar;

    int age;

    @Column(unique = true,nullable = false)//unique and not null
    String emailId;

    @Enumerated(EnumType.STRING)
    Gender gender;

    boolean isDose1Taken;

    boolean isDose2Taken;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)// mapping child table dose by table "person"
            // cascade => one after other
    List<Dose> doseTaken = new ArrayList<>();
   // Dose dose;// don't do this

    @OneToOne(mappedBy = "person",cascade = CascadeType.ALL)
    Certificate certificate;

    @OneToMany(mappedBy = "person",cascade = CascadeType.ALL)
    List<Appointment> appointments = new ArrayList<>();
}
