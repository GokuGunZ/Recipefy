package Views.Category;

import Beans.Category;
import Views.UIComponents.AttributeShower;

import javax.swing.*;
import java.util.List;

public class _Manage extends JFrame {
    List<Category> categories;
    public _Manage(List<Category> categories){
        super("Category Manager");
        this.categories = categories;
        this.setSize(500, 700);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        add(new CategoryShower());
        this.setVisible(true);
    }
    class CategoryShower extends JPanel{
        private CategoryShower(){
            for (Category category : categories){
                add(new AttributeShower("Category: ", category.getCategoryName(), 20));
            }
        }
    }
}
