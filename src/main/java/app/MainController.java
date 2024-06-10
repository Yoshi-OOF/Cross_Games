package app;

import api.APIManager;
import api.GameNotFoundException;
import api.testapi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Game;

import java.io.IOException;

import static api.APIManager.imgUrl;

public class MainController {

    @FXML
    private TextField searchGameTextFieldId;

    @FXML
    private ImageView imgGame1, imgGame2, imgGame3, imgGame4, imgGame5, imgGame6, imgGame7, imgGame8, imgGame9, imgGame10, imgGame11, imgGame12, imgGame13, imgGame14, imgGame15, imgGame16, imgGame17, imgGame18;

    private ImageView[] imageViews = {imgGame1, imgGame2, imgGame3, imgGame4, imgGame5, imgGame6, imgGame7, imgGame8, imgGame9, imgGame10, imgGame11, imgGame12, imgGame13, imgGame14, imgGame15, imgGame16, imgGame17, imgGame18};



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
    


    public void searchGameButton() throws GameNotFoundException {
        Game newGame = new Game();
        String searchText = searchGameTextFieldId.getText();
        APIManager.setInformations(newGame, searchText);
        Image image = new Image(imgUrl);
        imgGame1.setImage(image);
        System.out.println(searchText);
    }
}
