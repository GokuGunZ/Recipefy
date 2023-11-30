package Views.Recipe;

import Beans.Recipe;

import javax.swing.*;
import java.awt.*;

public class ReadPanel extends JPanel {

    public ReadPanel(Recipe recipe){
        setLayout(new GridBagLayout());
        setBackground(new Color(102, 227, 102,55));


        JLabel titleLabel = new JLabel(recipe.getTitle());
        titleLabel.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(titleLabel);

    }
}
