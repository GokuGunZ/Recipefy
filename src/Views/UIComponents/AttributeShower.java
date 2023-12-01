package Views.UIComponents;

import javax.swing.*;
import java.awt.*;

public class AttributeShower extends JPanel {
    String label;
    String value;
    public AttributeShower(String label, String value, int fontSize){
        this.label = label;
        this.value = value;
        setLayout(new GridLayout(2,1));
        JLabel labelJl = new JLabel(label);
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        labelJl.setForeground(Color.gray);
        labelJl.setFont(labelFont);
        labelJl.setHorizontalAlignment(SwingConstants.LEFT);
        labelJl.setVerticalAlignment(SwingConstants.BOTTOM);
        JLabel valueJl = new JLabel(value);
        Font valueFont = new Font("Arial", Font.PLAIN, fontSize);
        valueJl.setFont(valueFont);
        add(labelJl);
        add(valueJl);
    }
}
