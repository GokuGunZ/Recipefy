package Views.Recipe;

import Beans.Recipe;
import Beans.RecipeDetail;
import Controllers.MainFrameController;
import Controllers.UpdateController;
import Models.RecipeModel;
import Views.UIComponents.FormPanel;
import Views.UIComponents.UpdateFormPanel;
import Views.UpdateableView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UpdatePanel extends JPanel implements UpdateableView {
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
    private Recipe recipe;
    private RecipeDetail recipeDetail;
    private JButton updateButton;
    private ActionListener updateButtonListener;
    public UpdatePanel(Recipe recipe, MainFrameController mfc){
        this.mfc = mfc;
        this.recipe = recipe;
        this.mfc.setRecipeID(recipe.getRecipeID());
        setBorder(new EmptyBorder(40, 100, 40, 100));
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        titleField = new JTextField(20);
        this.add(new UpdateFormPanel("Recipe title: ", titleField, recipe.getTitle()));

        recipeDetail = recipe.getRecipeDetail();
        descriptionField = new JTextField(20);
        this.add(new UpdateFormPanel("Recipe Description: ", descriptionField, recipeDetail.getDescription()));


        // Gestire la visione degli ingredienti
        JPanel ingredientPanWBtn = new JPanel();
        ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new BoxLayout(ingredientPanel, BoxLayout.Y_AXIS));
        addIngredientFields();
        addIngredientButton = new JButton("+");
        addIngredientButton.addActionListener(e -> addIngredientFields());
        ingredientPanWBtn.add(ingredientPanel);
        ingredientPanWBtn.add(addIngredientButton);
        this.add(ingredientPanWBtn);

        //Gestire la visione delle istruzioni
        JPanel instructionPanWBtn = new JPanel();
        instructionPanel = new JPanel();
        instructionPanel.setLayout(new BoxLayout(instructionPanel, BoxLayout.Y_AXIS));
        addInstructionFields();
        addInstructionButton = new JButton("+");
        addInstructionButton.addActionListener(e -> addInstructionFields());
        instructionPanWBtn.add(instructionPanel);
        instructionPanWBtn.add(addInstructionButton);
        this.add(instructionPanWBtn);


        JPanel timePanel = new JPanel();
        prepTime = new JTextField(3);
        cookTime = new JTextField(3);
        timePanel.add(new UpdateFormPanel("Preparation Time (in minute):", prepTime, recipeDetail.getPreparationTime()));
        timePanel.add(new UpdateFormPanel("Cooking Time (in minute):", cookTime, recipeDetail.getCookingTime()));
        this.add(timePanel);

        JPanel difficultyPanel = new JPanel();
        difficultyPanel.add(new JLabel("Difficulty level:"));
        String[] difficulties = {"Easy", "Medium", "Hard", "Professional"};
        difficultyLvl = new JComboBox<>(difficulties);
        difficultyLvl.setSelectedItem(recipeDetail.getDifficultyLevel());
        difficultyPanel.add(difficultyLvl);
        this.add(difficultyPanel);

        JPanel tagPanel = new JPanel();
        JPanel cuisinePanel = new JPanel();
        cuisinePanel.add(new JLabel("Select Cuisine Type"));
        String[] cuisineTypes = { "Italian Cuisine", "French Cuisine", "Mexican Cuisine", "Chinese Cuisine", "Indian Cuisine", "Japanese Cuisine", "Thai Cuisine", "Mediterranean Cuisine", "Middle Eastern Cuisine"};
        cuisineSelector = new JComboBox<>(cuisineTypes);
        cuisineSelector.setSelectedItem(recipeDetail.getCuisineType());
        cuisinePanel.add(cuisineSelector);
        tagPanel.add(cuisinePanel);

        // Gestire nutritional values
        JPanel nutritionalPanel = new JPanel();
        nutritionalPanel.add(new JLabel("Select the Nutritional Attributes"));
        String[] nutritionalAttributes = {"Gluten-Free", "Dairy-Free", "Vegetarian", "Vegan", "Paleo", "Keto", "Low-Carb", "Low-Fat", "Sugar-Free", "Nut-Free", "Soy-Free", "Egg-Free", "Shellfish-Free", "Peanut-Free", "High-Fiber"};
        nutritionalList = new JList(nutritionalAttributes);
        JScrollPane nutritionalPane = new JScrollPane(nutritionalList);
        nutritionalPanel.add(nutritionalPane);
        tagPanel.add(nutritionalPanel);
        this.add(tagPanel);

        caloricInfo = new JTextField(20);
        this.add(new UpdateFormPanel("Insert caloric info: ", caloricInfo, recipeDetail.getCaloricInfo()));

        JPanel updatePanel = new JPanel();
        updateButton = new JButton("Update Recipe");
        updateButton.addActionListener(e -> {
            if (updateButtonListener != null) {
                updateButtonListener.actionPerformed(e);
            }
        });
        UpdateController updateController = new UpdateController(mfc, this, new RecipeModel(mfc));
        updatePanel.add(updateButton);
        this.add(updatePanel);

    }
    //// Controllare ed eliminare le seguenti funzioni
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
        removeButton.addActionListener(e -> {
            ingredientPanel.remove(newIngredientPanel);
            ingredientPanel.revalidate();
            ingredientPanel.repaint();
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
        removeButton.addActionListener(e -> {
            int index = instructionPanel.getComponentZOrder(newInstructionPanel);
            instructionPanel.remove(newInstructionPanel);
            renumberSteps(index);
            instructionPanel.revalidate();
            instructionPanel.repaint();
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
    public String getDescription() {return descriptionField.getText();}
    public JPanel getIngredientPanel() {return ingredientPanel;}
    public JPanel getInstructionPanel() {return instructionPanel;}
    public int getPrepTime() {return Integer.parseInt(prepTime.getText());}
    public int getCookTime() {return Integer.parseInt(cookTime.getText());}
    public String getDifficulty() {return String.valueOf(difficultyLvl.getSelectedItem());}
    public String getCuisine() {return String.valueOf(cuisineSelector.getSelectedItem());}
    public String getCaloricInfo() {return caloricInfo.getText();}
    public JList<String> getNutritionalList() {return nutritionalList;}

    @Override
    public List<Object> getUpdateableAttributes() {
        List<Object> attributes = new ArrayList<>();
        attributes.add(recipe.getRecipeID());
        attributes.add(titleField.getText());
        attributes.add(descriptionField.getText());
        attributes.add("[\"Ingredient list\"]");
        //ADD Ingredient List
        attributes.add("[\"Instruction list\"]");
        //ADD Instruction List
        attributes.add(prepTime.getText());
        attributes.add(cookTime.getText());
        attributes.add(difficultyLvl.getSelectedItem());
        attributes.add(cuisineSelector.getSelectedItem());
        attributes.add(nutritionalList.getSelectedValuesList().toString());
        attributes.add(caloricInfo.getText());
        return attributes;
    }

    @Override
    public void setUpdateButtonListener(ActionListener listener){
        this.updateButtonListener = listener;
    }

}
