package Views.User;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

public class CategoryPanel extends JPanel {
    public CategoryPanel(){
        this.setLayout(new BorderLayout());

        JPanel CategoryPanel = new JPanel(new FlowLayout());
        JPanel tagPanel = new JPanel();
        tagPanel.setLayout(new BoxLayout(tagPanel, BoxLayout.X_AXIS));
        String[] tags = {"Tag1", "Tag2", "Tag3"};
        JList<String> tagList = new JList<>(tags);
        tagList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        tagList.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                //Update mainCatPanel
            }
        });
        JScrollPane listScrollPane = new JScrollPane(tagList);
        listScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        tagPanel.add(listScrollPane);
        CategoryPanel.add(tagPanel);

        JPanel mngTagPnl = new JPanel();
        JButton mngTagBtn = new JButton("Manage your tags");
        mngTagPnl.add(mngTagBtn);
        CategoryPanel.add(mngTagPnl);
        this.add(CategoryPanel);
    }
}
