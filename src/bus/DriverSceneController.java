package bus;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import java.io.IOException;

public class DriverSceneController {
    static Stage stage;
    private Account account;
    private Scene scene;
    private Scene homeScene;

    @FXML Label nameLabel;
    @FXML Button logoutButton;
    @FXML TableView tripsTable;


    public void prepare() {
        // Loading the FXML file and creating its scene
        Parent root = null;

        try {
            root = FXMLLoader.load(getClass().getResource("DriverScene.fxml"));
            scene = new Scene(root);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logoutButtonPressed(){
        stage.setScene(homeScene);
    }

    public Scene getScene() {
        return scene;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public void setHomeScene(Scene homeScene) {
        this.homeScene = homeScene;
    }
}
