package Tests;
import javax.swing.*;
import java.awt.*;

public class MainFrame {

    private JPanel mainPanel;

    public MainFrame(){
        JFrame frame = new JFrame("Recipefy");
        Toolkit kit = Toolkit.getDefaultToolkit(); //Istanzio il toolkit
        Dimension screenSize = kit.getScreenSize(); //Prendo la dimensione dello schermo
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        frame.setSize(screenWidth*84/100, screenHeight*84/100); //Definisce le dimensioni
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JLabel defaultLabel = new JLabel("Main Frame Content");
        defaultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(defaultLabel, BorderLayout.CENTER);

        NavBar navigationSidebar = new NavBar(this);
        frame.add(navigationSidebar, BorderLayout.WEST);
        frame.add(mainPanel, BorderLayout.CENTER);


    }

    public void updateMainPanel(String content) {
        mainPanel.removeAll();
        JLabel optionLabel = new JLabel(content);
        optionLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(optionLabel, BorderLayout.CENTER);

        // Refresh the main panel
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

