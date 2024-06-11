package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("Cross Games");
        stage.setScene(scene);
        stage.show();

        Stage gameDetailDialog = new Stage(StageStyle.DECORATED);
        gameDetailDialog.initModality(Modality.NONE);
        gameDetailDialog.initOwner(stage);

        FXMLLoader fxmlRulesLoader = new FXMLLoader(Main.class.getResource("Game_detail.fxml"));
        Scene sceneGameDetail = new Scene(fxmlRulesLoader.load());
        gameDetailDialog.setScene(sceneGameDetail);
        gameDetailDialog.setTitle("Règles");

        GameDetailController gameDetailController = (GameDetailController)fxmlRulesLoader.getController();
        gameDetailController.setMainController((MainController)fxmlLoader.getController());


    }

    public static void main(String[] args) {
        launch();
    }
}