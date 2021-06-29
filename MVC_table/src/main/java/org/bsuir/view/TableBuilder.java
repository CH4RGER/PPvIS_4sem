package org.bsuir.view;

import org.bsuir.model.PatientsTableModel;

import javax.swing.*;
import java.awt.*;

public class TableBuilder {
    private final JTable table;
    private final JScrollPane tableScrollPane;

    public TableBuilder(PatientsTableModel model) {
        this.table = new JTable();
        this.tableScrollPane = new JScrollPane(table);


        setTableInfo(model);
        setScrollPane();
    }

    private void setScrollPane() {
        //tableScrollPane.setPreferredSize(new Dimension(700, 400));
    }

    private void setTableInfo(PatientsTableModel model) {
        table.setModel(model);
        table.getTableHeader().setFont(new Font("Segou UI", Font.BOLD, 12));
        table.getTableHeader().setBackground(new Color(132, 136, 203));
        table.getTableHeader().setForeground(new Color(205, 255, 255));
        table.setGridColor(new Color(100, 100, 100));
       // table.setPreferredSize(new Dimension(700, 200));
    }

    public JTable getTable() {
        return table;
    }

    public JScrollPane getTableScrollPane() {
        return tableScrollPane;
    }
}
