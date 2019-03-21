package bus;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        // Setting class stages they are static

        MainSceneController.stage = primaryStage;
        DriverSceneController.stage = primaryStage;

        // ---------------------------------------------
        // Initializing Main Scene Controller and setting stage's scene to it

        MainSceneController mainSceneController = new MainSceneController();
        mainSceneController.prepare();
        primaryStage.setScene(mainSceneController.getScene());

        // -------------------------------------------------------------------
        // Initializing logic class Account and give it to main scene class
        Account account = new Account();
        mainSceneController.setAccount(account);
        // ---------------------------------
        primaryStage.setTitle("Bus Station");

        primaryStage.setResizable(false);
        primaryStage.show();
    }



}
