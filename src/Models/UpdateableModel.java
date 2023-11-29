package Models;

import java.sql.SQLException;
import java.util.List;

public interface UpdateableModel {
    void updateModel(List<Object> attributes) throws SQLException;
}
