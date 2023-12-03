package Models;

import Controllers.MainFrameController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UpdateableModel {
    boolean updateModel(List<Object> attributes) throws SQLException;
    void showModel(MainFrameController mfc) throws SQLException, IOException;
}
