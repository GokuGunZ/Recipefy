package Tests;

import javax.swing.*;
import java.awt.*;

class OuterPanel extends JFrame {
    public OuterPanel() {
        setTitle("Outer Frame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());

        JPanel outerPanel = new JPanel();
        outerPanel.setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(400,400));

        // Create RecipeReadPage JPanel
        JPanel recipePanel = new RecipeReadPage(); // Method to create RecipeReadPage JPanel

        // Set constraints for the RecipeReadPage panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0.8; // Occupy 80% of the vertical space of the outer panel
        gbc.fill = GridBagConstraints.VERTICAL; // Allow the panel to expand both vertically and horizontally
        gbc.anchor = GridBagConstraints.CENTER; // Center the panel

        outerPanel.add(recipePanel, gbc);

        add(outerPanel, gbc);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private JPanel createRecipePanel() {
        JPanel recipePanel = new JPanel();
        recipePanel.setLayout(new GridBagLayout());

        // Add components to the RecipeReadPage panel
        // ... (Add JLabels, JTextAreas, etc. as per your recipe display)

        return recipePanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new OuterPanel());
    }
}
public class RecipeReadPage extends JPanel {
    public RecipeReadPage() {
        setLayout(new GridBagLayout());
        setBackground(new Color(40,200,40,60));
        // Create JLabels for different attributes
        JLabel titleLabel = new JLabel("Recipe Title");
        titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24)); // Set a larger font
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER); // Center align the text

        JLabel descriptionLabel = new JLabel("Recipe Description");
        descriptionLabel.setFont(new Font("Arial", Font.PLAIN, 16)); // Set a smaller font

        JLabel ingredientLabel = new JLabel("Ingredients");
        ingredientLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font size

        JLabel instructionsLabel = new JLabel("Instructions");
        instructionsLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Adjust font size

        // Add labels to the frame using GridBagConstraints
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); // Add spacing between components

        add(titleLabel, gbc);

        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL; // Allow the label to expand horizontally
        add(descriptionLabel, gbc);

        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE; // Reset to non-expanding for subsequent labels
        add(ingredientLabel, gbc);

        gbc.gridy = 3;
        add(new JLabel("Ingredient 1"), gbc); // Example of adding ingredient list

        gbc.gridy = 4;
        add(new JLabel("Ingredient 2"), gbc);
    }

}