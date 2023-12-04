package Controllers.NavBarListener;

import Controllers.MainFrameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;

public class PersonalCookBookListener implements ActionListener {
    private final MainFrameController mfc;

    public PersonalCookBookListener(MainFrameController mfc) {
        this.mfc = mfc;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            mfc.createAndDisplayUserPan();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }
}