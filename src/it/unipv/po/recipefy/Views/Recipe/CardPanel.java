package it.unipv.po.recipefy.Views.Recipe;

import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Controllers.RecipeController;
import it.unipv.po.recipefy.Utility.DataCollector;
import it.unipv.po.recipefy.Views.User.UserPanel;

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
    private MainFrameController mfc;

    public CardPanel(MainFrameController mfc, int recipeID, String title, String thumbUrl, UserPanel userPanel) throws IOException {
        this.mfc = mfc;
        this.recipeID = recipeID;
        this.userPanel = userPanel;
        this.title = title;
        this.setLayout(new BorderLayout());
        this.setSize(300, 200);
        this.setPreferredSize(new Dimension(300,200));
        this.img = DataCollector.loadImage(thumbUrl).getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        this.add(new titleLabel(title), BorderLayout.SOUTH);
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
                RecipeController.showRecipe(mfc, recipeID, userPanel);
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Problem occurred during the loading of the Recipe" + panel.title);
                throw new RuntimeException(ex);
            }
        }
    }
    class titleLabel extends JLabel {
        public titleLabel(String title) {
            super(title);
            setBorder(new EmptyBorder(0,10,0,0));
            setFont(new Font("Verdana", Font.PLAIN, 18));
            setForeground(Color.WHITE);
            setBackground(new Color(128, 128, 128, 150));
            setOpaque(true);
            setPreferredSize(new Dimension(200, 50));
            setHorizontalAlignment(SwingConstants.LEFT);
            setVerticalAlignment(SwingConstants.CENTER);

        }
    }
}