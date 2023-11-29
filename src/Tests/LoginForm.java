import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class LoginForm extends JFrame {

    public LoginForm() {
        setTitle("Login and Register Form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));

        // Create a main panel with a border layout
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Adjust padding

        // Create a rounded border for the login and register panels
        Border roundedBorder = BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.BLACK, 1),
                BorderFactory.createLineBorder(Color.WHITE, 5) // Change to match background color
        );

        // Create left panel for login
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS)); // Vertical BoxLayout
        loginPanel.setPreferredSize(new Dimension(180, 150)); // Adjust size

        // Add login form components to the login panel
        loginPanel.add(new JLabel("Login Form"));
        // Add login form fields, buttons, etc., as needed

        // Set rounded border to the login panel
        loginPanel.setBorder(BorderFactory.createCompoundBorder(
                roundedBorder,
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Adjust padding
        ));

        // Create right panel for register
        JPanel registerPanel = new JPanel();
        registerPanel.setLayout(new BoxLayout(registerPanel, BoxLayout.Y_AXIS)); // Vertical BoxLayout
        registerPanel.setPreferredSize(new Dimension(180, 150)); // Adjust size

        // Add register form components to the register panel
        registerPanel.add(new JLabel("Register Form"));
        // Add register form fields, buttons, etc., as needed

        // Set rounded border to the register panel
        registerPanel.setBorder(BorderFactory.createCompoundBorder(
                roundedBorder,
                BorderFactory.createEmptyBorder(10, 10, 10, 10) // Adjust padding
        ));

        // Create a panel to contain both login and register panels side by side
        JPanel formContainer = new JPanel(new GridLayout(1, 2, 100, 0)); // 1 row, 2 columns
        formContainer.add(loginPanel);
        formContainer.add(registerPanel);

        // Add the form container to the main panel
        mainPanel.add(formContainer, BorderLayout.CENTER);

        // Add the main panel to the frame
        add(mainPanel);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginForm::new);
    }
}