package Views.Recipe;

import Controllers.MainFrameController;
import Tests.RecipeCreationView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreatePanel extends JPanel {
    private MainFrameController mfc;
    private JTextField titleField;
    private JTextField descriptionField;
    private JPanel ingredientPanel;
    private JButton addIngredientButton;
    public CreatePanel(){
        //this.mfc = mfc;
        JFrame jf = new JFrame();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        titlePanel.add(new JLabel("Title"));
        titleField = new JTextField(20);
        titlePanel.add(titleField);
        this.add(titlePanel);

        JPanel descriptionPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        descriptionPanel.add(new JLabel("Description"));
        descriptionField = new JTextField(20);
        descriptionPanel.add(descriptionField);
        this.add(descriptionPanel);

        JPanel ingredientPanWBtn = new JPanel();
        ingredientPanel = new JPanel();
        ingredientPanel.setLayout(new BoxLayout(ingredientPanel, BoxLayout.Y_AXIS));
        addIngredientFields();
        addIngredientButton = new JButton("+");
        addIngredientButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addIngredientFields();
            }
        });
        ingredientPanWBtn.add(ingredientPanel);
        ingredientPanWBtn.add(addIngredientButton);
        this.add(ingredientPanWBtn);

        jf.add(this);
        jf.setVisible(true);
    }

    private void addIngredientFields() {
        JPanel newIngredientPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        newIngredientPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JTextField qtyField = new JTextField(5);
        JTextField unitField = new JTextField(10);
        JTextField entityField = new JTextField(20);

        newIngredientPanel.add(new JLabel("Qty:"));
        newIngredientPanel.add(qtyField);
        newIngredientPanel.add(new JLabel("Unit:"));
        newIngredientPanel.add(unitField);
        newIngredientPanel.add(new JLabel("Entity:"));
        newIngredientPanel.add(entityField);

        ingredientPanel.add(newIngredientPanel);
        ingredientPanel.revalidate();
        ingredientPanel.repaint();
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new CreatePanel();
        });
    }
}
