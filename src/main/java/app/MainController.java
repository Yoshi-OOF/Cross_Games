package app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    public void searchGameTextField(){

    }

    public void buttonClicked(){

    }

    public void hoverButton(){

    }

    public void noHoverButton(){

    }

    public void paneGameClicked(MouseEvent event){
        Node source = (Node) event.getSource();
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Game_detail.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) source.getScene().getWindow();
            Scene gamescene = new Scene(root);
            currentStage.setScene(gamescene);
            currentStage.setTitle(source.getId());
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void homeButtonClicked(MouseEvent event){
        Node source = (Node) event.getSource();
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Main.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) source.getScene().getWindow();
            Scene gamescene = new Scene(root);
            currentStage.setScene(gamescene);
            currentStage.setTitle("Cross Games : Home");
            currentStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void hoverPaneGame(){

    }

    public void noHoverPaneGame(){

    }

}
