package app;

import api.APIManager;
import api.GameNotFoundException;
import api.testapi;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Game;

import java.io.IOException;

import static api.APIManager.imgUrl;

import static api.APIManager.gameName;

public class MainController {

    private int currentIndex = 0;

    @FXML
    private TextField searchGameTextFieldId;

    @FXML
    private ImageView imgGame1, imgGame2, imgGame3, imgGame4, imgGame5, imgGame6, imgGame7, imgGame8, imgGame9, imgGame10, imgGame11, imgGame12, imgGame13, imgGame14, imgGame15, imgGame16, imgGame17, imgGame18;

    private ImageView[] imageViews;

    @FXML
    private Pane paneGame1, paneGame2, paneGame3, paneGame4, paneGame5, paneGame6, paneGame7, paneGame8, paneGame9, paneGame10, paneGame11, paneGame12, paneGame13, paneGame14, paneGame15, paneGame16, paneGame17, paneGame18;

    private Pane[] panesGame;

    @FXML
    private Label gameTitle1, gameTitle2, gameTitle3, gameTitle4, gameTitle5, gameTitle6, gameTitle7, gameTitle8, gameTitle9, gameTitle10, gameTitle11, gameTitle12, gameTitle13, gameTitle14, gameTitle15, gameTitle16, gameTitle17, gameTitle18;

    private Label[] gameTitles;
    @FXML
    public void initialize() {
        imageViews = new ImageView[] {imgGame1, imgGame2, imgGame3, imgGame4, imgGame5, imgGame6, imgGame7, imgGame8, imgGame9, imgGame10, imgGame11, imgGame12, imgGame13, imgGame14, imgGame15, imgGame16, imgGame17, imgGame18};
        gameTitles = new Label[] {gameTitle1, gameTitle2, gameTitle3, gameTitle4, gameTitle5, gameTitle6, gameTitle7, gameTitle8, gameTitle9, gameTitle10, gameTitle11, gameTitle12, gameTitle13, gameTitle14, gameTitle15, gameTitle16, gameTitle17, gameTitle18};
        panesGame = new Pane[] {paneGame1, paneGame2, paneGame3, paneGame4, paneGame5, paneGame6, paneGame7, paneGame8, paneGame9, paneGame10, paneGame11, paneGame12, paneGame13, paneGame14, paneGame15, paneGame16, paneGame17, paneGame18};
        for (int i = 0; i < panesGame.length; i++) {
            panesGame[i].setVisible(false);
        }
    }

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

        if (currentIndex < imageViews.length) {
            panesGame[currentIndex].setVisible(true);
            ImageView currentImageView = imageViews[currentIndex];
            currentImageView.setImage(image);
            currentImageView.setPreserveRatio(false);
            currentImageView.setFitHeight(200);
            Label currentGameTitle = gameTitles[currentIndex];
            currentGameTitle.setText(gameName);
            currentIndex++; // increment the index
            if (currentIndex >= imageViews.length) {
                currentIndex = 0; // wrap around to the beginning
            }
        } else {
            System.out.println("No more image views available");
        }
        System.out.println(searchText);
    }
}
