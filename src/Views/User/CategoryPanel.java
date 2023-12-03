package Views.User;

import Beans.Category;
import Controllers.CategoryController;
import Controllers.MainFrameController;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public class CategoryPanel extends JPanel {
    MainFrameController mfc;
    List<Category> categoryList;
    JPanel recipePanel;
    public CategoryPanel(MainFrameController mfc, List<Category> categoryList){
        this.mfc = mfc;
        this.categoryList = categoryList;
        recipePanel = new JPanel();
        this.setLayout(new BorderLayout());

        JPanel CategoryPanel = new JPanel(new FlowLayout());
        JPanel tagPanel = new JPanel();
        tagPanel.setLayout(new BoxLayout(tagPanel, BoxLayout.X_AXIS));
        //JList<String> tagList = new JList<>(getStringArray(categoryList));
        JList<Integer> tagList = new JList<>(new Integer[]{5,6,7,8});
        tagList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tagList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                try {
                    CategoryController.renderRecipeCategory(mfc, tagList.getSelectedValue(), (UserPanel) mfc.getMainPanel());
                } catch (SQLException | IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
        JScrollPane listScrollPane = new JScrollPane(tagList);
        listScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tagPanel.add(listScrollPane);
        CategoryPanel.add(tagPanel);

        JPanel mngTagPnl = new JPanel();
        JButton mngTagBtn = new JButton("Manage your tags");
        mngTagBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CategoryController.renderCategoryManager(categoryList);
            }
        });
        mngTagPnl.add(mngTagBtn);
        CategoryPanel.add(mngTagPnl);
        this.add(CategoryPanel, BorderLayout.NORTH);
        this.add(recipePanel);

    }

    private String[] getStringArray(List<Category> categoryList){
        String[] list = new String[categoryList.size()];
        for (int i = 0; i < categoryList.size(); i++) {
            list[i] = categoryList.get(i).getCategoryName();
        }
        return list;
    }
}
