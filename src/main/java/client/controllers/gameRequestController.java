package client.controllers;

import client.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class gameRequestController implements Initializable {
    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;
    @FXML
    private Label statusLabel;
    @FXML
    private Button tryAgainBtn;
    @FXML
    private Button cancelBtn;
    @FXML
    private ImageView loadingImg;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void tryAgain(ActionEvent ae){

    }
    @FXML
    private void cancel(ActionEvent ae) throws IOException {
        App.setRoot("PlayerHome");
    }
    @FXML
    private void mouseEntered(MouseEvent ae){
        new SoundPlayer(SoundPlayer.SOUND.TICK).play();
    }

}
