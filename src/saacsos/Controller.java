package saacsos;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class Controller {
    @FXML private ImageView image;
    @FXML private TextField inputText;
    @FXML private TextArea showText;

    private MyFile file;

    @FXML
    public void initialize() {
        image.setImage(new Image("images/cats.jpg"));
        String fs = File.separator;
        file = new MyFile(System.getProperty("user.dir")+ fs +"resources" + fs + "files", "data.txt");
        showText.setText(file.getContent());
    }

    @FXML
    public void appendText(ActionEvent event) {
        String text = inputText.getText();
        file.append(text);
        inputText.clear();
        showText.setText(file.getContent());
    }

    @FXML
    public void saveFile(ActionEvent event) {
        file.save();
    }


}
