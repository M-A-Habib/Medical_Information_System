package com.habib;

import java.util.Scanner;

public class PatientProfInterface {
    private String adminID;         //this adminID corresponds to the adminID used to choose from the
                                    //menu
    private Scanner scan;      //scans the input from the user.
    private PatientProfDB patientDatabase; //an instance of the database
    private String fileName;//the filename containing the database
    public PatientProfInterface(String dataBaseTXT) {//the constructor initializes the variables
        this.adminID = "";
        scan = new Scanner(System.in);
        fileName = dataBaseTXT;
        patientDatabase = new PatientProfDB(fileName);
        patientDatabase.initializeDatabase(fileName);
    }

    public void getUserChoice(){//runs the user interface in which the user chooses options from the
                                    //menu
        choiceMaker();//Was created during testing and turned it into a separate method but it is the
                    //same functionality as the getUSerChoice
    }

    private void choiceMaker(){

        String updateOptions = "\tChoose one -> address, phone, insurance, copay, patienttype, mdcontact, mdphone, illtype, algtype";
        String choice, arg;//choice corresponds to the option selected and arg corresponds to the
                            //arguments needed for an option
        do{
            System.out.println("Choose an option from the menu below: \nDelete Patient Profile (delete *lastname*)\n" +
                    "Update Patient Profile(update *what you want to update*)\n" + updateOptions + "\nDisplay Patient Profile(display *patient last name*)\nDisplay All Patient Profile(displayall)\nCreate New Patient Profile(createnewpatientprof)\n" +
                    "\nType \"close\" to close the menu");
            String input = scan.nextLine();//reaads the input from the user
            int i = 0;

            while(input.charAt(i) != ' ' && i < input.length()-1)//this is used to separate the input
                        //into choice and arg
                i++;

            if(i != input.length()) {//separates the choice and arg
                choice = input.substring(0, i + 1).strip();
                arg = input.substring(i + 1);
            }
            else {
                arg = "";
                choice = input;
            }

            if(choice.equals("delete")) {//deletes a profile
                System.out.println("Please enter your adminID");//always asks for the adminID
                                        //everytime an option is selected
                this.adminID = scan.nextLine();
                if(patientDatabase.checkAdminID(this.adminID))
                    deletePatientProf(arg);
                else
                    System.out.println("Incorrect adminID");
            }
            else if(choice.equals("update")) {//update a certain info from the profile
                System.out.println("Please enter your adminID");
                this.adminID = scan.nextLine();
                if(patientDatabase.checkAdminID(this.adminID)){
                    System.out.print("Please enter last name: ");
                    String lastName = scan.nextLine();
                    updatePatientProf(arg, lastName);
                }
                else{
                    System.out.println("Incorrect adminID");
                }
            }
            else if(choice.equals("display")){//display a certain profile when the lastname is
                                //provided
                System.out.println("Please enter your adminID");
                this.adminID = scan.nextLine();
                if(patientDatabase.checkAdminID(this.adminID))
                    displayPatientProf(this.adminID, arg);
                else
                    System.out.println("Incorrect adminID");
            }
            else if(choice.equals("displayall")){//displays all the profiles that corresponds to a
                                        //adminID
                System.out.println("Please enter your adminID");
                this.adminID = scan.nextLine();
                if(patientDatabase.checkAdminID(this.adminID))
                    displayAllPatientProf();
                else
                    System.out.println("Incorrect adminID or not found");
            }
            else if(choice.equals("createnewpatientprof")){//creates a new patient prof
                createNewPatientProf();
                /*if(patientDatabase.checkAdminID(this.adminID))
                    createNewPatientProf();
                else
                    System.out.println("Incorrect adminID");*/
            }
            else if(choice.equals("findfirstprofile")){//always returns the first profile with the
                                    //given adminID
                System.out.println("Please enter your adminID");
                this.adminID = scan.nextLine();
                if(patientDatabase.checkAdminID(this.adminID)) {
                    PatientProf output = findFirstProfile();
                    System.out.print("Admin ID: " + output.getAdminID() + "\n");
                    System.out.print("First Name: " + output.getFirstName() + "\n");
                    System.out.print("Last Name: " + output.getLastname() + "\n");
                    System.out.print("Address: " + output.getAddress() + "\n");
                    System.out.print("Phone Number: " + output.getPhone() + "\n");
                    System.out.print("Co-Pay: " + output.getCoPay() + "\n");
                    System.out.print("Insurance Type: " + output.getInsuType() + "\n");
                    System.out.print("Patient Type: " + output.getPatientType() + "\n");
                    System.out.print("Medical Information: \n");
                    System.out.print("\tMD Contact: " + output.getMedCondInfo().getMdContact() + "\n");
                    System.out.print("\tMD Phone: " + output.getMedCondInfo().getMdPhone() + "\n");
                    System.out.print("\tAllergy Type: " + output.getMedCondInfo().getAlgType() + "\n");
                    System.out.print("\tIllness Type: " + output.getMedCondInfo().getIllType() + "\n");
                    System.out.print("\n");
                }
                else
                    System.out.println("Incorrect adminID");
            }
            else if(choice.equals("findnextprofile")){//finds the next profile with the given
                                    //adminID
                System.out.println("Please enter your adminID");
                this.adminID = scan.nextLine();
                if(patientDatabase.checkAdminID(this.adminID)) {
                    PatientProf output = findNextProfile();
                    System.out.print("Admin ID: " + output.getAdminID() + "\n");
                    System.out.print("First Name: " + output.getFirstName() + "\n");
                    System.out.print("Last Name: " + output.getLastname() + "\n");
                    System.out.print("Address: " + output.getAddress() + "\n");
                    System.out.print("Phone Number: " + output.getPhone() + "\n");
                    System.out.print("Co-Pay: " + output.getCoPay() + "\n");
                    System.out.print("Insurance Type: " + output.getInsuType() + "\n");
                    System.out.print("Patient Type: " + output.getPatientType() + "\n");
                    System.out.print("Medical Information: \n");
                    System.out.print("\tMD Contact: " + output.getMedCondInfo().getMdContact() + "\n");
                    System.out.print("\tMD Phone: " + output.getMedCondInfo().getMdPhone() + "\n");
                    System.out.print("\tAllergy Type: " + output.getMedCondInfo().getAlgType() + "\n");
                    System.out.print("\tIllness Type: " + output.getMedCondInfo().getIllType() + "\n");
                    System.out.print("\n");
                }
                else
                    System.out.println("Incorrect adminID");
            }
            if(choice.equals("createnewmedcond")){//creates a new medcond
                System.out.println("Please enter your adminID");
                this.adminID = scan.nextLine();
                if(patientDatabase.checkAdminID(this.adminID))
                    createNewMedCond();
                else
                    System.out.println("Incorrect adminID");
            }
        }while(!choice.equals("close"));
    }

    private void deletePatientProf(String lastName){//deletes the profile with the given adminID
                                                //and the lastname
        System.out.println(patientDatabase.deleteProfile(this.adminID, lastName));
    }

    protected void deletePatientProf(String adminID, String lName){//deletes the profile with the given adminID
        //and the lastname
        patientDatabase.deleteProfile(adminID, lName);
    }

    protected PatientProf findProfile(String adminIDInput, String lastName){//find the profile with
                                //the given adminID and lastname and returns the patientprof
        PatientProf output = patientDatabase.findProfile(adminIDInput, lastName);
        return output;
    }

    private void updatePatientProf(String update, String lastName){//updates the chosen information
                        //in the profile
        if(update.equals("address")){//updates the address
            PatientProf output = patientDatabase.findProfile(this.adminID, lastName);
            System.out.print("Enter new address: ");
            String arg = scan.nextLine();
            output.updateAddress(arg);
        }
        else if(update.equals("phone")){//updates the phone
            PatientProf output = patientDatabase.findProfile(this.adminID, lastName);
            System.out.print("Enter new phone number: ");
            String arg = scan.nextLine();
            output.updatePhone(arg);
        }
        else if(update.equals("insurance")){//updates the type of insurance
            PatientProf output = patientDatabase.findProfile(this.adminID, lastName);
            System.out.print("Enter new insurance type: ");
            String arg = scan.nextLine();
            output.updateInsuranceType(arg);
        }
        else if(update.equals("copay")){//updates the amount of copay
            PatientProf output = patientDatabase.findProfile(this.adminID, lastName);
            System.out.print("Enter new copay amount: ");
            String arg = scan.nextLine();
            output.updateCoPay(Float.parseFloat(arg));
        }
        else if(update.equals("patienttype")){//updates the type of patient
            PatientProf output = patientDatabase.findProfile(this.adminID, lastName);
            System.out.print("Enter new patient type: ");
            String arg = scan.nextLine();
            output.updatePatientType(arg);
        }
        else if(update.equals("mdcontact")){//update mdcontact
            MedCond output = patientDatabase.findProfile(this.adminID, lastName).getMedCondInfo();
            System.out.print("Enter new MD Contact: ");
            String arg = scan.nextLine();
            output.updateMdContact(arg);
        }
        else if(update.equals("mdphone")){//update md phone number
            MedCond output = patientDatabase.findProfile(this.adminID, lastName).getMedCondInfo();
            System.out.print("Enter new MD Phone: ");
            String arg = scan.nextLine();
            output.updateMdPhone(arg);
        }
        else if(update.equals("illtype")){//update illness
            MedCond output = patientDatabase.findProfile(this.adminID, lastName).getMedCondInfo();
            System.out.print("Enter new illness: ");
            String arg = scan.nextLine();
            output.updateIllType(arg);
        }
        else if(update.equals("algtype")){//update allergy
            MedCond output = patientDatabase.findProfile(this.adminID, lastName).getMedCondInfo();
            System.out.print("Enter new Allergy: ");
            String arg = scan.nextLine();
            output.updateAlgType(arg);
        }

        patientDatabase.writeAllPatientProf(fileName);//always updates the database with every change
    }

    protected void updatePatientProf(String update, String lastName, String arg, String adminID){//updates the chosen information
        //in the profile
        if(update.equals("Address")){//updates the address
            PatientProf output = patientDatabase.findProfile(adminID, lastName);
            //System.out.print("Enter new address: ");
            //String arg = scan.nextLine();
            output.updateAddress(arg);
        }
        else if(update.equals("Phone")){//updates the phone
            PatientProf output = patientDatabase.findProfile(adminID, lastName);
            //System.out.print("Enter new phone number: ");
            //String arg = scan.nextLine();
            output.updatePhone(arg);
        }
        else if(update.equals("Insurance")){//updates the type of insurance
            PatientProf output = patientDatabase.findProfile(adminID, lastName);
            //System.out.print("Enter new insurance type: ");
            //String arg = scan.nextLine();
            output.updateInsuranceType(arg);
        }
        else if(update.equals("CoPay")){//updates the amount of copay
            PatientProf output = patientDatabase.findProfile(adminID, lastName);
            //System.out.print("Enter new copay amount: ");
            //String arg = scan.nextLine();
            output.updateCoPay(Float.parseFloat(arg));
        }
        else if(update.equals("Patient Type")){//updates the type of patient
            PatientProf output = patientDatabase.findProfile(adminID, lastName);
            //System.out.print("Enter new patient type: ");
            //String arg = scan.nextLine();
            output.updatePatientType(arg);
        }
        else if(update.equals("MD Contact")){//update mdcontact
            MedCond output = patientDatabase.findProfile(adminID, lastName).getMedCondInfo();
            //System.out.print("Enter new MD Contact: ");
            //String arg = scan.nextLine();
            output.updateMdContact(arg);
        }
        else if(update.equals("MD Phone")){//update md phone number
            MedCond output = patientDatabase.findProfile(adminID, lastName).getMedCondInfo();
            //System.out.print("Enter new MD Phone: ");
            //String arg = scan.nextLine();
            output.updateMdPhone(arg);
        }
        else if(update.equals("Illness")){//update illness
            MedCond output = patientDatabase.findProfile(adminID, lastName).getMedCondInfo();
            //System.out.print("Enter new illness: ");
            //String arg = scan.nextLine();
            output.updateIllType(arg);
        }
        else if(update.equals("Allergy")){//update allergy
            MedCond output = patientDatabase.findProfile(adminID, lastName).getMedCondInfo();
            //System.out.print("Enter new Allergy: ");
            //String arg = scan.nextLine();
            output.updateAlgType(arg);
        }

        patientDatabase.writeAllPatientProf(fileName);//always updates the database with every change
    }

    private void displayPatientProf(String adminIDInput, String lastName){//displays the
            //patient info with the same format of the database when lastname and adminID is provided
        PatientProf output = findProfile(adminIDInput, lastName);

        System.out.print("Admin ID: " + output.getAdminID() + "\n");
        System.out.print("First Name: " + output.getFirstName() + "\n");
        System.out.print("Last Name: " + output.getLastname() + "\n");
        System.out.print("Address: " + output.getAddress() + "\n");
        System.out.print("Phone Number: " + output.getPhone() + "\n");
        System.out.print("Co-Pay: " + output.getCoPay() + "\n");
        System.out.print("Insurance Type: " + output.getInsuType() + "\n");
        System.out.print("Patient Type: " + output.getPatientType() + "\n");
        System.out.print("Medical Information: \n");
        System.out.print("\tMD Contact: " + output.getMedCondInfo().getMdContact() + "\n");
        System.out.print("\tMD Phone: " + output.getMedCondInfo().getMdPhone() + "\n");
        System.out.print("\tAllergy Type: " + output.getMedCondInfo().getAlgType() + "\n");
        System.out.print("\tIllness Type: " + output.getMedCondInfo().getIllType() + "\n");
        System.out.print("\n");
    }

    private void displayAllPatientProf(){//displays all the profile with the given adminID
        for(int i = 0; i < patientDatabase.getNumPatient(); i++){
            PatientProf output = patientDatabase.findNextProfile();
            if(output.getAdminID().equals(this.adminID)){
                System.out.print("Admin ID: " + output.getAdminID() + "\n");
                System.out.print("First Name: " + output.getFirstName() + "\n");
                System.out.print("Last Name: " + output.getLastname() + "\n");
                System.out.print("Address: " + output.getAddress() + "\n");
                System.out.print("Phone Number: " + output.getPhone() + "\n");
                System.out.print("Co-Pay: " + output.getCoPay() + "\n");
                System.out.print("Insurance Type: " + output.getInsuType() + "\n");
                System.out.print("Patient Type: " + output.getPatientType() + "\n");
                System.out.print("Medical Information: \n");
                System.out.print("\tMD Contact: " + output.getMedCondInfo().getMdContact() + "\n");
                System.out.print("\tMD Phone: " + output.getMedCondInfo().getMdPhone() + "\n");
                System.out.print("\tAllergy Type: " + output.getMedCondInfo().getAlgType() + "\n");
                System.out.print("\tIllness Type: " + output.getMedCondInfo().getIllType() + "\n");
                System.out.print("\n");
            }
        }
        patientDatabase.setCurrentPatientIndex(0);
    }

    private void writeToDB(){//writes all the info to the database
        patientDatabase.writeAllPatientProf(fileName);
    }

    private void initDB(){//initializes the database
        patientDatabase.initializeDatabase(fileName);
    }

    private void createNewPatientProf(){//creates a new patient profile by asking the user for
                //information regarding the new profile
        System.out.println("Please enter your adminID");
        this.adminID = scan.nextLine();
        System.out.print("Enter first name: ");
        String fName = scan.nextLine();
        System.out.print("Enter last name: ");
        String lName = scan.nextLine();
        System.out.print("Enter the address: ");
        String addr = scan.nextLine();
        System.out.print("Enter phone number: ");
        String phoneNum = scan.nextLine();
        System.out.print("Enter coPay amount: ");
        float coPay = Float.parseFloat(scan.nextLine());
        System.out.print("Enter insurance type: ");
        String insuType = scan.nextLine();
        System.out.print("Enter Patient type: ");
        String patientType = scan.nextLine();

        PatientProf output = new PatientProf(this.adminID, fName, lName,
                addr, phoneNum, coPay, insuType,
                patientType, createNewMedCond());
        patientDatabase.insertNewProfile(output);
    }

    private MedCond createNewMedCond(){//creates a new medical condition with the provided
                        //information from the user
        System.out.println("Enter medical information");
        System.out.print("Enter MD Contact: ");
        String mdContact = scan.nextLine();
        System.out.print("Enter MD Phone Number: ");
        String mdPhone = scan.nextLine();
        System.out.print("Enter any allergy the patient has: ");
        String algType = scan.nextLine();
        System.out.print("Enter any illness of the patient: ");
        String illType = scan.nextLine();

        return new MedCond(mdContact, mdPhone, algType, illType);
    }

    private PatientProf findFirstProfile(){//always find the first profile with the given adminID
        int curIndex = patientDatabase.getCurrentPatientIndex();//records the current index
        patientDatabase.setCurrentPatientIndex(0);//then sets the index to 0
        for(int i = 0; i < patientDatabase.getNumPatient(); i++){//then user nextprofile to
                    //iterate through the list and check for the first profile with the same adminID
            PatientProf check = patientDatabase.findNextProfile();
            if(check.getAdminID().equals(this.adminID)) {
                if(curIndex != 0)
                    patientDatabase.setCurrentPatientIndex(curIndex);//if the index doesn't equal 0
                            //then set the index to the recorded index
                return check;
            }
        }
        patientDatabase.setCurrentPatientIndex(curIndex);
        return patientDatabase.findProfile("unknown", "unknown");//if not found then
        //return a profile with unknown attributes
    }

    private PatientProf findNextProfile(){//finds the next profile with the same adminID provided
        for(int i = 0; i < patientDatabase.getNumPatient(); i++){
            PatientProf check = patientDatabase.findNextProfile();
            if(check.getAdminID().equals(this.adminID))
                return check;
        }

        return patientDatabase.findProfile("unknown", "unknown");
    }

    protected PatientProf findNextProfile(String adminID_Inp){//finds the next profile with the same adminID provided
        for(int i = 0; i < patientDatabase.getNumPatient(); i++){
            PatientProf check = patientDatabase.findNextProfile();
            if(check.getAdminID().equals(adminID_Inp))
                return check;
        }

        return patientDatabase.findProfile("unknown", "unknown");
    }

    protected void resetPatientIndex(){
        patientDatabase.setCurrentPatientIndex(0);
    }

    private void setnewMedCond(String lastName){//this sets a new medcond for the given lastname
                        //and updates it
        patientDatabase.findProfile(this.adminID, lastName).updateMedCondInfo(createNewMedCond());
        patientDatabase.writeAllPatientProf(fileName);
    }

    ////////////////////////////////////////////////////////////

    public void createNewPatientProf(String adminID, String fName, String lName, String addr,
                                      String phoneNum, float coPay, String insuType,
                                      String patientType, MedCond nMedCond){//creates a new patient profile by asking the user for
        //information regarding the new profile
        PatientProf output = new PatientProf(adminID, fName, lName,
                addr, phoneNum, coPay, insuType,
                patientType, nMedCond);
        patientDatabase.insertNewProfile(output);
    }

    public MedCond createNewMedCond(String mdContact, String mdPhone, String algType, String illType){//creates a new medical condition with the provided
        //information from the user
        return new MedCond(mdContact, mdPhone, algType, illType);
    }
}
