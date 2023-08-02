package com.example.vaccinebookingsystem.Model;

import com.example.vaccinebookingsystem.Enum.DoseType;
import com.example.vaccinebookingsystem.Enum.Gender;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)// to make all entity of class private
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Dose {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)// auto increment primary key
    int id;
    String doseId;
    @Enumerated(EnumType.STRING)

    DoseType doseType;
    @CreationTimestamp
    Date vaccinationDate ;// util date have date and time both whil sql date have only date

    @JsonIgnore// added from stackOverflow
    @ManyToOne // this for creating cardianatic relation
    @JoinColumn// taking forgin key persons primary key person table is parent table and dose is child table
    Person person;
}
