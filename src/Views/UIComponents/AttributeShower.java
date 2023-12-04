package Views.UIComponents;

import javax.swing.*;
import java.awt.*;

public class AttributeShower extends JPanel {
    String label;
    String value;
    public AttributeShower(String label, String value, int fontSize){
        this.label = label;
        this.value = value;

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        setMaximumSize(new Dimension(screenSize.width*70/100, 0));
        setLayout(new GridLayout(2,1));
        JLabel labelJl = new JLabel(label);
        Font labelFont = new Font("Arial", Font.PLAIN, 14);
        labelJl.setForeground(Color.gray);
        labelJl.setFont(labelFont);
        labelJl.setHorizontalAlignment(SwingConstants.LEFT);
        labelJl.setVerticalAlignment(SwingConstants.BOTTOM);
        JLabel valueJl = new JLabel("<html><p style=\"width:100%\">"+value+"</p></html>");
        Font valueFont = new Font("Arial", Font.PLAIN, fontSize);
        valueJl.setFont(valueFont);
        add(labelJl);
        add(valueJl);
    }
}
