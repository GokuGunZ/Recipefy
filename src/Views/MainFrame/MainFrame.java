package Views.MainFrame;

import Beans.User;
import Controllers.MainFrameController;
import Views.Recipefy.LoginFrame;
import com.formdev.flatlaf.FlatLightLaf;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{

    private JPanel mainPanel;
    private MainFrameController mfc;
    private User userAuthed;

    public MainFrame(){
        super("Recipefy");
        try {
            UIManager.setLookAndFeel( new FlatLightLaf() );
        } catch( Exception ex ) {
            System.err.println( "Failed to initialize LaF" );
        }
        mfc = new MainFrameController(this);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        this.setSize(screenWidth*90/100, screenHeight*84/100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

        this.renderLoginFrame();
    }

    public void updateMainPanel(JPanel panel) {
        mainPanel.removeAll();
        mainPanel.add(panel, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }

    public void renderLoginFrame(){
        this.add(new LoginFrame(this), BorderLayout.CENTER);
    }

    public void renderAuthenticatedUI(User user){
        this.mfc.setAuthedUser(user);
        this.mfc.setUserController(user.getUserID());
        this.getContentPane().removeAll();

        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JLabel defaultLabel = new JLabel("Welcome to Recipefy! \n Use the navigation Bar on the side to browse the application!");
        defaultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(defaultLabel, BorderLayout.CENTER);


        this.add(new NavBar(this), BorderLayout.WEST);

        this.add(mainPanel, BorderLayout.CENTER);

        this.revalidate();
        this.repaint();
    }

    public MainFrameController getMainFrameController() {return this.mfc;}
    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame::new);
    }
}

