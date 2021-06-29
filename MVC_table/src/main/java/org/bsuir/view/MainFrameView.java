package org.bsuir.view;

import org.bsuir.controller.MainFrameController;
import org.bsuir.model.PatientsTableModel;


public class MainFrameView {

    public MainFrameView() {
        PatientsTableModel patientsTableModel = new PatientsTableModel();
        MainFrameBuilder frameBuilder = new MainFrameBuilder(patientsTableModel);

        new MainFrameController(patientsTableModel,frameBuilder.getMenuBarItems(),frameBuilder.getButtonItems(),
                frameBuilder.getLabelItems(), frameBuilder.getPageSpinner(), frameBuilder.getTable());

    }

}