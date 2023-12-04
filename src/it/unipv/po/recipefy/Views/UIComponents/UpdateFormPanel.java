package it.unipv.po.recipefy.Views.UIComponents;

import javax.swing.*;
import java.awt.*;

public class UpdateFormPanel extends JPanel {
    JLabel jLabel;
    JTextField field;
    public UpdateFormPanel(String label, JTextField field, String placeholder) {
        this.field = field;
        setLayout(new GridLayout(2, 1));
        jLabel = new JLabel(label);
        Font labelFont = new Font("Arial", Font.PLAIN, 12);
        jLabel.setForeground(Color.gray);
        jLabel.setFont(labelFont);
        jLabel.setHorizontalAlignment(SwingConstants.LEFT);
        jLabel.setVerticalAlignment(SwingConstants.BOTTOM);
        Font fieldFont = new Font("Arial", Font.PLAIN, 20);
        field.setFont(fieldFont);
        field.setText(placeholder);
        add(jLabel);
        add(field);
    }

    public void setText(String label){
        this.jLabel.setText(label);
    }
}
