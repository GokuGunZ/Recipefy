package it.unipv.po.recipefy.Factory.UserNavBarFactory;

import it.unipv.po.recipefy.Controllers.MainFrameController;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;

public class UserNavBarActionListenerFactory {
    public static ActionListener getActionListener(MainFrameController mfc, Class<? extends UserNavBarActionListenerInterface> listenerClass){
        try {
            Constructor<? extends UserNavBarActionListenerInterface> constructor = listenerClass.getConstructor(MainFrameController.class);
            UserNavBarActionListenerInterface listenerInterface = constructor.newInstance(mfc);
            return new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        listenerInterface.actionPerformed(e);
                    } catch (SQLException | IOException ex) {
                        ex.printStackTrace();
                    }
                }
            };
        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
            return null;
        }
    }
}
