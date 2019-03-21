package bus;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DriverSceneController {
    static Stage stage;
    Scene scene;

    public void prepare() {
        // Loading the FXML file and setting its scene
        Parent root2 = null;

        try {
            root2 = FXMLLoader.load(getClass().getResource("DriverScene.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        scene = new Scene(root2, 788, 530);
    }

    public Scene getScene() {
        return scene;
    }
}
