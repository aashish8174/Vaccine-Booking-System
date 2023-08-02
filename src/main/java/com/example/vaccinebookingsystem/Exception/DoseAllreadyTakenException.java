package com.example.vaccinebookingsystem.Exception;

public class DoseAllreadyTakenException extends RuntimeException {
    public DoseAllreadyTakenException (String mass) {
        super(mass);
    }
}
