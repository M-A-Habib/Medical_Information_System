package com.habib;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class PatientProfDB {
    private int numPatient, currentPatientIndex; //these are used to find the next profile or
                        //figure out the umber of total patient for the interface later on
    private String fileName; //this hold the name of the file that stores the database
    private FileWriter outputFile; //this is the file that the database is written in
    private String directory;//this is the directory relative the src folder in which the
                                    //database txt file is in
    private PatientProf[] patientList;//this holds the temporary list of all the patients before
                                //it is written to the database txt file

    public PatientProfDB(String fileName){//the constructor initializes the file
        this.fileName = fileName;
        this.directory = "./src/com/habib/" + this.fileName;
        currentPatientIndex = 0;
    }

    public void insertNewProfile(PatientProf patient){
        if(patientList == null){ //if the patient list is empty then create a new list and add the
                            //provided profile into it
            PatientProf[] newList = new PatientProf[1];
            newList[0] = patient;
            patientList = newList;
        }
        else {//else the list grows dynamically as new profiles are inserted
            PatientProf[] newList = new PatientProf[patientList.length + 1];//everytime a new profile
                                        //is inserted the list grows by 1 element
            for (int i = 0; i < patientList.length; i++)
                newList[i] = patientList[i];
            newList[newList.length - 1] = patient;
            patientList = newList;
        }

        writeAllPatientProf(fileName);//everytime the list updates you must update the permanent
                                                //database txt file as well

        numPatient++; //increase the number of total patients
    }

    public void insertNewProfile_Init(PatientProf patient){
        if(patientList == null){ //if the patient list is empty then create a new list and add the
            //provided profile into it
            PatientProf[] newList = new PatientProf[1];
            newList[0] = patient;
            patientList = newList;
        }
        else {//else the list grows dynamically as new profiles are inserted
            PatientProf[] newList = new PatientProf[patientList.length + 1];//everytime a new profile
            //is inserted the list grows by 1 element
            for (int i = 0; i < patientList.length; i++)
                newList[i] = patientList[i];
            newList[newList.length - 1] = patient;
            patientList = newList;
        }
        numPatient++; //increase the number of total patients
    }

    public boolean deleteProfile(String adminID, String lastName){//used to delete a specific
                    //instance of patientprof from the list
        boolean ret = false;//if successful return true. Otherwise return false
        for(int i = 0; i < patientList.length; i++){
            if(patientList[i].getAdminID().equals(adminID) && patientList[i].getLastname().equals(lastName)) {
                for(int j = i; j < patientList.length - 1; j++)
                    patientList[j] = patientList[j + 1];
                ret = true;
                break;
            }
        }
        PatientProf[] newList = new PatientProf[patientList.length - 1];//reduce the size dynamically
                    //as the profile is deleted the list becomes smaller
        for(int i = 0; i < newList.length; i++)
            newList[i] = patientList[i];
        patientList = newList;
        numPatient--;
        currentPatientIndex = 0;

        writeAllPatientProf(fileName);//update the database
        return ret;//return whether the task was successful or not
    }

    public PatientProf findProfile(String adminID, String lastName){
        for(int i = 0; i < patientList.length; i++) {//go through the list and if the adminID and
                            //last name matches return that profile
            if (patientList[i].getAdminID().equals(adminID) && patientList[i].getLastname().equals(lastName))
                return patientList[i];
        }
        return new PatientProf("unknown", "unknown", "unknown",
                "unknown", "unknown", 0, "unknown",
                "unknown", new MedCond("unknown",
                "unknown", "unknown", "unknown"));//otherwise return a
                                    //profile with unknown for the data
    }

    public PatientProf findFirstProfile(){//find the first profile. This method was only used
                                    //during testing because it doesn't check for the adminID
                                    //actual findFirstProfile is and implementation detail in the interface
        if(currentPatientIndex == 0)
            this.currentPatientIndex++;//always increment when you access a certain profile
        return patientList[0];
    }

    public PatientProf findNextProfile(){//this method is used to iterate through the list
        if(currentPatientIndex > patientList.length - 1)//if the list is empty then return unknown for the attributes
            return new PatientProf("unknown", "unknown", "unknown",
                    "unknown", "unknown", 0, "unknown",
                    "unknown", new MedCond("unknown",
                    "unknown", "unknown", "unknown"));
        PatientProf ret = patientList[this.currentPatientIndex];//otherwise return the next profile
        this.currentPatientIndex++;//increment the index by 1
        return ret;
    }

//    public PatientProf findNextProfile(){//this method is used to iterate through the list
//        if(currentPatientIndex > patientList.length - 1)//if the list is empty then return unknown for the attributes
//            return patientList[patientList.length - 1];
//        PatientProf ret = patientList[this.currentPatientIndex];//otherwise return the next profile
//        this.currentPatientIndex++;//increment the index by 1
//        return ret;
//    }

//    public void writeAllPatientProf(String fileName){//this method writes the temporary list into the txt file provided
//        try{
//            this.fileName = fileName;
//            this.directory = "./src/com/habib/" + this.fileName;
//            outputFile = new FileWriter(directory, false);
//            outputFile.close();
//            outputFile = new FileWriter(directory, true);
//            for(int i = 0; i < patientList.length; i++){//iteratively writes the data into the txt file
//                outputFile.write("Admin ID: " + patientList[i].getAdminID() + "\n");
//                outputFile.write("First Name: " + patientList[i].getFirstName() + "\n");
//                outputFile.write("Last Name: " + patientList[i].getLastname() + "\n");
//                outputFile.write("Address: " + patientList[i].getAddress() + "\n");
//                outputFile.write("Phone Number: " + patientList[i].getPhone() + "\n");
//                outputFile.write("Co-Pay: " + patientList[i].getCoPay() + "\n");
//                outputFile.write("Insurance Type: " + patientList[i].getInsuType() + "\n");
//                outputFile.write("Patient Type: " + patientList[i].getPatientType() + "\n");
//                outputFile.write("Medical Information: \n");
//                outputFile.write("\tMD Contact: " + patientList[i].getMedCondInfo().getMdContact() + "\n");
//                outputFile.write("\tMD Phone: " + patientList[i].getMedCondInfo().getMdPhone() + "\n");
//                outputFile.write("\tAllergy Type: " + patientList[i].getMedCondInfo().getAlgType() + "\n");
//                outputFile.write("\tIllness Type: " + patientList[i].getMedCondInfo().getIllType() + "\n");
//                outputFile.write("\n");
//            }
//            outputFile.close();//close the file after done writing
//        }
//        catch(Exception ex){
//            ex.printStackTrace();//use catch to catch any error regarding not being able to fint he file or anything
//        }
//    }

    public void writeAllPatientProf(String fileName){//this method writes the temporary list into the txt file provided
        try{
            this.fileName = fileName;
            this.directory = "./src/com/habib/" + this.fileName;
            outputFile = new FileWriter(directory, false);
            outputFile.close();
            outputFile = new FileWriter(directory, true);
            for(int i = 0; i < patientList.length; i++){//iteratively writes the data into the txt file
                outputFile.write(patientList[i].getAdminID() + "\n");
                outputFile.write(patientList[i].getFirstName() + "\n");
                outputFile.write(patientList[i].getLastname() + "\n");
                outputFile.write(patientList[i].getAddress() + "\n");
                outputFile.write(patientList[i].getPhone() + "\n");
                outputFile.write(patientList[i].getCoPay() + "\n");
                outputFile.write(patientList[i].getPatientType() + "\n");
                outputFile.write(patientList[i].getInsuType() + "\n");
                outputFile.write(patientList[i].getMedCondInfo().getMdContact() + "\n");
                outputFile.write(patientList[i].getMedCondInfo().getMdPhone() + "\n");
                outputFile.write(patientList[i].getMedCondInfo().getAlgType() + "\n");
                if(i == patientList.length - 1)
                    outputFile.write(patientList[i].getMedCondInfo().getIllType());
                else
                    outputFile.write(patientList[i].getMedCondInfo().getIllType() + "\n");
            }
            outputFile.close();//close the file after done writing
        }
        catch(Exception ex){
            ex.printStackTrace();//use catch to catch any error regarding not being able to fint he file or anything
        }
    }

//    public void initializeDatabase(String fileName){//initializing the database takes the txt file
//                            //and puts into the patient list for program use
//        this.fileName = fileName;
//        this.directory = "./src/com/habib/" + this.fileName;
//        File inputFile = new File(directory);
//        String input = "";
//
//        try {
//            Scanner scan = new Scanner(inputFile);
//            while(scan.hasNextLine()) {
//                input = scan.nextLine();//initializes every variables in the profile
//                String adminID = extractString(input);
//                input = scan.nextLine();
//                String fName = extractString(input);
//                input = scan.nextLine();
//                String lName = extractString(input);
//                input = scan.nextLine();
//                String addr = extractString(input);
//                input = scan.nextLine();
//                String pNumber = extractString(input);
//                input = scan.nextLine();
//                String coPay = extractString(input);
//                input = scan.nextLine();
//                String insuranceType = extractString(input);
//                input = scan.nextLine();
//                String patientType = extractString(input);
//                scan.nextLine();
//                input = scan.nextLine();
//                String mdContact = extractString(input);
//                input = scan.nextLine();
//                String mdPhone = extractString(input);
//                input = scan.nextLine();
//                String allergyType = extractString(input);
//                input = scan.nextLine();
//                String illnessType = extractString(input);
//                if(scan.hasNextLine())
//                    scan.nextLine();
//
//                MedCond newMedCond = new MedCond(mdContact, mdPhone, allergyType, illnessType);
//
//                PatientProf newPatientProf = new PatientProf(adminID, fName, lName, addr, pNumber,
//                        Float.parseFloat(coPay), insuranceType, patientType, newMedCond);
//                insertNewProfile(newPatientProf);
//
//            }
//        }
//        catch(Exception ex){
//            ex.printStackTrace();
//        }
//    }

    public void initializeDatabase(String fileName){//initializing the database takes the txt file
        //and puts into the patient list for program use
        this.fileName = fileName;
        this.directory = "./src/com/habib/" + this.fileName;
        File inputFile = new File(directory);
        String input = "";

        try {
            Scanner scan = new Scanner(inputFile);
            while(scan.hasNext()) {
                String adminID = scan.nextLine().strip();
                String fName = scan.nextLine().strip();
                String lName = scan.nextLine().strip();
                String addr = scan.nextLine().strip();
                String pNumber = scan.nextLine().strip();
                String coPay = scan.nextLine().strip();
                String patientType = scan.nextLine().strip();
                String insuranceType = scan.nextLine().strip();
                String mdContact = scan.nextLine().strip();
                String mdPhone = scan.nextLine().strip();
                String allergyType = scan.nextLine().strip();
                String illnessType = scan.nextLine().strip();

                MedCond newMedCond = new MedCond(mdContact, mdPhone, allergyType, illnessType);

                PatientProf newPatientProf = new PatientProf(adminID, fName, lName, addr, pNumber,
                        Float.parseFloat(coPay), insuranceType, patientType, newMedCond);
                insertNewProfile_Init(newPatientProf);
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

    }

    public String extractString(String fInput){//it takes input as string and strips it off any spaces
        for(int j = 0; j < fInput.length(); j++){
            if(fInput.charAt(j) == ':')
                fInput = fInput.substring(j + 1, fInput.length()).strip();
        }
        return fInput;
    }

    public int getNumPatient(){return numPatient;}//returns the number of patients in the list
    public void setCurrentPatientIndex(int index){this.currentPatientIndex = index;}//sets the
                                                        //current index of the list
    public boolean checkAdminID(String cAdminID){//checks if the adminID inserted exist in the
                                                //database
        for(int i = 0; i < patientList.length; i++){
            if(patientList[i].getAdminID().equals(cAdminID))
                return true;
        }
        return false;
    }

    public int getCurrentPatientIndex() {//returns the current index of the list
        return currentPatientIndex;
    }
}
