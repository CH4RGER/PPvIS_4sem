package org.bsuir.controller;

import org.bsuir.model.PatientsTableModel;
import org.bsuir.view.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrameController {

    /**
     * @see MenuBarBuilder#getMenuBarItems()
     */
    private final MenuItem[] menuItems;
    /**
     * @see PageComponentsBuilder#getButtonItems()
     */
    private final JButton[] buttonItems;
    /**
     * @see PageComponentsBuilder#getLabelItems()
     */
    private final JLabel[] labelItems;
    private final JSpinner pageSpinner;
    private final PatientsTableModel patientsTableModel;
    private final JTable table;

    public MainFrameController(PatientsTableModel model, MenuItem[] menuItems, JButton[] buttonItems,
                               JLabel[] labelItems, JSpinner pageSpinner, JTable table) {
        this.patientsTableModel = model;
        this.buttonItems = buttonItems;
        this.menuItems = menuItems;
        this.labelItems = labelItems;
        this.pageSpinner = pageSpinner;
        this.table = table;

        setMenuItemsController();
        setButtonItemsController();
        addPageSpinnerChangeListener();
        addModelDataChangedListener();
    }

    private void addModelDataChangedListener() {
        patientsTableModel.addTableModelListener(new TableModelListener() {
            @Override
            public void tableChanged(TableModelEvent e) {
                int newPageNumber = Integer.parseInt(labelItems[3].getText());
                updateComponents(newPageNumber);
            }
        });
    }


    private void addPageSpinnerChangeListener() {
        pageSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                try {
                    int newPageNumber = Integer.parseInt(labelItems[3].getText());
                    updateComponents(newPageNumber);
                } catch (ArrayIndexOutOfBoundsException exception) {
                    Alert.wrongPageAlert();
                }
            }
        });
    }

    private void updateComponents(int newPageNumber) throws ArrayIndexOutOfBoundsException {
        int amountOfNotesOnTheTable = getAmountOfNotesOnTheTable();
        int amountOfPages = (patientsTableModel.getRowCount() - 1) / amountOfNotesOnTheTable + 1;

        table.setModel(patientsTableModel.createPagedSubModel(newPageNumber, amountOfNotesOnTheTable));

        labelItems[1].setText("Page count: " + amountOfPages);
        labelItems[2].setText("Total record counter: " + patientsTableModel.getRowCount());
        labelItems[3].setText(String.valueOf(newPageNumber));
    }

    private void setButtonItemsController() {
        buttonItems[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateComponents(1);
                } catch (ArrayIndexOutOfBoundsException exception) {
                    Alert.wrongPageAlert();
                }
            }

        });

        buttonItems[1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int newPageNumber = Integer.parseInt(labelItems[3].getText()) - 1;
                    updateComponents(newPageNumber);
                } catch (ArrayIndexOutOfBoundsException exception) {
                    Alert.wrongPageAlert();
                }
            }
        });

        buttonItems[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int newPageNumber = Integer.parseInt(labelItems[3].getText()) + 1;
                    updateComponents(newPageNumber);
                } catch (ArrayIndexOutOfBoundsException exception) {
                    Alert.wrongPageAlert();
                }
            }
        });


        buttonItems[3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int amountOfNotesOnTheTable = getAmountOfNotesOnTheTable();

                    int newPageNumber = (patientsTableModel.getRowCount() - 1) / amountOfNotesOnTheTable + 1;
                    updateComponents(newPageNumber);

                } catch (ArrayIndexOutOfBoundsException exception) {
                    Alert.wrongPageAlert();
                }
            }
        });
    }

    private int getAmountOfNotesOnTheTable() {
        return (int) pageSpinner.getValue();
    }

    public void setMenuItemsController() {
        menuItems[0].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoadFromFileView(patientsTableModel);
            }
        });

        menuItems[1].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SaveToFileView(patientsTableModel);
            }
        });

        menuItems[2].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddPatientView(patientsTableModel);
            }
        });

        menuItems[3].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DeletePatientView(patientsTableModel);
            }
        });

        menuItems[4].addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchPatientView(patientsTableModel);
            }
        });
    }
}
