package src;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.BoxLayout;

public class Separator {
    private final JPanel panel;

    public Separator(String label) {
        panel = new JPanel();

        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

        panel.add(new JSeparator());
        panel.add(new JLabel("  " + label + "  "));
        panel.add(new JSeparator());
    }

    public JPanel getSeparator() {
        return panel;
    }
}
