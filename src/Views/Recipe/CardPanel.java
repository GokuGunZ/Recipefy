package Views.Recipe;

import Controllers.RecipeController;
import Utility.DataCollector;
import Views.User.UserPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.sql.SQLException;

public class CardPanel extends JPanel {
    private int recipeID;
    private String title;
    private Image img;
    private UserPanel userPanel;

    public CardPanel(int recipeID, String title, String thumbUrl, UserPanel userPanel) throws IOException {
        this.recipeID = recipeID;
        this.userPanel = userPanel;
        this.title = title;
        this.setLayout(new BorderLayout());
        this.setSize(300, 200);
        this.setPreferredSize(new Dimension(300,200));
        DataCollector dCol = new DataCollector();
        this.img = dCol.loadImage(thumbUrl).getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        img.getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        JLabel titleLabel = new JLabel(title);
        titleLabel.setBorder(new EmptyBorder(0,10,0,0));
        titleLabel.setFont(new Font("Verdana", Font.PLAIN, 18));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBackground(new Color(128, 128, 128, 150));
        titleLabel.setOpaque(true);
        titleLabel.setPreferredSize(new Dimension(200, 50));
        titleLabel.setHorizontalAlignment(SwingConstants.LEFT);
        titleLabel.setVerticalAlignment(SwingConstants.CENTER);
        this.add(titleLabel, BorderLayout.SOUTH);
        this.addMouseListener(new mouseClick());
        this.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (img != null){
            g.drawImage(img, 0, 0,this);
        }
    }

    public class mouseClick extends MouseAdapter{
        @Override
        public void mouseClicked(MouseEvent e) {
            CardPanel panel = (CardPanel) e.getSource();
            try {
                RecipeController.showRecipe(recipeID, userPanel);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem occurred during the loading of the Recipe" + panel.title);
                throw new RuntimeException(ex);
            }
        }
    }
}