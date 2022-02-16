/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package client.controllers;

import client.App;
import client.models.Game;
import client.models.Helpers;
import client.models.Player;

import java.net.URL;
import java.util.ResourceBundle;

import client.models.Server;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;

/**
 * FXML Controller class
 *
 * @author ashraf
 */
public class GameWindowController implements Initializable {
    public static GameWindowController me;

    private Boolean GameOver = false;

    @FXML
    private AnchorPane rootAnchorPane;
    @FXML
    private Button field1;
    @FXML
    private Button field2;
    @FXML
    private Button field3;
    @FXML
    private Button field4;
    @FXML
    private Button field5;
    @FXML
    private Button field6;
    @FXML
    private Button field7;
    @FXML
    private Button field8;
    @FXML
    private Button field9;
    @FXML
    private Label myUsername;
    @FXML
    private Label myMove;
    @FXML
    private Label opponentUsername;
    @FXML
    private Label opponentMove;
    @FXML
    private Label headerLabel;
    @FXML
    private FontAwesomeIconView arrowToMe;
    @FXML
    private FontAwesomeIconView arrowToOpponent;
    @FXML
    private TextArea chatBox;
    @FXML
    private TextField chatTextField;
    @FXML
    private VBox finalButtonsPane;

    public void initialize(URL url, ResourceBundle rb) {
        me = this;
        myUsername.setText(Game.currentGame.player1.username);
        myMove.setText(Game.currentGame.player1.move);
        opponentUsername.setText(Game.currentGame.player2.username);
        opponentMove.setText(Game.currentGame.player2.move);
    }

    public void setMove(int index, String move) {
        new SoundPlayer(SoundPlayer.SOUND.PLAYER_ACTION_A).play();
        switch (index) {
            case 0:
                field1.setText(move);
                break;
            case 1:
                field2.setText(move);
                break;
            case 2:
                field3.setText(move);
                break;
            case 3:
                field4.setText(move);
                break;
            case 4:
                field5.setText(move);
                break;
            case 5:
                field6.setText(move);
                break;
            case 6:
                field7.setText(move);
                break;
            case 7:
                field8.setText(move);
                break;
            case 8:
                field9.setText(move);
                break;
        }
    }

    public void selectField(ActionEvent event) {
        if (GameOver) return;
        Button btn = (Button) event.getSource();
        String btnText = btn.getId();
        int index = Integer.parseInt(btnText.substring(btnText.length() - 1));
        Game.currentGame.play(index - 1);
        //updateBoard();
    }

    public void mouseEntered(MouseEvent me) {

    }

    @FXML
    private void sendMessage(ActionEvent ae) {
        String message = chatTextField.getText().trim();
        if (message.isEmpty()) {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Error", "You can't send empty message", false);
            return;
        }
        chatBox.appendText(message);
        Game.currentGame.sendMessage(Player.player.username + ": " + message + "\n");
        chatTextField.setText("");
    }

    @FXML
    private void share(ActionEvent ae) {
    }

    @FXML
    private void playAgain(ActionEvent ae) {
    }

    @FXML
    private void back(ActionEvent ae) {
        App.setRoot("PlayerHome");
    }

    public void handleDraw() {
        headerLabel.setTextFill(Color.BLUE);
        headerLabel.setVisible(true);
        new SoundPlayer(SoundPlayer.SOUND.GAME_DRAW).play();
        headerLabel.setText("DRAW");
    }

    public void handleWin(String axis, Boolean win) {
        Paint color;
        if (win) {
            color = Color.GREEN;
            new SoundPlayer(SoundPlayer.SOUND.GAME_VICTORY).play();
            headerLabel.setText("You Won!");
        } else {
            color = Color.RED;
            new SoundPlayer(SoundPlayer.SOUND.GAME_DEFEAT).play();
            headerLabel.setText("You Lost");
        }

        headerLabel.setTextFill(color);
        headerLabel.setVisible(true);

        switch (axis) {
            case "012":
                field1.setTextFill(color);
                field2.setTextFill(color);
                field3.setTextFill(color);
                break;
            case "345":
                field4.setTextFill(color);
                field5.setTextFill(color);
                field6.setTextFill(color);

                break;
            case "678":
                field7.setTextFill(color);
                field8.setTextFill(color);
                field9.setTextFill(color);

                break;
            case "036":
                field1.setTextFill(color);
                field4.setTextFill(color);
                field7.setTextFill(color);

                break;
            case "147":
                field2.setTextFill(color);
                field5.setTextFill(color);
                field8.setTextFill(color);

                break;
            case "258":
                field3.setTextFill(color);
                field6.setTextFill(color);
                field9.setTextFill(color);

                break;
            case "048":
                field1.setTextFill(color);
                field5.setTextFill(color);
                field9.setTextFill(color);

                break;
            case "246":
                field3.setTextFill(color);
                field5.setTextFill(color);
                field7.setTextFill(color);

                break;
        }
    }

    public void messageRecieved(String sender, String message) {
        chatBox.appendText(sender + ": " + message + "\n");
    }
}
