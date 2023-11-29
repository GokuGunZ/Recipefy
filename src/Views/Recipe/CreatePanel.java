package Views.Recipe;

import Controllers.MainFrameController;
import Controllers.RecipeController;
import Tests.RecipeCreationView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class CreatePanel extends JPanel {
    private MainFrameController mfc;
    private JTextField titleField;
    private JTextField descriptionField;
    private JPanel ingredientPanel;
    private JButton addIngredientButton;
    private JPanel instructionPanel;
    private JButton addInstructionButton;
    private JTextField prepTime;
    private JTextField cookTime;
    private JComboBox<String> difficultyLvl;
    private JComboBox<String> cousineSelector;
    private JList nutritionalList;
    private JTextField caloricInfo;
    public CreatePanel(){
        //this.mfc = mfc;
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(new Dimension(500,500));

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(new JLabel("Title"));
        titleField = new JTextField(20);
        titlePanel.add(titleField);
        this.add(titlePanel);

        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descriptionPanel.add(new JLabel("Description"));
        descriptionField = new JTextField(20);
        descriptionPanel.add(descriptionField);
        this.add(descriptionPanel);

        JPanel ingredientPanWBtn = new JPanel();
        ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new BoxLayout(ingredientPanel, BoxLayout.Y_AXIS));
        addIngredientFields();
        addIngredientButton = new JButton("+");
        addIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addIngredientFields();
            }
        });
        ingredientPanWBtn.add(ingredientPanel);
        ingredientPanWBtn.add(addIngredientButton);
        this.add(ingredientPanWBtn);

        JPanel instructionPanWBtn = new JPanel();
        instructionPanel = new JPanel();
        instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.Y_AXIS));
        addInstructionFields();
        addInstructionButton = new JButton("+");
        addInstructionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addInstructionFields();
            }
        });
        instructionPanWBtn.add(instructionPanel);
        instructionPanWBtn.add(addInstructionButton);
        this.add(instructionPanWBtn);

        JPanel timePanel = new JPanel();
        JPanel prepPanel = new JPanel();
        prepPanel.add(new JLabel("Preparation Time:"));
        prepTime = new JTextField(3);
        prepPanel.add(prepTime);
        JPanel cookPanel = new JPanel();
        cookPanel.add(new JLabel("Cooking Time:"));
        cookTime = new JTextField(3);
        cookPanel.add(cookTime);
        timePanel.add(prepPanel);
        timePanel.add(cookPanel);
        this.add(timePanel);

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.add(new JLabel("Difficulty level:"));
        String[] difficulties = {"Easy", "Medium", "Hard", "Professional"};
        difficultyLvl = new JComboBox<>(difficulties);
        difficultyPanel.add(difficultyLvl);
        this.add(difficultyPanel);

        JPanel tagPanel = new JPanel();
        JPanel cousinePanel = new JPanel();
        cousinePanel.add(new JLabel("Select Cousine Type"));
        String[] cousineTypes = { "Italian Cuisine", "French Cuisine", "Mexican Cuisine", "Chinese Cuisine", "Indian Cuisine", "Japanese Cuisine", "Thai Cuisine", "Mediterranean Cuisine", "Middle Eastern Cuisine"};
        cousineSelector = new JComboBox<>(cousineTypes);
        cousinePanel.add(cousineSelector);
        tagPanel.add(cousinePanel);
        JPanel nutritionalPanel = new JPanel();
        nutritionalPanel.add(new JLabel("Select the Nutritional Attributes"));
        String[] nutritionalAttributes = {"Gluten-Free", "Dairy-Free", "Vegetarian", "Vegan", "Paleo", "Keto", "Low-Carb", "Low-Fat", "Sugar-Free", "Nut-Free", "Soy-Free", "Egg-Free", "Shellfish-Free", "Peanut-Free", "High-Fiber"};
        nutritionalList = new JList(nutritionalAttributes);
        JScrollPane nutritionalPane = new JScrollPane(nutritionalList);
        nutritionalPanel.add(nutritionalPane);
        tagPanel.add(nutritionalPanel);
        this.add(tagPanel);

        JPanel caloricInfoPanel = new JPanel();
        caloricInfoPanel.add(new JLabel("Insert caloric info"));
        caloricInfo = new JTextField(20);
        caloricInfoPanel.add(caloricInfo);
        this.add(caloricInfoPanel);

        JButton createButton = new JButton("Create Recipe");
        CreatePanel cp = this;
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    RecipeController.createRecipe(cp);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        this.add(createButton);




        jf.add(this);
        jf.setVisible(true);
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

        JButton removeButton = new JButton("-");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ingredientPanel.remove(newIngredientPanel);
                ingredientPanel.revalidate();
                ingredientPanel.repaint();
            }
        });

        newIngredientPanel.add(removeButton);

        ingredientPanel.add(newIngredientPanel);
        ingredientPanel.revalidate();
        ingredientPanel.repaint();
    }

    private void addInstructionFields() {
        JPanel newInstructionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newInstructionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextArea instructionTextArea = new JTextArea(3, 40);

        int currentStepCount = instructionPanel.getComponentCount() + 1;
        newInstructionPanel.add(new JLabel("Step " + currentStepCount + ":"));
        newInstructionPanel.add(instructionTextArea);

        JButton removeButton = new JButton("-");
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int index = instructionPanel.getComponentZOrder(newInstructionPanel);
                instructionPanel.remove(newInstructionPanel);
                renumberSteps(index);
                instructionPanel.revalidate();
                instructionPanel.repaint();
            }
        });

        newInstructionPanel.add(removeButton);

        instructionPanel.add(newInstructionPanel);
        instructionPanel.revalidate();
        instructionPanel.repaint();
    }

    private void renumberSteps(int startIndex) {
        Component[] components = instructionPanel.getComponents();

        for (int i = startIndex; i < components.length; i++) {
            JPanel panel = (JPanel) components[i];
            JLabel label = (JLabel) panel.getComponent(0);
            label.setText("Step " + (i + 1) + ":");
        }
    }

    public String getTitle() {return titleField.getText();}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CreatePanel();
        });
    }
}
