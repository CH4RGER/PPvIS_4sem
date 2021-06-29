package org.bsuir.controller;

import org.bsuir.XMLParser.PatientsXMLReader;
import org.bsuir.model.PatientsTableModel;
import org.bsuir.view.Alert;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class LoadFromFileController {
    private final JFileChooser fileChooser;
    private final PatientsTableModel patientsTableModel;

    public LoadFromFileController(JFileChooser fileChooser, PatientsTableModel model) {
        this.fileChooser = fileChooser;
        this.patientsTableModel = model;
        addActionListener();
        fileChooser.showOpenDialog(null);
    }

    private void addActionListener() {
        fileChooser.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int actionTypeNumber = fileChooser.getApproveButtonMnemonic();
                    if (actionTypeNumber == JFileChooser.APPROVE_OPTION) {

                        PatientsXMLReader xmlReader = new PatientsXMLReader(fileChooser.getSelectedFile());

                        patientsTableModel.resetModel(xmlReader.readAll());
                    }
                } catch (IllegalArgumentException| SAXException| IOException  | ParserConfigurationException exception) {
                    Alert.incorrectFormatAlert();
                }
            }
        });
    }

}
