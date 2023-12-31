package it.unipv.po.recipefy.Views.Recipe;

import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Controllers.RecipeController;
import it.unipv.po.recipefy.Views.UIComponents.FormPanel;
import it.unipv.po.recipefy.Views.UIComponents.ImageUploaderPanel;
import it.unipv.po.recipefy.Views.User.UserPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URISyntaxException;
import java.sql.SQLException;

public class CreatePanel extends JPanel {
    public MainFrameController mfc;
    private JTextField titleField;
    private JTextField descriptionField;
    private JPanel ingredientPanel;
    private JButton addIngredientButton;
    private JPanel instructionPanel;
    private JButton addInstructionButton;
    private JTextField prepTime;
    private JTextField cookTime;
    private JComboBox<String> difficultyLvl;
    private JComboBox<String> cuisineSelector;
    private JList nutritionalList;
    private JTextField caloricInfo;
    private String imagePath;
    private ImageUploaderPanel imageUploaderPanel;
    public CreatePanel(MainFrameController mfc){
        this.mfc = mfc;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        JPanel titleImagePanel = new JPanel(new FlowLayout());
        titleField = new JTextField(20);
        titleImagePanel.add(new FormPanel("Recipe title: ", titleField));
        imageUploaderPanel= new ImageUploaderPanel();
        titleImagePanel.add(imageUploaderPanel);
        add(titleImagePanel);


        descriptionField = new JTextField(20);
        this.add(new FormPanel("Recipe Description: ", descriptionField));

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
        prepTime = new JTextField(3);
        cookTime = new JTextField(3);
        timePanel.add(new FormPanel("Preparation Time (in minute):", prepTime));
        timePanel.add(new FormPanel("Cooking Time (in minute):", cookTime));
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
        cuisineSelector = new JComboBox<>(cousineTypes);
        cousinePanel.add(cuisineSelector);
        tagPanel.add(cousinePanel);
        JPanel nutritionalPanel = new JPanel();
        nutritionalPanel.add(new JLabel("Select the Nutritional Attributes"));
        String[] nutritionalAttributes = {"Gluten-Free", "Dairy-Free", "Vegetarian", "Vegan", "Paleo", "Keto", "Low-Carb", "Low-Fat", "Sugar-Free", "Nut-Free", "Soy-Free", "Egg-Free", "Shellfish-Free", "Peanut-Free", "High-Fiber"};
        nutritionalList = new JList(nutritionalAttributes);
        JScrollPane nutritionalPane = new JScrollPane(nutritionalList);
        nutritionalPanel.add(nutritionalPane);
        tagPanel.add(nutritionalPanel);
        this.add(tagPanel);

        caloricInfo = new JTextField(20);
        this.add(new FormPanel("Insert caloric info: ", caloricInfo));

        JButton createButton = new JButton("Create Recipe");
        CreatePanel cp = this;
        createButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(imageUploaderPanel.getImagePath() == null){
                        imagePath = "/images/placeholder.jpg";
                    } else {
                        imagePath = imageUploaderPanel.getImagePath();
                    }
                    int recipeID = RecipeController.createRecipe(cp);
                    RecipeController.showRecipe(mfc, recipeID, (UserPanel) mfc.getMainPanel());
                } catch (SQLException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        this.add(createButton);

    }
    public void saveImage() throws URISyntaxException {imageUploaderPanel.saveImageFinal();}
    private void addIngredientFields() {
        JPanel newIngredientPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newIngredientPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField qtyField = new JTextField(5);
        JTextField unitField = new JTextField(10);
        JTextField entityField = new JTextField(20);

        newIngredientPanel.add(new FormPanel("Qty:", qtyField));
        newIngredientPanel.add(new FormPanel("Unit:", unitField));
        newIngredientPanel.add(new FormPanel("Entity:", entityField));

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

        JTextField instructionTextField = new JTextField(40);

        int currentStepCount = instructionPanel.getComponentCount() + 1;
        newInstructionPanel.add(new FormPanel("Step " + currentStepCount + ":", instructionTextField));
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
            FormPanel fPanel = (FormPanel) panel.getComponent(0);
            fPanel.setText("Step " + (i + 1) + ":");
        }
    }

    public String getTitle() {return titleField.getText();}
    public String getImagePath() {return imagePath;}
    public String getDescription() {return descriptionField.getText();}
    public JPanel getIngredientPanel() {return ingredientPanel;}
    public JPanel getInstructionPanel() {return instructionPanel;}
    public int getPrepTime() {
        if (prepTime.getText()==""){
            return 0;
        }
        return Integer.parseInt(prepTime.getText());}
    public int getCookTime() {
        if (cookTime.getText()==""){
            return 0;
        }
        return Integer.parseInt(cookTime.getText());}
    public String getDifficulty() {return String.valueOf(difficultyLvl.getSelectedItem());}
    public String getCuisine() {return String.valueOf(cuisineSelector.getSelectedItem());}
    public String getCaloricInfo() {return caloricInfo.getText();}
    public JList<String> getNutritionalList() {return nutritionalList;}

}
