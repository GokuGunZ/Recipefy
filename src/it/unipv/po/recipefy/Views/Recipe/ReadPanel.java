package it.unipv.po.recipefy.Views.Recipe;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.unipv.po.recipefy.Beans.Recipe;
import it.unipv.po.recipefy.Beans.RecipeDetail;
import it.unipv.po.recipefy.Beans.RecipeDetail.Ingredient;
import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Utility.DataCollector;
import it.unipv.po.recipefy.Views.UIComponents.AttributeShower;
import it.unipv.po.recipefy.Views.User.UserPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

public class ReadPanel extends JPanel {
    private Recipe recipe;
    private MainFrameController mfc;

    public ReadPanel(MainFrameController mfc, Recipe recipe){
        this.recipe = recipe;
        this.mfc = mfc;

        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(new Color(102, 227, 102,55));
        add(new imagePanel(DataCollector.loadImage(recipe.getImagePath()).getScaledInstance(600, 400, Image.SCALE_DEFAULT)));


        JLabel titleLabel = new JLabel(recipe.getTitle());
        titleLabel.setMaximumSize(new Dimension(1000, 0));
        titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
        add(titleLabel);

        RecipeDetail recipeDetail = recipe.getRecipeDetail();
        add(new AttributeShower("Description", recipeDetail.getDescription(),20));
        add(getIngredientsPanel(recipeDetail.getIngredients()));
        add(new AttributeShower("Instructions", recipeDetail.getInstruction(), 22));
        add(new AttributeShower("Preparation Time", recipeDetail.getPreparationTime(), 16));
        add(new AttributeShower("Cooking Time", recipeDetail.getCookingTime(), 16));
        add(new AttributeShower("Difficulty level", recipeDetail.getDifficultyLevel(), 20));
        add(new AttributeShower("Cuisine Type", recipeDetail.getCuisineType(), 22));
        add(new AttributeShower("Nutritional Info", recipeDetail.getNutritionalAttributes(), 22));
        add(new AttributeShower("Caloric Info", recipeDetail.getCaloricInfo(), 18));
        setBorder(new EmptyBorder(5,100,30,100));

        JButton updateBtn = new JButton("Update recipe");
        JPanel updatePanel = new JPanel();
        updatePanel.setMaximumSize(new Dimension(1000, 0));
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                UserPanel userPanel = (UserPanel) mfc.getMainPanel();
                userPanel.updateCenterPanel(new UpdatePanel(recipe, mfc));
            }
        });
        updatePanel.add(updateBtn);
        add(updatePanel);

    }
    private JPanel getIngredientsPanel(String jsonString){
        JPanel ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new BoxLayout(ingredientPanel, BoxLayout.Y_AXIS));
        ingredientPanel.setBorder(new EmptyBorder(10,20,10,20));
        JLabel labelJl = new JLabel("Ingredients");
        Font labelFont = new Font("Arial", Font.PLAIN, 16);
        labelJl.setForeground(Color.gray);
        labelJl.setFont(labelFont);
        labelJl.setHorizontalAlignment(SwingConstants.LEFT);
        labelJl.setVerticalAlignment(SwingConstants.BOTTOM);
        ingredientPanel.add(labelJl);

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Ingredient[] ingredientsArray = objectMapper.readValue(jsonString, Ingredient[].class);
            List<Ingredient> ingredientsList = Arrays.asList(ingredientsArray);

            // Printing the ingredients
            for (Ingredient ingredient : ingredientsList) {
                JPanel ingredientRow = new JPanel(new FlowLayout(FlowLayout.LEFT));
                ingredientRow.add(new AttributeShower("Qty",ingredient.getQty(), 20));
                ingredientRow.add(new AttributeShower("Unit",ingredient.getUnit(), 20));
                ingredientRow.add(new AttributeShower("Entity",ingredient.getEntity(), 20));
                ingredientPanel.add(ingredientRow);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ingredientPanel;
    }


    class imagePanel extends JPanel{
        private Image img;
        public imagePanel(Image image){
            img = image;
            this.setSize(600, 400);
            this.setPreferredSize(new Dimension(600,400));
            setBackground(new Color(0,0,0,0));

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (img != null){
                g.drawImage(img, 0, 0,this);
            }
        }
    }

}
