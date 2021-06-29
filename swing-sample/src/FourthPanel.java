package src;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class FourthPanel {
    private final JPanel panel;
    private final JTextField textField;
    private final JCheckBox CheckBox1;
    private final JCheckBox CheckBox2;
    private final JCheckBox CheckBox3;

    public FourthPanel() {
        panel = new JPanel(new CircleLayout());
        textField = new JTextField(20);
        JButton button = new JButton("Activate");
        CheckBox1 = new JCheckBox("One");
        CheckBox2 = new JCheckBox("Two");
        CheckBox3 = new JCheckBox("Three");

        GridBagConstraints constraints = getDefaultConstraits();
        panel.add(textField, constraints);

        constraints.gridx = 1;
        button.addActionListener(addListener());
        panel.add(button, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(CheckBox1, constraints);
        constraints.gridy = 2;
        panel.add(CheckBox2, constraints);
        constraints.gridy = 3;
        panel.add(CheckBox3, constraints);
    }

    public JPanel getPanel() {
        return panel;
    }

    private GridBagConstraints getDefaultConstraits() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        return constraints;
    }

    private ActionListener addListener() {
        return e -> {
            String names = textField.getText();
            String[] namesArray = names.split("\\s+");
            JCheckBox[] checkBoxes = {CheckBox1, CheckBox2, CheckBox3};
            for (String name : namesArray) {
                boolean found = false;
                for (JCheckBox checkBox : checkBoxes) {
                    if (checkBox.getText().equals(name)) {
                        checkBox.setSelected(!checkBox.isSelected());
                        found = true;
                        break;
                    }
                }
                if(!found) {
                    alert("There is no button with name '" + name + "'!");
                    return;
                }
            }
        };
    }

    private void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
