package com.habib;

public class Patient {
    String lastName;
    String firstName;
    String address;
    String phoneNumber;
    String birthDate;
    String insuranceType;
    float coPay;
    String patientType;

    public Patient(){
        this.lastName = "";
        this.firstName = "";
        this.address = "";
        this.phoneNumber = "";
        this.birthDate = "";
        this.insuranceType = "Private";
        this.coPay = 0;
        this.patientType = "Adult";
    }

    public Patient(String lastName,
                   String firstName,
                   String address,
                   String phoneNumber,
                   String birthDate,
                   String insuranceType,
                   float coPay,
                   String patientType){
        
    }
}
