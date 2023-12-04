package it.unipv.po.recipefy.Views;


import java.awt.event.ActionListener;
import java.util.List;

public interface UpdateableView {
    List<Object> getUpdateableAttributes();

    void setUpdateButtonListener(ActionListener listener);
}
