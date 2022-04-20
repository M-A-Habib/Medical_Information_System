package com.habib;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IPS_GUI {
    private JFrame main_frame;  //Each panels are created as private global vairables
    private JPanel main_panel;
    private JPanel create_Panel;
    private JPanel delete_Panel;
    private JPanel update_Panel;
    private JPanel find_Panel;
    private JPanel display_Panel;
    private JPanel delete_Success_Panel;
    private JPanel update_Cont_Panel;
    private JPanel find_Cont_Panel;
    private JPanel display_Cont_Panel;
    private JPanel update_Success_Panel;
    private JPanel find_unsuccess_Panel;
    private JPanel create_success_Panel;

    private JRadioButton createProfile;
    private JRadioButton deleteProfile;
    private JRadioButton updateProfile;
    private JRadioButton findProfile;
    private JRadioButton displayAllProfile;

    PatientProfInterface main_Interface = new PatientProfInterface("PatientFile_List_Updated.txt");

    public IPS_GUI(){
        main_frame = new JFrame(); //main frame

        main_frame.setTitle("IPS"); //sets the title for the main window
        main_frame.setSize(400, 400);

        main_panel = new JPanel();
        main_panel.setBounds(0, 0, 400, 400);
        create_Panel = new JPanel();
        create_profile_Panel(); //create panel function
        delete_Panel = new JPanel();
        delete_Profile_Panel(); //delete profile function
        update_Panel = new JPanel();
        update_Profile_Panel();  //update profile function
        find_Panel = new JPanel();
        find_Profile_Panel();  //find a single profile function
        display_Panel = new JPanel();
        display_All_Profile();  //display all the profile with the given adminID

        JLabel titleLabel = new JLabel("Integrated Patient System");
        titleLabel.setBounds(100, 10, 500, 40);

        //All the checkboxes in the main window
        createProfile = new JRadioButton("Create Profile"); //initializes every panel
        createProfile.setBounds(20, 50, 200, 40);
        deleteProfile = new JRadioButton("Delete Profile");
        deleteProfile.setBounds(20, 90, 200, 40);
        updateProfile = new JRadioButton("Update Profile");
        updateProfile.setBounds(20, 130, 200, 40);
        findProfile = new JRadioButton("Find/Display Profile");
        findProfile.setBounds(20, 170, 200, 40);
        displayAllProfile = new JRadioButton("Display all Profiles");
        displayAllProfile.setBounds(20, 210, 200, 40);

        ButtonGroup main_Buttons = new ButtonGroup();
        main_Buttons.add(createProfile);
        main_Buttons.add(deleteProfile);
        main_Buttons.add(updateProfile);
        main_Buttons.add(findProfile);
        main_Buttons.add(displayAllProfile);

        JButton selectButton = new JButton("Select");
        selectButton.setBounds(100, 300, 50, 20);

        main_panel.add(titleLabel);
        main_panel.add(createProfile);
        main_panel.add(deleteProfile);
        main_panel.add(updateProfile);
        main_panel.add(findProfile);
        main_panel.add(displayAllProfile);
        main_panel.add(selectButton);

        //create panel


        main_frame.setContentPane(main_panel);

        select_Button(selectButton);

        main_frame.setLayout(null);
        main_frame.setVisible(1==1);
    }

    private void select_Button(JButton buttonInput){ //this selects which panel to go to next depending on the
            //selected radio button
        buttonInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(createProfile.isSelected()){//list of the main panels that determines the functinality of the
                                //software
                    main_frame.remove(main_panel);
                    main_frame.setSize(400, 620);
                    main_frame.setContentPane(create_Panel);
                }
                else if(deleteProfile.isSelected()){
                    main_frame.remove(main_panel);
                    main_frame.setSize(400, 220);
                    main_frame.setContentPane(delete_Panel);
                }
                else if(updateProfile.isSelected()){
                    main_frame.remove(main_panel);
                    main_frame.setContentPane(update_Panel);
                }
                else if(findProfile.isSelected()){
                    main_frame.remove(main_panel);
                    main_frame.setContentPane(find_Panel);
                }
                else if(displayAllProfile.isSelected()){
                    main_frame.remove(main_panel);
                    main_frame.setContentPane(display_Panel);
                }
                main_frame.validate();
                main_frame.repaint();
            }
        });
    }

    private void create_profile_Panel(){//create the gui for create profile
        JLabel create_title = new JLabel("Create New Profile");
        create_title.setBounds(100, 10, 150, 20);
        create_Panel.add(create_title);

        JLabel adminId = new JLabel("Admin ID:");
        adminId.setBounds(10, 40, 80, 20);
        create_Panel.add(adminId);

        JLabel fName = new JLabel("First Name:");
        fName.setBounds(10, 80, 80, 20);
        create_Panel.add(fName);

        JLabel lName = new JLabel("Last Name:");
        lName.setBounds(10, 120, 80, 20);
        create_Panel.add(lName);

        JLabel address = new JLabel("Address:");
        address.setBounds(10, 160, 80, 20);
        create_Panel.add(address);

        JLabel phone = new JLabel("Phone:");
        phone.setBounds(10, 200, 80, 20);
        create_Panel.add(phone);

        JLabel copay = new JLabel("Co-Pay:");
        copay.setBounds(10, 240, 80, 20);
        create_Panel.add(copay);

        JLabel insu_Type = new JLabel("Insur. Type:");
        insu_Type.setBounds(10, 280, 80, 20);
        create_Panel.add(insu_Type);

        JLabel patient_Type = new JLabel("Patient Type:");
        patient_Type.setBounds(10, 320, 80, 20);
        create_Panel.add(patient_Type);

        JLabel mdContact = new JLabel("Md Contact:");
        mdContact.setBounds(10, 360, 80, 20);
        create_Panel.add(mdContact);

        JLabel mdPhone = new JLabel("Md Phone:");
        mdPhone.setBounds(10, 400, 80, 20);
        create_Panel.add(mdPhone);

        JLabel allergies = new JLabel("Allergies:");
        allergies.setBounds(10, 440, 80, 20);
        create_Panel.add(allergies);

        JLabel illness = new JLabel("Illness:");
        illness.setBounds(10, 480, 80, 20);
        create_Panel.add(illness);

        JTextField adminID_Text = new JTextField();
        adminID_Text.setBounds(100, 40, 100, 20);
        create_Panel.add(adminID_Text);

        JTextField fName_Text = new JTextField();
        fName_Text.setBounds(100, 80, 100, 20);
        create_Panel.add(fName_Text);

        JTextField lName_Text = new JTextField();
        lName_Text.setBounds(100, 120, 100, 20);
        create_Panel.add(lName_Text);

        JTextField address_Text = new JTextField();
        address_Text.setBounds(100, 160, 100, 20);
        create_Panel.add(address_Text);

        JTextField phone_Text = new JTextField();
        phone_Text.setBounds(100, 200, 100, 20);
        create_Panel.add(phone_Text);

        JTextField copay_Text = new JTextField();
        copay_Text.setBounds(100, 240, 100, 20);
        create_Panel.add(copay_Text);

        String[] insurance_List = {"None", "Private", "Government"};
        JComboBox insurance_Type = new JComboBox(insurance_List);
        insurance_Type.setBounds(100, 280, 100, 20);
        create_Panel.add(insurance_Type);

        String[] patient_List = {"None", "Adult", "Senior"};
        JComboBox patient_Type_Drop = new JComboBox(patient_List);
        patient_Type_Drop.setBounds(100, 320, 100, 20);
        create_Panel.add(patient_Type_Drop);

        JTextField mdcontact_Text = new JTextField();
        mdcontact_Text.setBounds(100, 360, 100, 20);
        create_Panel.add(mdcontact_Text);

        JTextField mdphone_Text = new JTextField();
        mdphone_Text.setBounds(100, 400, 100, 20);
        create_Panel.add(mdphone_Text);

        String[] allergy_List = {"None", "Food", "Medication", "Other"};
        JComboBox allergy_Drop = new JComboBox(allergy_List);
        allergy_Drop.setBounds(100, 440, 100, 20);
        create_Panel.add(allergy_Drop);

        String[] illness_List = {"None", "CHD", "Diabetes"};
        JComboBox illness_Drop = new JComboBox(illness_List);
        illness_Drop.setBounds(100, 480, 100, 20);
        create_Panel.add(illness_Drop);

        JButton submit_Button = new JButton("Submit");
        submit_Button.setBounds(100, 520, 50, 20);
        create_Panel.add(submit_Button);
//end of Primary GUI
//        JLabel success_Label = new JLabel();
//        success_Label.setBounds(100, 600, 50, 20);
//        create_Panel.add(success_Label);

        home_Button_func(create_Panel, 100, 560, 50, 20);

        submit_Button.addActionListener(new ActionListener() {//submit button creates the profile
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setSize(400, 400);
                MedCond newMedcond = main_Interface.createNewMedCond(mdcontact_Text.getText(), mdphone_Text.getText(),
                        allergy_Drop.getSelectedItem().toString(), illness_Drop.getSelectedItem().toString());
                //uses part 1 to create a profile and update the database
                main_Interface.createNewPatientProf(adminID_Text.getText(), fName_Text.getText(),
                        lName_Text.getText(), address_Text.getText(), phone_Text.getText(),
                        Float.parseFloat(copay_Text.getText()), insurance_Type.getSelectedItem().toString(),
                        patient_Type_Drop.getSelectedItem().toString(), newMedcond);

                create_success_Panel = new JPanel();//panel to display the success message after creating a profile

                JLabel title_Label = create_title;
                title_Label.setBounds(100, 10, 150, 20);
                create_success_Panel.add(title_Label);

                JLabel success_Message = new JLabel("Profile created");//success message
                success_Message.setBounds(100, 50, 150, 20);
                create_success_Panel.add(success_Message);

                JButton ok_Button = new JButton("OK");
                ok_Button.setBounds(100, 90, 50, 20);
                create_success_Panel.add(ok_Button);

                ok_Button.addActionListener(new ActionListener() { //once in the success message, pressing ok
                    //will bring back to the main panel
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_frame.remove(create_success_Panel);
                        main_frame.setContentPane(main_panel);
                        main_frame.repaint();
                    }
                });

                create_success_Panel.setLayout(null);

                main_frame.remove(create_Panel);
                main_frame.setContentPane(create_success_Panel);
                main_frame.repaint();
                main_frame.validate();

                //success_Label.setText("Success");
            }
        });

        create_Panel.setLayout(null);
    }

    private void delete_Profile_Panel(){//delete profile panel
        JLabel title_Label = new JLabel("Delete Profile");
        title_Label.setBounds(100, 10, 100, 20);
        delete_Panel.add(title_Label);

        JLabel adminID = new JLabel("Admin ID:");
        adminID.setBounds(10, 40, 100, 20);
        delete_Panel.add(adminID);

        JLabel lName = new JLabel("Last Name:");
        lName.setBounds(10, 80, 100, 20);
        delete_Panel.add(lName);

        JTextField adminID_Text = new JTextField();
        adminID_Text.setBounds(90, 40, 100, 20);
        delete_Panel.add(adminID_Text);

        JTextField lName_Text = new JTextField();
        lName_Text.setBounds(90, 80, 100, 20);
        delete_Panel.add(lName_Text);

        JButton submit_Button = new JButton("Delete");
        submit_Button.setBounds(100, 120, 50, 20);
        delete_Panel.add(submit_Button);

        home_Button_func(delete_Panel, 100, 150, 50, 20);

        //end of primary GUI

        submit_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                delete_Success_Panel = new JPanel();
                main_frame.setSize(400, 200);

                delete_Success_Panel.add(title_Label);

                JLabel success_Label = new JLabel("Profile Deleted!");
                success_Label.setBounds(100, 40, 100, 20);
                delete_Success_Panel.add(success_Label);

                JButton ok_Button = new JButton("OK");
                ok_Button.setBounds(100, 120, 50, 20);
                delete_Success_Panel.add(ok_Button);

                if(main_Interface.findProfile(adminID_Text.getText(), lName_Text.getText()).getFirstName().equals("unknown") && main_Interface.findProfile(adminID_Text.getText(), lName_Text.getText()).getLastname().equals("unknown"))
                    find_unsuccess_panel_func(title_Label, update_Panel);
                else {
                    main_Interface.deletePatientProf(adminID_Text.getText(), lName_Text.getText());
                    delete_Success_Panel.setLayout(null);
                    main_frame.remove(delete_Panel);
                    main_frame.setContentPane(delete_Success_Panel);
                    main_frame.repaint();
                    main_frame.validate();
                }

//                ok_Button.addActionListener(new ActionListener() {
//                    @Override
//                    public void actionPerformed(ActionEvent e) {
//                        main_frame.setSize(400, 400);
//                        main_frame.remove(delete_Success_Panel);
//                        main_frame.setContentPane(main_panel);
//                        main_frame.repaint();
//                        main_frame.validate();
//                    }
//                });
                home_Button_func(ok_Button, delete_Success_Panel);
            }
        });

        delete_Panel.setLayout(null);
    }

    private void find_Profile_Panel(){//find profile panel setup
        JLabel title_Label = new JLabel("Find Profile");
        title_Label.setBounds(100, 10, 100, 20);
        find_Panel.add(title_Label);

        JLabel adminID = new JLabel("Admin ID:");
        adminID.setBounds(10, 40, 100, 20);
        find_Panel.add(adminID);

        JLabel lName = new JLabel("Last Name:");
        lName.setBounds(10, 80, 100, 20);
        find_Panel.add(lName);

        JTextField adminID_Text = new JTextField();
        adminID_Text.setBounds(90, 40, 100, 20);
        find_Panel.add(adminID_Text);

        JTextField lName_Text = new JTextField();
        lName_Text.setBounds(90, 80, 100, 20);
        find_Panel.add(lName_Text);

        JButton find_Button = new JButton("Find");
        find_Button.setBounds(100, 120, 50, 20);
        find_Panel.add(find_Button);

        home_Button_func(find_Panel, 100, 150, 50, 20);
//end of primary GUI
        find_Button.addActionListener(new ActionListener() { //find button will find it and display if found
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setSize(400, 600);
                find_Cont_Panel = new JPanel();

                PatientProf curPatient = main_Interface.findProfile(adminID_Text.getText(), lName_Text.getText());

                JLabel title_Label_cont = new JLabel("Profile Details");
                title_Label_cont.setBounds(100, 10, 100, 20);
                find_Cont_Panel.add(title_Label_cont);

                JLabel adminId_cont = new JLabel("Admin ID:");
                adminId_cont.setBounds(10, 40, 80, 20);
                find_Cont_Panel.add(adminId_cont);

                JLabel fName_cont = new JLabel("First Name:");
                fName_cont.setBounds(10, 80, 80, 20);
                find_Cont_Panel.add(fName_cont);

                JLabel lName_cont = new JLabel("Last Name:");
                lName_cont.setBounds(10, 120, 80, 20);
                find_Cont_Panel.add(lName_cont);

                JLabel address_cont = new JLabel("Address:");
                address_cont.setBounds(10, 160, 80, 20);
                find_Cont_Panel.add(address_cont);

                JLabel phone_cont = new JLabel("Phone:");
                phone_cont.setBounds(10, 200, 80, 20);
                find_Cont_Panel.add(phone_cont);

                JLabel copay_cont = new JLabel("Co-Pay:");
                copay_cont.setBounds(10, 240, 80, 20);
                find_Cont_Panel.add(copay_cont);

                JLabel insu_Type_cont = new JLabel("Insur. Type:");
                insu_Type_cont.setBounds(10, 280, 80, 20);
                find_Cont_Panel.add(insu_Type_cont);

                JLabel patient_Type_cont = new JLabel("Patient Type:");
                patient_Type_cont.setBounds(10, 320, 100, 20);
                find_Cont_Panel.add(patient_Type_cont);

                JLabel mdContact_cont = new JLabel("Md Contact:");
                mdContact_cont.setBounds(10, 360, 80, 20);
                find_Cont_Panel.add(mdContact_cont);

                JLabel mdPhone_cont = new JLabel("Md Phone:");
                mdPhone_cont.setBounds(10, 400, 80, 20);
                find_Cont_Panel.add(mdPhone_cont);

                JLabel allergies_cont = new JLabel("Allergies:");
                allergies_cont.setBounds(10, 440, 80, 20);
                find_Cont_Panel.add(allergies_cont);

                JLabel illness_cont = new JLabel("Illness:");
                illness_cont.setBounds(10, 480, 80, 20);
                find_Cont_Panel.add(illness_cont);

                JLabel adminId_cont_text = new JLabel(curPatient.getAdminID());
                adminId_cont_text.setBounds(100, 40, 80, 20);
                find_Cont_Panel.add(adminId_cont_text);

                JLabel fName_cont_text = new JLabel(curPatient.getFirstName());
                fName_cont_text.setBounds(100, 80, 80, 20);
                find_Cont_Panel.add(fName_cont_text);

                JLabel lName_cont_text = new JLabel(curPatient.getLastname());
                lName_cont_text.setBounds(100, 120, 80, 20);
                find_Cont_Panel.add(lName_cont_text);

                JLabel address_cont_text = new JLabel(curPatient.getAddress());
                address_cont_text.setBounds(100, 160, 200, 20);
                find_Cont_Panel.add(address_cont_text);

                JLabel phone_cont_text = new JLabel(curPatient.getPhone());
                phone_cont_text.setBounds(100, 200, 80, 20);
                find_Cont_Panel.add(phone_cont_text);

                JLabel copay_cont_text = new JLabel(Float.toString(curPatient.getCoPay()));
                copay_cont_text.setBounds(100, 240, 80, 20);
                find_Cont_Panel.add(copay_cont_text);

                JLabel insu_Type_cont_text = new JLabel(curPatient.getInsuType());
                insu_Type_cont_text.setBounds(100, 280, 80, 20);
                find_Cont_Panel.add(insu_Type_cont_text);

                JLabel patient_Type_cont_text = new JLabel(curPatient.getPatientType());
                patient_Type_cont_text.setBounds(100, 320, 100, 20);
                find_Cont_Panel.add(patient_Type_cont_text);

                JLabel mdContact_cont_text = new JLabel(curPatient.getMedCondInfo().getMdContact());
                mdContact_cont_text.setBounds(100, 360, 80, 20);
                find_Cont_Panel.add(mdContact_cont_text);

                JLabel mdPhone_cont_text = new JLabel(curPatient.getMedCondInfo().getMdPhone());
                mdPhone_cont_text.setBounds(100, 400, 80, 20);
                find_Cont_Panel.add(mdPhone_cont_text);

                JLabel allergies_cont_text = new JLabel(curPatient.getMedCondInfo().getAlgType());
                allergies_cont_text.setBounds(100, 440, 80, 20);
                find_Cont_Panel.add(allergies_cont_text);

                JLabel illness_cont_text = new JLabel(curPatient.getMedCondInfo().getIllType());
                illness_cont_text.setBounds(100, 480, 80, 20);
                find_Cont_Panel.add(illness_cont_text);

                JButton ok_Button = new JButton("OK");
                ok_Button.setBounds(100, 520, 50, 20);
                find_Cont_Panel.add(ok_Button);

                if(curPatient.getFirstName().equals("unknown") && curPatient.getLastname().equals("unknown"))
                    find_unsuccess_panel_func(title_Label, display_Panel);//if the profile is not found then display a
                //error message
                else {
                    find_Cont_Panel.setLayout(null);
                    main_frame.remove(find_Panel);
                    main_frame.setContentPane(find_Cont_Panel);
                    main_frame.repaint();
                    main_frame.validate();
                }

                ok_Button.addActionListener(new ActionListener() {//ok button goes back
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_frame.remove(find_Cont_Panel);
                        main_frame.setContentPane(main_panel);
                        main_frame.repaint();
                        main_frame.validate();
                    }
                });
            }
        });

        find_Panel.setLayout(null);
    }

    private void update_Profile_Panel(){//update profile panel
        JLabel title_Label = new JLabel("Update Profile");
        title_Label.setBounds(100, 10, 100, 20);
        update_Panel.add(title_Label);

        JLabel adminID = new JLabel("Admin ID:");
        adminID.setBounds(10, 40, 100, 20);
        update_Panel.add(adminID);

        JLabel lName = new JLabel("Last Name:");
        lName.setBounds(10, 80, 100, 20);
        update_Panel.add(lName);

        JLabel update_Field = new JLabel("Update Field:");
        update_Field.setBounds(10, 120, 100, 20);
        update_Panel.add(update_Field);

        JTextField adminID_Text = new JTextField();
        adminID_Text.setBounds(100, 40, 120, 20);
        update_Panel.add(adminID_Text);

        JTextField lName_Text = new JTextField();
        lName_Text.setBounds(100, 80, 120, 20);
        update_Panel.add(lName_Text);

        String[] update_List = {"Select", "Address", "Phone", "Insurance", "CoPay",
                "Patient Type", "MD Contact", "MD Phone", "Illness", "Allergy"};
        JComboBox update_Field_Drop = new JComboBox(update_List);
        update_Field_Drop.setBounds(100, 120, 120, 20);
        update_Panel.add(update_Field_Drop);

        JButton find_Button = new JButton("Find");
        find_Button.setBounds(100, 150, 50, 20);
        update_Panel.add(find_Button);

        home_Button_func(update_Panel, 100, 190, 50, 20);
        //end of primary gui

        find_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                update_Cont_Panel = new JPanel();

                JLabel title_Label_cont = new JLabel("Update Profile");
                title_Label_cont.setBounds(100, 10, 100, 20);
                update_Cont_Panel.add(title_Label_cont);

                JLabel adminID_cont = new JLabel("Admin ID:");
                adminID_cont.setBounds(10, 40, 100, 20);
                update_Cont_Panel.add(adminID_cont);

                JLabel lName_cont = new JLabel("Last Name:");
                lName_cont.setBounds(10, 80, 100, 20);
                update_Cont_Panel.add(lName_cont);

                JLabel update_Field_cont = new JLabel(update_Field_Drop.getSelectedItem().toString() + ":");
                update_Field_cont.setBounds(10, 120, 100, 20);
                update_Cont_Panel.add(update_Field_cont);

                JLabel adminID_Label = new JLabel(adminID_Text.getText());
                adminID_Label.setBounds(100, 40, 120, 20);
                update_Cont_Panel.add(adminID_Label);

                JLabel lName_Label = new JLabel(lName_Text.getText());
                lName_Label.setBounds(100, 80, 120, 20);
                update_Cont_Panel.add(lName_Label);

                JTextField update_Field_Text = new JTextField();
                update_Field_Text.setBounds(100, 120, 120, 20);

                String[] insurance_drop_List = {"None", "Private", "Government"};
                JComboBox insurance_Drop = new JComboBox(insurance_drop_List);
                insurance_Drop.setBounds(100, 120, 120, 20);

                String[] patient_type_list = {"None", "Adult", "Senior"};
                JComboBox patient_type_Drop = new JComboBox(patient_type_list);
                patient_type_Drop.setBounds(100, 120, 120, 20);

                String[] allergy_List = {"None", "Food", "Medication", "Other"};
                JComboBox allergy_Drop = new JComboBox(allergy_List);
                allergy_Drop.setBounds(100, 120, 120, 20);

                String[] illness_List = {"None", "CHD", "Diabetes"};
                JComboBox illness_Drop = new JComboBox(illness_List);
                illness_Drop.setBounds(100, 120, 120, 20);

                if(update_Field_Drop.getSelectedItem().toString().equals("Insurance")){//if the field has drop
                    //down menu then in the update it shows the drop down menu
                    update_Cont_Panel.add(insurance_Drop);
                }
                else if(update_Field_Drop.getSelectedItem().toString().equals("Patient Type")){
                    update_Cont_Panel.add(patient_type_Drop);
                }
                else if(update_Field_Drop.getSelectedItem().toString().equals("Illness")){
                    update_Cont_Panel.add(illness_Drop);
                }
                else if(update_Field_Drop.getSelectedItem().toString().equals("Allergy")){
                    update_Cont_Panel.add(allergy_Drop);
                }
                else{
                    update_Cont_Panel.add(update_Field_Text);
                }

                JButton update_Button = new JButton("Update");
                update_Button.setBounds(100, 150, 80, 20);
                update_Cont_Panel.add(update_Button);

                JButton back_Button = new JButton("Back");
                back_Button.setBounds(100, 180, 80, 20);
                update_Cont_Panel.add(back_Button);

                if(main_Interface.findProfile(adminID_Text.getText(), lName_Text.getText()).getFirstName().equals("unknown") && main_Interface.findProfile(adminID_Text.getText(), lName_Text.getText()).getLastname().equals("unknown"))
                    find_unsuccess_panel_func(title_Label, update_Panel);
                else {
                    update_Cont_Panel.setLayout(null);
                    main_frame.remove(update_Panel);
                    main_frame.setContentPane(update_Cont_Panel);
                    main_frame.repaint();
                    main_frame.validate();
                }

                back_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_frame.remove(update_Cont_Panel);
                        main_frame.setContentPane(update_Panel);
                        main_frame.repaint();
                    }
                });

                update_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String update_String;
                        if(update_Field_Drop.getSelectedItem().toString().equals("Insurance")){
                            update_String = insurance_Drop.getSelectedItem().toString();
                        }
                        else if(update_Field_Drop.getSelectedItem().toString().equals("Patient Type")){
                            update_String = patient_type_Drop.getSelectedItem().toString();
                        }
                        else if(update_Field_Drop.getSelectedItem().toString().equals("Illness")){
                            update_String = illness_Drop.getSelectedItem().toString();
                        }
                        else if(update_Field_Drop.getSelectedItem().toString().equals("Allergy")){
                            update_String = allergy_Drop.getSelectedItem().toString();
                        }
                        else {
                            update_String = update_Field_Text.getText();
                        }

                        main_Interface.updatePatientProf(update_Field_Drop.getSelectedItem().toString(),
                                lName_Text.getText(), update_String, adminID_Text.getText());

                        update_Success_Panel = new JPanel();
                        main_frame.setSize(400, 200);

                        update_Success_Panel.add(title_Label);

                        JLabel success_Label = new JLabel("Profile Updated!");
                        success_Label.setBounds(100, 40, 100, 20);
                        update_Success_Panel.add(success_Label);

                        JButton ok_Button = new JButton("OK");
                        ok_Button.setBounds(100, 120, 50, 20);
                        update_Success_Panel.add(ok_Button);

                        home_Button_func(ok_Button, update_Success_Panel);

                        update_Success_Panel.setLayout(null);
                        main_frame.remove(update_Cont_Panel);
                        main_frame.setContentPane(update_Success_Panel);
                        main_frame.repaint();
                        main_frame.validate();
                    }
                });
            }
        });

        update_Panel.setLayout(null);
    }

    private void display_All_Profile(){//display all the profiles
        JLabel title_Label = new JLabel("Display All Profiles");
        title_Label.setBounds(100, 10, 200, 20);
        display_Panel.add(title_Label);

        JLabel adminID = new JLabel("Admin ID:");
        adminID.setBounds(10, 40, 100, 20);
        display_Panel.add(adminID);

        JTextField adminID_Text = new JTextField();
        adminID_Text.setBounds(90, 40, 100, 20);
        display_Panel.add(adminID_Text);

        JButton submit_Button = new JButton("Submit");
        submit_Button.setBounds(100, 80, 50, 20);
        display_Panel.add(submit_Button);

        home_Button_func(display_Panel, 100, 120, 50, 20);

        submit_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                display_Cont_Panel = new JPanel();

                main_frame.setSize(400, 600);
                //find_Cont_Panel = new JPanel();

                main_Interface.resetPatientIndex();
                PatientProf curPatient = main_Interface.findNextProfile(adminID_Text.getText());

                JLabel title_Label_cont = new JLabel("Profile Details");
                title_Label_cont.setBounds(100, 10, 100, 20);
                display_Cont_Panel.add(title_Label_cont);

                JLabel adminId_cont = new JLabel("Admin ID:");
                adminId_cont.setBounds(10, 40, 80, 20);
                display_Cont_Panel.add(adminId_cont);

                JLabel fName_cont = new JLabel("First Name:");
                fName_cont.setBounds(10, 80, 80, 20);
                display_Cont_Panel.add(fName_cont);

                JLabel lName_cont = new JLabel("Last Name:");
                lName_cont.setBounds(10, 120, 80, 20);
                display_Cont_Panel.add(lName_cont);

                JLabel address_cont = new JLabel("Address:");
                address_cont.setBounds(10, 160, 80, 20);
                display_Cont_Panel.add(address_cont);

                JLabel phone_cont = new JLabel("Phone:");
                phone_cont.setBounds(10, 200, 80, 20);
                display_Cont_Panel.add(phone_cont);

                JLabel copay_cont = new JLabel("Co-Pay:");
                copay_cont.setBounds(10, 240, 80, 20);
                display_Cont_Panel.add(copay_cont);

                JLabel insu_Type_cont = new JLabel("Insur. Type:");
                insu_Type_cont.setBounds(10, 280, 80, 20);
                display_Cont_Panel.add(insu_Type_cont);

                JLabel patient_Type_cont = new JLabel("Patient Type:");
                patient_Type_cont.setBounds(10, 320, 100, 20);
                display_Cont_Panel.add(patient_Type_cont);

                JLabel mdContact_cont = new JLabel("Md Contact:");
                mdContact_cont.setBounds(10, 360, 80, 20);
                display_Cont_Panel.add(mdContact_cont);

                JLabel mdPhone_cont = new JLabel("Md Phone:");
                mdPhone_cont.setBounds(10, 400, 80, 20);
                display_Cont_Panel.add(mdPhone_cont);

                JLabel allergies_cont = new JLabel("Allergies:");
                allergies_cont.setBounds(10, 440, 80, 20);
                display_Cont_Panel.add(allergies_cont);

                JLabel illness_cont = new JLabel("Illness:");
                illness_cont.setBounds(10, 480, 80, 20);
                display_Cont_Panel.add(illness_cont);

                JLabel adminId_cont_text = new JLabel(curPatient.getAdminID());
                adminId_cont_text.setBounds(100, 40, 80, 20);
                display_Cont_Panel.add(adminId_cont_text);

                JLabel fName_cont_text = new JLabel(curPatient.getFirstName());
                fName_cont_text.setBounds(100, 80, 80, 20);
                display_Cont_Panel.add(fName_cont_text);

                JLabel lName_cont_text = new JLabel(curPatient.getLastname());
                lName_cont_text.setBounds(100, 120, 80, 20);
                display_Cont_Panel.add(lName_cont_text);

                JLabel address_cont_text = new JLabel(curPatient.getAddress());
                address_cont_text.setBounds(100, 160, 200, 20);
                display_Cont_Panel.add(address_cont_text);

                JLabel phone_cont_text = new JLabel(curPatient.getPhone());
                phone_cont_text.setBounds(100, 200, 80, 20);
                display_Cont_Panel.add(phone_cont_text);

                JLabel copay_cont_text = new JLabel(Float.toString(curPatient.getCoPay()));
                copay_cont_text.setBounds(100, 240, 80, 20);
                display_Cont_Panel.add(copay_cont_text);

                JLabel insu_Type_cont_text = new JLabel(curPatient.getInsuType());
                insu_Type_cont_text.setBounds(100, 280, 80, 20);
                display_Cont_Panel.add(insu_Type_cont_text);

                JLabel patient_Type_cont_text = new JLabel(curPatient.getPatientType());
                patient_Type_cont_text.setBounds(100, 320, 100, 20);
                display_Cont_Panel.add(patient_Type_cont_text);

                JLabel mdContact_cont_text = new JLabel(curPatient.getMedCondInfo().getMdContact());
                mdContact_cont_text.setBounds(100, 360, 80, 20);
                display_Cont_Panel.add(mdContact_cont_text);

                JLabel mdPhone_cont_text = new JLabel(curPatient.getMedCondInfo().getMdPhone());
                mdPhone_cont_text.setBounds(100, 400, 80, 20);
                display_Cont_Panel.add(mdPhone_cont_text);

                JLabel allergies_cont_text = new JLabel(curPatient.getMedCondInfo().getAlgType());
                allergies_cont_text.setBounds(100, 440, 80, 20);
                display_Cont_Panel.add(allergies_cont_text);

                JLabel illness_cont_text = new JLabel(curPatient.getMedCondInfo().getIllType());
                illness_cont_text.setBounds(100, 480, 80, 20);
                display_Cont_Panel.add(illness_cont_text);

                JButton next_Button = new JButton("Next");
                next_Button.setBounds(100, 520, 80, 20);
                display_Cont_Panel.add(next_Button);

                JButton back_Button = new JButton("Back");
                back_Button.setBounds(100, 550, 80, 20);
                display_Cont_Panel.add(back_Button);

                //end of primary gui

                if(curPatient.getFirstName().equals("unknown") && curPatient.getLastname().equals("unknown"))
                    find_unsuccess_panel_func(title_Label, display_Panel); //if the profile is not found display not found
                else {
                    display_Cont_Panel.setLayout(null);
                    main_frame.remove(display_Panel);
                    main_frame.setContentPane(display_Cont_Panel);
                    main_frame.repaint();
                    main_frame.validate();
                }

                back_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        main_frame.remove(display_Cont_Panel);
                        main_frame.setContentPane(display_Panel);
                        main_frame.repaint();
                    }
                });

                next_Button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        PatientProf nextPatient = main_Interface.findNextProfile(adminID_Text.getText());

                        if(nextPatient.getFirstName().equals("unknown") && nextPatient.getLastname().equals("unknown"))
                            find_unsuccess_panel_func(title_Label, display_Panel, "Error 404: No Remaining profile to display");
                        else {//display error message when the end of file reached
                            fName_cont_text.setText(nextPatient.getFirstName());
                            lName_cont_text.setText(nextPatient.getLastname());
                            address_cont_text.setText(nextPatient.getAddress());
                            phone_cont_text.setText(nextPatient.getPhone());
                            copay_cont_text.setText(Float.toString(nextPatient.getCoPay()));
                            insu_Type_cont_text.setText(nextPatient.getInsuType());
                            patient_Type_cont_text.setText(nextPatient.getPatientType());
                            mdContact_cont_text.setText(nextPatient.getMedCondInfo().getMdContact());
                            mdPhone_cont_text.setText(nextPatient.getMedCondInfo().getMdPhone());
                            allergies_cont_text.setText(nextPatient.getMedCondInfo().getAlgType());
                            illness_cont_text.setText(nextPatient.getMedCondInfo().getIllType());
                        }
                    }
                });
            }
        });

        display_Panel.setLayout(null);
    }

    private void home_Button_func(JButton home_Button_inp, JPanel panel_inp){
        home_Button_inp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setSize(400, 400);
                main_frame.remove(panel_inp);
                main_frame.setContentPane(main_panel);
                main_frame.repaint();
            }
        });
    }

    private void home_Button_func(JPanel panel_inp, int x, int y, int width, int height){
        JButton home_Button = new JButton("Home");
        home_Button.setBounds(x, y, width, height);
        panel_inp.add(home_Button);

        home_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.setSize(400, 400);
                main_frame.remove(panel_inp);
                main_frame.setContentPane(main_panel);
                main_frame.repaint();
            }
        });
    }

    private void find_unsuccess_panel_func(JLabel panel_Title, JPanel curPanel){//unsuccessful panel function creates
        //
        find_unsuccess_Panel = new JPanel();

        JLabel title_Label = panel_Title;
        title_Label.setBounds(100, 10, 200, 20);
        find_unsuccess_Panel.add(title_Label);

        JLabel message_Label = new JLabel("Error 404 : Patient not found!");
        message_Label.setBounds(100, 50, 300, 20);
        find_unsuccess_Panel.add(message_Label);

        JButton ok_Button = new JButton("OK");
        ok_Button.setBounds(100, 90, 50, 20);
        find_unsuccess_Panel.add(ok_Button);

        find_unsuccess_Panel.setLayout(null);
        main_frame.setSize(400, 400);

        main_frame.remove(curPanel);
        main_frame.setContentPane(find_unsuccess_Panel);
        main_frame.repaint();
        main_frame.validate();

        ok_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.remove(find_unsuccess_Panel);
                main_frame.setContentPane(main_panel);
                main_frame.repaint();
            }
        });
    }

    private void find_unsuccess_panel_func(JLabel panel_Title, JPanel curPanel, String message){//this one displays a custom message
        find_unsuccess_Panel = new JPanel();

        JLabel title_Label = panel_Title;
        title_Label.setBounds(100, 10, 200, 20);
        find_unsuccess_Panel.add(title_Label);

        JLabel message_Label = new JLabel(message);
        message_Label.setBounds(100, 50, 300, 20);
        find_unsuccess_Panel.add(message_Label);

        JButton ok_Button = new JButton("OK");
        ok_Button.setBounds(100, 90, 50, 20);
        find_unsuccess_Panel.add(ok_Button);

        find_unsuccess_Panel.setLayout(null);
        main_frame.setSize(400, 400);

        main_frame.remove(curPanel);
        main_frame.setContentPane(find_unsuccess_Panel);
        main_frame.repaint();
        main_frame.validate();

        ok_Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                main_frame.remove(find_unsuccess_Panel);
                main_frame.setContentPane(main_panel);
                main_frame.repaint();
            }
        });
    }
}
