package Views.Recipe;

import Beans.Recipe;
import Beans.RecipeDetail;
import Controllers.MainFrameController;
import Utility.DataCollector;
import Views.UIComponents.AttributeShower;
import Views.User.UserPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
        add(titleLabel);

        RecipeDetail recipeDetail = recipe.getRecipeDetail();
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

        JButton updateBtn = new JButton("Update recipe");
        JPanel updatePanel = new JPanel();
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
