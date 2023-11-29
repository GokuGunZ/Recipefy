package Views.User;

import Beans.User;
import Controllers.MainFrameController;
import Controllers.UpdateUserController;
import Models.UserModel;
import Views.UpdateableView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class UpdatePanel extends JPanel implements UpdateableView {
    private User authedUser;
    private JButton updateButton;
    private JTextField name;
    private JTextField bio;
    private JTextField favCous;
    private JTextField allerg;
    private JTextField email;
    private JPasswordField password;
    private JPasswordField oldPsw;
    private ActionListener updateButtonListener;
    public UpdatePanel(User user, MainFrameController mfc){
        this.authedUser = user;
        this.setLayout(new GridLayout(1,2));

        //Personal Info Panel
        JPanel personalInfoPanel = new JPanel(new BorderLayout());
        JPanel personalInfo = new JPanel(new GridLayout(4,2,20,100));

        personalInfo.add(new JLabel("Name"));
        JTextField newName = new JTextField(20);
        newName.setText(user.getName());
        name = newName;
        personalInfo.add(newName);

        personalInfo.add(new JLabel("Bio"));
        bio = new JTextField(20);
        bio.setText(user.getBio());
        personalInfo.add(bio);

        personalInfo.add(new JLabel("Favourite Cousine"));
        favCous = new JTextField(20);
        personalInfo.add(favCous);

        personalInfo.add(new JLabel("Allergens"));
        allerg = new JTextField(20);
        personalInfo.add(allerg);

        personalInfoPanel.add(personalInfo, BorderLayout.CENTER);

        updateButton = new JButton("Save Updated Information");
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (updateButtonListener != null) {
                    updateButtonListener.actionPerformed(e);
                }
            }
        });




        //Authentication Info Panel
        JPanel authInfoPanel = new JPanel(new BorderLayout());
        JPanel authInfoInnerPanel = new JPanel(new GridLayout(1,2));

        JPanel authInfo = new JPanel(new GridLayout(2,1));

        JPanel newAuthInfo = new JPanel(new GridLayout(4,1));

        newAuthInfo.add(new JLabel("eMail"));
        email = new JTextField(20);
        email.setText(user.getEmail());

        newAuthInfo.add(email);

        newAuthInfo.add(new JLabel("Password"));
        password = new JPasswordField(20);
        newAuthInfo.add(password);

        JPanel confirmInfo = new JPanel(new GridLayout(4,1));
        confirmInfo.add(new JLabel("Old Password for Confirmation"));
        oldPsw = new JPasswordField(20);
        confirmInfo.add(oldPsw);

        authInfo.add(newAuthInfo);
        authInfo.add(confirmInfo);

        JPanel saveAuthPanel = new JPanel(new BorderLayout());
        UpdateUserController updateController = new UpdateUserController(mfc, this, new UserModel(mfc));
        authInfoPanel.add(updateButton, BorderLayout.SOUTH);
        this.add(personalInfoPanel, BorderLayout.WEST);

        authInfo.add(saveAuthPanel, BorderLayout.SOUTH);
        authInfoInnerPanel.add(authInfo);
        authInfoInnerPanel.add(confirmInfo);
        authInfoPanel.add(authInfoInnerPanel);
        this.add(authInfoPanel, BorderLayout.EAST);

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
