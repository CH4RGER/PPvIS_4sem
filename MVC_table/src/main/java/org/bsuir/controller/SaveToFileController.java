package org.bsuir.controller;

import org.bsuir.XMLParser.PatientsXMLWriter;
import org.bsuir.model.PatientsTableModel;
import org.bsuir.view.Alert;
import org.xml.sax.SAXException;

import javax.swing.*;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.text.ParseException;

public class SaveToFileController {
    private final JFileChooser fileChooser;
    private final PatientsTableModel patientsTableModel;

    public SaveToFileController(JFileChooser fileChooser, PatientsTableModel model) {
        this.fileChooser = fileChooser;
        this.patientsTableModel = model;
        addActionListener();
        fileChooser.showOpenDialog(null);
    }

    private void addActionListener() {
        fileChooser.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int actionTypeNumber = fileChooser.getApproveButtonMnemonic();
                if (actionTypeNumber == JFileChooser.OPEN_DIALOG) {
                    try {
                        PatientsXMLWriter xmlWriter = new PatientsXMLWriter(fileChooser.getSelectedFile());
                        xmlWriter.writeAll(patientsTableModel.getAllPatients());
                    } catch (IOException | ParseException | ParserConfigurationException | SAXException | TransformerException exception) {
                        Alert.unsuccessfulWriteToFileAlert();
                    }
                }
            }
        });
    }
}

