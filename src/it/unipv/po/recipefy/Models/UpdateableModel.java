package it.unipv.po.recipefy.Models;

import it.unipv.po.recipefy.Controllers.MainFrameController;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface UpdateableModel {
    boolean updateModel(List<Object> attributes) throws SQLException;
    void showModel(MainFrameController mfc) throws SQLException, IOException;
}
