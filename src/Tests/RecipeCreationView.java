package Tests;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RecipeCreationView extends JFrame {
    private JPanel ingredientPanel;
    private JButton addIngredientButton;

    public RecipeCreationView() {
        setTitle("Recipe Creation");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel to hold ingredient fields
        ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new BoxLayout(ingredientPanel, BoxLayout.Y_AXIS));
        addIngredientFields();

        // Button to add new ingredient fields
        addIngredientButton = new JButton("Add Ingredient");
        addIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addIngredientFields();
            }
        });

        add(ingredientPanel, BorderLayout.CENTER);
        add(addIngredientButton, BorderLayout.SOUTH);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void addIngredientFields() {
        JPanel newIngredientPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newIngredientPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField qtyField = new JTextField(5);
        JTextField unitField = new JTextField(10);
        JTextField entityField = new JTextField(20);

        newIngredientPanel.add(new JLabel("Qty:"));
        newIngredientPanel.add(qtyField);
        newIngredientPanel.add(new JLabel("Unit:"));
        newIngredientPanel.add(unitField);
        newIngredientPanel.add(new JLabel("Entity:"));
        newIngredientPanel.add(entityField);

        ingredientPanel.add(newIngredientPanel);
        ingredientPanel.revalidate();
        ingredientPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new RecipeCreationView();
        });
    }
}

