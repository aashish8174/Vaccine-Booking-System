package com.example.vaccinebookingsystem.Model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)// to make all entity of class private
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Certificate {
    @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String certificateNo;
    String certificationMassage;
    @OneToOne
    @JoinColumn
    Person person;
}
