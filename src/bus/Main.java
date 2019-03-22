package bus;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        // Initializing Login Scene and giving it the stage
        // Initializing logic class Account and give it to Login Scene class
        Account account = new Account();
        LoginScene loginScene = new LoginScene(primaryStage, account);

        primaryStage.setScene(loginScene.getScene());
        primaryStage.setTitle("Bus Station");
        primaryStage.setResizable(false);
        primaryStage.show();
    }


}
