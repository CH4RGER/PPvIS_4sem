package org.bsuir.view;

import org.bsuir.controller.AddPatientController;
import org.bsuir.model.PatientsTableModel;

public class AddPatientView {

    public AddPatientView(PatientsTableModel model){
        AddPatientBuilder addPatientBuilder = new AddPatientBuilder();
        new AddPatientController(model,addPatientBuilder.getTextFields(), addPatientBuilder.getDatePanels(),
                addPatientBuilder.getEnterButton());
    }
}
