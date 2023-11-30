package Utility;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class DataCollector {
    public Image loadImage(String path){
        Image image = null;
        URL imageUrl = null;
        try {
            imageUrl = getClass().getResource(path);
        } catch (NullPointerException e){
            System.err.println(e);
            return image;
        }
        if (imageUrl != null) {
            image = Toolkit.getDefaultToolkit().getImage(imageUrl);
            if (image == null) {
                System.err.println("Failed to load image: " + imageUrl);
            }
        } else {
            System.err.println("Resource not found: " + path);
        }
        return image;
    }
    public ImageIcon loadImageIcon(String path){
        return new ImageIcon(getClass().getClassLoader().getResource(path));
    }
}
