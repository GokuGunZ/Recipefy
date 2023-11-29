package Controllers;

import Models.UpdateableModel;
import Views.UpdateableView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class UpdateUserController {
    MainFrameController mfc;
    UpdateableView updView;
    UpdateableModel updModel;
    public UpdateUserController(MainFrameController mfc, UpdateableView updView, UpdateableModel updModel){
        this.mfc = mfc;
        this.updView = updView;
        updView.setUpdateButtonListener(new UpdateButtonListener());
        this.updModel = updModel;
    }

    public class UpdateButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                updModel.updateModel(updView.getUpdateableAttributes());
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante l'update!");
                throw new RuntimeException(ex);
            }
        }
    }
}
