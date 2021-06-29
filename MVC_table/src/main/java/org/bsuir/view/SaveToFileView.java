package org.bsuir.view;

import org.bsuir.controller.SaveToFileController;
import org.bsuir.model.PatientsTableModel;

import javax.swing.*;

public class SaveToFileView {
    public SaveToFileView(PatientsTableModel model) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Save to");
        new SaveToFileController(fileChooser,model);
    }
}
