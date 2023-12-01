package Views.Recipe;

import Beans.Recipe;
import Beans.RecipeDetail;
import Models.RecipeDetailsModel;
import Views.UIComponents.AttributeShower;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class ReadPanel extends JPanel {

    public ReadPanel(Recipe recipe){
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBackground(new Color(102, 227, 102,55));


        JLabel titleLabel = new JLabel(recipe.getTitle());
        titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);
        RecipeDetail recipeDetail = recipe.getRecipeDetail();
        RecipeDetailsModel.RecipeIngredients lol = new RecipeDetailsModel.RecipeIngredients(recipeDetail.getIngredients());
        add(new AttributeShower("Description", recipeDetail.getDescription(),20));
        add(new AttributeShower("Ingredients", recipeDetail.getIngredients(), 18));
        add(new AttributeShower("Instructions", recipeDetail.getInstruction(), 22));
        add(new AttributeShower("Preparation Time", recipeDetail.getPreparationTime(), 16));
        add(new AttributeShower("Cooking Time", recipeDetail.getCookingTime(), 16));
        add(new AttributeShower("Difficulty level", recipeDetail.getDifficultyLevel(), 20));
        add(new AttributeShower("Cuisine Type", recipeDetail.getCuisineType(), 22));
        add(new AttributeShower("Nutritional Info", recipeDetail.getNutritionalAttributes(), 22));
        add(new AttributeShower("Caloric Info", recipeDetail.getCaloricInfo(), 18));
        setBorder(new EmptyBorder(5,120,30,120));
    }
}
