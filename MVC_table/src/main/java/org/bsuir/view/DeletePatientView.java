package org.bsuir.view;

import org.bsuir.controller.DeletePatientController;
import org.bsuir.model.PatientsTableModel;

public class DeletePatientView {
    public DeletePatientView(PatientsTableModel model) {
        DeletePatientBuilder deletePatientBuilder = new DeletePatientBuilder();
        new DeletePatientController(model, deletePatientBuilder.getDeleteButton(),
                deletePatientBuilder.getTextFields(), deletePatientBuilder.getLabelItems(),
                deletePatientBuilder.getDatePanels(), deletePatientBuilder.getDeleteByTypeComboBox(),
                deletePatientBuilder.getCards());
    }
}
