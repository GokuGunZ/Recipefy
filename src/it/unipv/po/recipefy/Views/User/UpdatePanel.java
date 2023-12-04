package it.unipv.po.recipefy.Views.User;

import it.unipv.po.recipefy.Beans.User;
import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Controllers.UpdateController;
import it.unipv.po.recipefy.Models.UserModel;
import it.unipv.po.recipefy.Views.UIComponents.UpdateFormPanel;
import it.unipv.po.recipefy.Views.UpdateableView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UpdatePanel extends JPanel implements UpdateableView {
    private ActionListener updateButtonListener;
    private User authedUser;
    private JButton updateButton;
    private JTextField name;
    private JTextField bio;
    private JTextField favCous;
    private JTextField allerg;
    private JTextField email;
    private JPasswordField password;
    private JPasswordField oldPsw;
    public UpdatePanel(User user, MainFrameController mfc){
        this.authedUser = user;
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setBorder(new EmptyBorder(40, 150, 20, 150));

        //Personal Info Panel;
        JPanel personalInfo = new JPanel();
        personalInfo.setLayout(new BoxLayout(personalInfo, BoxLayout.Y_AXIS));

        name = new JTextField(20);
        personalInfo.add(new UpdateFormPanel("Name: ", name, user.getName()));

        bio = new JTextField(20);
        personalInfo.add(new UpdateFormPanel("Bio: ", bio, user.getBio()));

        favCous = new JTextField(20);
        personalInfo.add(new UpdateFormPanel("Favourite Cuisine: ", favCous, "To be implemented"));

        allerg = new JTextField(20);
        personalInfo.add(new UpdateFormPanel("Allergens: ", allerg, "To be implemented"));



        updateButton = new JButton("Save Updated Information");
        updateButton.addActionListener(e -> {
            if (updateButtonListener != null) {
                updateButtonListener.actionPerformed(e);
            }
        });




        //Authentication Info Panel
        JPanel authInfoPanel = new JPanel();
        authInfoPanel.setLayout(new BoxLayout(authInfoPanel, BoxLayout.Y_AXIS));



        email = new JTextField(20);
        authInfoPanel.add(new UpdateFormPanel("eMail: ", email, user.getEmail()));

        JPanel passPanel = new JPanel();
        passPanel.add(new JLabel("Password"));
        password = new JPasswordField(20);
        passPanel.add(password);

        JPanel confirmInfo = new JPanel();
        confirmInfo.add(new JLabel("Old Password for Confirmation"));
        oldPsw = new JPasswordField(20);
        confirmInfo.add(oldPsw);

        authInfoPanel.add(passPanel);
        authInfoPanel.add(confirmInfo);

        JPanel saveAuthPanel = new JPanel();
        UpdateController updateController = new UpdateController(mfc, this, new UserModel(mfc));
        this.add(personalInfo);

        authInfoPanel.add(saveAuthPanel);
        authInfoPanel.add(confirmInfo);
        this.add(authInfoPanel);

        this.add(updateButton);
    }

    @Override
    public void setUpdateButtonListener(ActionListener listener){
        this.updateButtonListener = listener;
    }

    @Override
    public List<Object> getUpdateableAttributes(){
        List<Object> attributes = new ArrayList<>();
        attributes.add(name.getText());
        attributes.add(bio.getText());
        attributes.add(favCous.getText());
        attributes.add(allerg.getText());
        attributes.add(email.getText());
        attributes.add(new String(password.getPassword()));
        attributes.add(new String(oldPsw.getPassword()));
        return attributes;
    }

}
