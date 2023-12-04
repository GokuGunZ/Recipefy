package it.unipv.po.recipefy.Views;

import it.unipv.po.recipefy.Beans.User;
import it.unipv.po.recipefy.Controllers.MainFrameController;
import it.unipv.po.recipefy.Views.MainFrame.MainPanel;

import javax.swing.*;
import java.awt.*;

public class SearchPanel extends JPanel implements MainPanel {
    private User authedUser;

    public SearchPanel(MainFrameController mfc) {
        this.authedUser = mfc.getUser();
        this.setLayout(new BorderLayout());
        JLabel label = new JLabel("Search Panel Content");
        label.setHorizontalAlignment(SwingConstants.CENTER);
        this.add(label, BorderLayout.CENTER);
        JPanel searchFieldsPanel = new JPanel(new BorderLayout());
        searchFormPanel form1 = new searchFormPanel();
        searchFormPanel form2 = new searchFormPanel();
        searchFormPanel form3 = new searchFormPanel();
        searchFieldsPanel.add(form1, BorderLayout.NORTH);
        searchFieldsPanel.add(form2, BorderLayout.NORTH);
        searchFieldsPanel.add(form3, BorderLayout.NORTH);
        this.add(searchFieldsPanel);
    }

    private class searchFormPanel extends JPanel {
        private JTextField searchField;
        public searchFormPanel() {
            this.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
            searchField = new JTextField(30);
            JButton searchBtn = new JButton("Search");
            this.add(searchField);
            this.add(searchBtn);
        }


    }
    @Override
    public JPanel getPanel(){
        return this;
    }
}
