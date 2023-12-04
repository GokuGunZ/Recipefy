package Controllers;

import Models.UpdateableModel;
import Views.UpdateableView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class UpdateController {
    MainFrameController mfc;
    UpdateableView updView;
    UpdateableModel updModel;
    public UpdateController(MainFrameController mfc, UpdateableView updView, UpdateableModel updModel){
        this.mfc = mfc;
        this.updView = updView;
        this.updModel = updModel;
        updView.setUpdateButtonListener(new UpdateButtonListener());
    }

    public class UpdateButtonListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            try {
                if(updModel.updateModel(updView.getUpdateableAttributes())){
                    updModel.showModel(mfc);
                }
            } catch (SQLException | IOException ex) {
                JOptionPane.showMessageDialog(null, "Errore durante l'update!");
                throw new RuntimeException(ex);
            }
        }
    }
}
