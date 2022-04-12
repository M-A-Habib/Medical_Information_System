package com.habib;

public class Patient {
    String lastName;
    String firstName;
    String address;
    String phoneNumber;
    String birthDate;
    float coPay;
    String insuranceType;
    enum insurance_Type{
        PRIVATE,
        GOVERNMENT;
    }
    String patientType;

    public Patient(){
        this.lastName = "";
        this.firstName = "";
        this.address = "";
        this.phoneNumber = "";
        this.birthDate = "";
        this.insuranceType = insurance_Type.PRIVATE.toString();
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
        this.lastName = lastName;
        this.firstName = firstName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.coPay = coPay;

        if(insuranceType.equals("Private") || insuranceType.equals("Government"))
            this.insuranceType = insuranceType;
        else
            this.insuranceType = "Private";

        if(patientType.equals("Pediatric") || patientType.equals("Adult") || patientType.equals("Geriatric"))
            this.patientType = patientType;
        else
            this.patientType = "Adult";
    }


}
