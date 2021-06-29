package org.bsuir.view;

import org.bsuir.controller.SearchPatientController;
import org.bsuir.model.PatientsTableModel;

public class SearchPatientView {

    public SearchPatientView(PatientsTableModel model) {
        SearchPatientBuilder searchPatientBuilder = new SearchPatientBuilder(model);
        new SearchPatientController(model, searchPatientBuilder.getDeleteButton(),
                searchPatientBuilder.getCardsTextFields(), searchPatientBuilder.getCardsLabelItems(),
                searchPatientBuilder.getCardsDatePanels(), searchPatientBuilder.getSearchByTypeComboBox(),
                searchPatientBuilder.getTable(), searchPatientBuilder.getPageButtonItems(),
                searchPatientBuilder.getPageSpinner(), searchPatientBuilder.getPageLabelItems(),
                searchPatientBuilder.getCards());
    }

}
