package com.habib;

public class PatientProf {
    private String adminID; //stores adminID
    private String firstName; //stores the first name
    private String lastname;//stores the last name
    private String address;//stores the address
    private String phone;//stores the phone number
    private float coPay;//stores the copay amount in float
    private String insuType;//stores the type of insurance
    private String patientType;//stores the patient type by age
    private MedCond medCondInfo;//stores any medical condition the patient might have
    public PatientProf(String adminID, String firstName, String lastName, String address, String phone,
                       float coPay, String insuType, String patientType, MedCond medCondInfo){
        this.adminID = adminID;                 //The constructor accepts all the necessary
        this.firstName = firstName;             //parameters for creating the patient profile
        this.lastname = lastName;
        this.address = address;
        this.phone = phone;
        this.coPay = coPay;
        this.insuType = insuType;
        this.patientType = patientType;
        this.medCondInfo = medCondInfo;
    }

    public String getAdminID() {
        return adminID; //Return the adminID
    }

    public String getFirstName() {
        return firstName;//get the first name of a specific instance of this class
    }

    public String getLastname() {
        return lastname;
    } //returns the last name

    public String getAddress() {//returns the address
        return address;
    }

    public String getPatientType() {
        return patientType;
    }//returns the type of patient

    public float getCoPay() {
        return coPay;
    }//returns the copay amount

    public String getInsuType() {
        return insuType;
    }//returns the insurance type

    public String getPhone() {
        return phone;
    }//returns the phone number on the records

    public MedCond getMedCondInfo() {
        return medCondInfo;
    }//returns the medical condition if
                                                        //applicable

    public void updateFirstName(String firstName){
        this.firstName = firstName;
    }//update the first
                                                                                //name

    public void updateLastName(String lastname){
        this.lastname = lastname;
    }//update the last name

    public void updateAddress(String address){
        this.address = address;
    }//update the address

    public void updatePhone(String phone){
        this.phone = phone;//update the phone number on record
    }

    public void updateInsuranceType(String insurance){this.insuType = insurance;}//update the type
                                                                        //of insurance

    public void updateCoPay(float coPay){
        this.coPay = coPay;
    }//updates the copay amount

    public void updatePatientType(String patientType){
        this.patientType = patientType;
    }//updates
                                                //the type of patient by age

    public void updateMedCondInfo(MedCond medCondInfo){//updates the medical condition with a
                                                    //newly created medical condition
        this.medCondInfo = medCondInfo;
    }
}
