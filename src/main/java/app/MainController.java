package app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    ImageView imgGame1;

    public void searchGameTextField(){

    }

    public void buttonClicked(){

    }

    public void hoverButton(){

    }

    public void noHoverButton(){

    }

    public void paneGameClicked(){
        try {
            FXMLLoader loader = new FXMLLoader(Main.class.getResource("Game_detail.fxml"));
            Parent root = loader.load();
            Stage currentStage = (Stage) imgGame1.getScene().getWindow();
            Scene gamescene = new Scene(root);
            currentStage.setScene(gamescene);
            currentStage.setTitle(imgGame1.getId());
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
