package org.bsuir.controller;

import org.bsuir.model.DateManager;
import org.bsuir.model.PatientsTableModel;
import org.bsuir.model.Patient;
import org.bsuir.view.Alert;
import org.bsuir.view.DeletePatientBuilder;
import org.jdatepicker.impl.JDatePanelImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.util.Date;

public class AddPatientController {
    private final PatientsTableModel patientsTableModel;
    private Patient patient;
    /**
     * @see DeletePatientBuilder#getTextFields()
     */
    private final JTextField[] textFields;
    /**
     * @see DeletePatientBuilder#getDatePanels()
     */
    private final JDatePanelImpl[] datePanels;
    private final JButton enterButton;

    public AddPatientController(PatientsTableModel model, JTextField[] textFields,
                                JDatePanelImpl[] datePanels, JButton enterButton) {
        this.patientsTableModel = model;
        this.textFields = textFields;
        this.datePanels = datePanels;
        this.enterButton = enterButton;
        setEnterButtonAction();
    }

    private void setEnterButtonAction() {
        enterButton.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                getInformation();

                if(informationCorrect()) {
                    addPatientToModel();
                    SwingUtilities.getWindowAncestor(enterButton).dispose();
                    Alert.successfulAddingAlert();
                }
            }
        });
    }

    private void addPatientToModel() {
        patientsTableModel.addPatient(patient);
    }


    private boolean informationCorrect() {
        for (JTextField textField : textFields) {
            if (textField.getText().equals("")) {
                Alert.unsuccessfulAddingAlert("Fill all text information");
                return false;
            }
        }
        for (JDatePanelImpl datePanel : datePanels) {
            if (datePanel.getModel().getValue() == null) {
                Alert.unsuccessfulAddingAlert("Fill all date information");
                return false;
            }
        }
        return true;
    }

    private void getInformation() {
        String fullName = textFields[0].getText();
        String placeOfResidence = textFields[1].getText();
        DateManager birthdayManager = new DateManager((Date) datePanels[0].getModel().getValue());
        DateManager dateOfReceiptManager = new DateManager((Date) datePanels[1].getModel().getValue());
        String doctorsFullName = textFields[2].getText();
        String conclusion = textFields[3].getText();
        patient = new Patient(fullName, placeOfResidence, birthdayManager,
                dateOfReceiptManager, doctorsFullName, conclusion);
    }
}
