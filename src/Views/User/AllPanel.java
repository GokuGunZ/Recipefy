package Views.User;

import javax.swing.*;
import java.awt.*;

public class AllPanel extends JPanel {
    public AllPanel(){
        this.setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new BorderLayout());
        JButton newRecipe = new JButton("New Recipe");
        buttonPanel.add(newRecipe, BorderLayout. EAST);
        this.add(buttonPanel, BorderLayout.NORTH);

        JPanel recipePanel = new JPanel(new GridLayout());

        this.add(recipePanel, BorderLayout.CENTER);
    }
}
