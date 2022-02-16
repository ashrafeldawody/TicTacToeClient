package client.controllers;

import client.App;
import client.models.Game;
import client.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class gameRequestAcceptController implements Initializable {

    @FXML
    private Label playerLabel;
    @FXML
    private Button acceptBtn;
    @FXML
    private Button rejectBtn;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    public void accept(ActionEvent ae){
        Game.currentGame.acceptGameRequest();
        Game.currentGame = null;
    }
    @FXML
    public void reject(ActionEvent ae){
        Game.currentGame = null;
        App.setRoot("PlayerHome");
    }
    @FXML
    private void mouseEntered(MouseEvent ae){
        new SoundPlayer(SoundPlayer.SOUND.TICK).play();
    }

}
