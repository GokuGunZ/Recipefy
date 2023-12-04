package Views.UIComponents;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class ImageUploaderPanel extends JPanel {
    private JLabel imageLabel;
    private String imagePath;
    private File imageFile;

    public ImageUploaderPanel() {
        setLayout(new BorderLayout());
        imagePath = null;

        imageLabel = new JLabel("Upload an image");
        imageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Font labelFont = new Font("Arial", Font.PLAIN, 12);
        imageLabel.setForeground(Color.gray);
        imageLabel.setFont(labelFont);
        add(imageLabel, BorderLayout.CENTER);

        JButton uploadButton = new JButton("Upload");
        uploadButton.addActionListener(e -> uploadImage());
        add(uploadButton, BorderLayout.SOUTH);
    }

    private void uploadImage() {
        JFileChooser fileChooser = new JFileChooser();
        int returnValue = fileChooser.showOpenDialog(null);

        if (returnValue == JFileChooser.APPROVE_OPTION) {
            imageFile = fileChooser.getSelectedFile();
            imagePath = setImagePath(imageFile);
            displayImage(imageFile);
        }
    }

    private void displayImage(File imageFile) {
        ImageIcon imageIcon = new ImageIcon(imageFile.getAbsolutePath());
        Image image = imageIcon.getImage().getScaledInstance(300, 200, Image.SCALE_DEFAULT);
        ImageIcon scaledIcon = new ImageIcon(image);
        imageLabel.setIcon(scaledIcon);
    }

    private void saveImage(File imageFile) throws URISyntaxException {
        if (imageFile == null){
            return;
        }
        URI imageUri = getClass().getResource("/images/").toURI();
        String imagePath = Paths.get(imageUri).toString();
        Path imageDirectory = Path.of(imagePath);

        if (!Files.exists(imageDirectory)) {
            try {
                Files.createDirectories(imageDirectory);
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }

        Path imageDestination = imageDirectory.resolve(imageFile.getName());

        try {
            Files.copy(imageFile.toPath(), imageDestination, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void saveImageFinal() throws URISyntaxException {saveImage(imageFile);}
    private String setImagePath(File imageFile){
        return "/images/"+imageFile.getName();
    }
    public String getImagePath(){return imagePath;}
}
