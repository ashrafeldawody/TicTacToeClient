/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package client.controllers;

import client.models.Game;
import client.models.Player;

import java.net.URL;
import java.util.ResourceBundle;

import client.models.Server;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Line;

/**
 * FXML Controller class
 *
 * @author ashraf
 */
public class GameWindowController implements Initializable {
    public static GameWindowController me;

    public String myMove;

    private Boolean GameOver = false;

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
    private Line WinLine;
    public void initialize(URL url, ResourceBundle rb) {
        me = this;
    }

    public void setMove(int index,String move){
        switch(index){
            case 1:
                field1.setText(move);
                break;
            case 2:
                field2.setText(move);
                break;
            case 3:
                field3.setText(move);
                break;
            case 4:
                field4.setText(move);
                break;
            case 5:
                field5.setText(move);
                break;
            case 6:
                field6.setText(move);
                break;
            case 7:
                field7.setText(move);
                break;
            case 8:
                field8.setText(move);
                break;
            case 9:
                field9.setText(move);
                break;
        }
    }
    public void selectField(ActionEvent event) {
        if(GameOver) return;
        Button btn = (Button) event.getSource();
        String btnText = btn.getId();
        int index = Integer.parseInt(btnText.substring(btnText.length() - 1));
        Game.currentGame.play(index);
        //updateBoard();
    }
    public void mouseEntered(MouseEvent me){

    }
}
