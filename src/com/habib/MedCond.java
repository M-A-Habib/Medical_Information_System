package com.habib;

public class MedCond {
    private String mdContact, mdPhone, algType, illType; //private variables to store values that
                                                //corresponds to the doctor, doctor's phone,
                                            //any allergy and the illness of a specific patient

    public MedCond(String mdContact, String mdPhone, String algType, String illType){
        this.mdContact = mdContact;         //constructor accepts all the parameter to create
                                            //instance of a medcond to be used in patientprod
        this.mdPhone = mdPhone;
        this.algType = algType;
        this.illType = illType;
    }

    public String getMdContact() {
        return mdContact;
    }//returns the name of the doctor

    public String getMdPhone() {
        return mdPhone;
    } //returns the phone number of the doctor

    public String getAlgType() {
        return algType;
    } //returns any allergy this patient might have

    public String getIllType() {
        return illType;
    }//returns any illness for which the patient sees
                                                    //doctor

    public void updateMdContact(String mdContact){//update the doctor's name
        this.mdContact = mdContact;
    }

    public void updateMdPhone(String mdPhone){
        this.mdPhone = mdPhone;
    }//update the doctor's phone

    public void updateAlgType(String algType){
        this.algType = algType;
    }//update the allergy

    public void updateIllType(String illType){
        this.illType = illType;
    }//update the illness
}
