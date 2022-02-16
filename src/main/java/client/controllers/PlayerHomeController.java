package client.controllers;

import client.App;
import client.models.Player;
import client.models.Server;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayerHomeController  implements Initializable {
    @FXML
    private Label usernamefield;
    @FXML
    private Label scorefield;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        usernamefield.setText(Player.player.username);
        scorefield.setText(String.valueOf(Player.player.points));
    }
    @FXML
    private void mouseEntered(MouseEvent ae){
        new SoundPlayer(SoundPlayer.SOUND.TICK).play();
    }
    @FXML
    private void singlePlay(ActionEvent ae){

    }
    @FXML
    private void multiPlay(ActionEvent ae) throws IOException {
        Player.getOnlineList();
        App.setRoot("PlayersList");
    }
    @FXML
    private void gameHistory(ActionEvent ae) throws IOException {
        App.setRoot("GameList");
    }
    @FXML
    private void exit(ActionEvent ae){
        Player.logout();
        System.exit(0);
    }
}
