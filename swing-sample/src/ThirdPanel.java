package src;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.event.ActionListener;
import java.awt.Insets;

public class ThirdPanel {
    private final JPanel panel;
    private final JTextField textField;
    private final JRadioButton RadioButton1;
    private final JRadioButton RadioButton2;
    private final JRadioButton RadioButton3;

    public ThirdPanel() {
        panel = new JPanel(new CircleLayout());
        textField = new JTextField(20);
        JButton button = new JButton("Activate");
        RadioButton1 = new JRadioButton("One");
        RadioButton2 = new JRadioButton("Two");
        RadioButton3 = new JRadioButton("Three");

        GridBagConstraints constraints = getDefaultConstraits();
        panel.add(textField, constraints);

        constraints.gridx = 1;
        button.addActionListener(addListener());
        panel.add(button, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(RadioButton1, constraints);
        constraints.gridy = 2;
        panel.add(RadioButton2, constraints);
        constraints.gridy = 3;
        panel.add(RadioButton3, constraints);
        ButtonGroup group = new ButtonGroup();
        group.add(RadioButton1);
        group.add(RadioButton2);
        group.add(RadioButton3);
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
            String name = textField.getText();
            JRadioButton[] radioButtons = {RadioButton1, RadioButton2, RadioButton3};
            for (JRadioButton radioButton : radioButtons) {
                if (radioButton.getText().equals(name)) {
                    radioButton.setSelected(true);
                    return;
                }
            }
            alert();
        };
    }

    private void alert() {
        JOptionPane.showMessageDialog(null, "There is no such radio button!");
    }
}
