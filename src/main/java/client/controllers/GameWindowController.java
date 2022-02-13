/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package client.controllers;

import client.models.Game;
import client.models.Player;

import java.net.URL;
import java.util.ResourceBundle;

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

    Game g;
    Player p1;
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
        //p1 = new Player("Essam",Moves.X);
        //g = new Game(p1);
    }

    /*public void updateBoard() {
        if(g.board[0][0] != Moves.EMPTY) field1.setText(g.board[0][0].toString());
        if(g.board[0][1] != Moves.EMPTY) field2.setText(g.board[0][1].toString());
        if(g.board[0][2] != Moves.EMPTY) field3.setText(g.board[0][2].toString());
        if(g.board[1][0] != Moves.EMPTY) field4.setText(g.board[1][0].toString());
        if(g.board[1][1] != Moves.EMPTY) field5.setText(g.board[1][1].toString());
        if(g.board[1][2] != Moves.EMPTY) field6.setText(g.board[1][2].toString());
        if(g.board[2][0] != Moves.EMPTY) field7.setText(g.board[2][0].toString());
        if(g.board[2][1] != Moves.EMPTY) field8.setText(g.board[2][1].toString());
        if(g.board[2][2] != Moves.EMPTY) field9.setText(g.board[2][2].toString());

    }*/

    public void selectField(ActionEvent event) {
        if(GameOver) return;
        Button btn = (Button) event.getSource();
        String btnText = btn.getId();
        switch (btnText)
        {
            case "field1":
                field1.setText("O");
                break;
            case "field2":
                field2.setText("O");
                break;
            case "field3":
                field3.setText("O");
                break;
            case "field4":
                field4.setText("O");
                break;
            case "field5":
                field5.setText("O");
                break;
            case "field6":
                field6.setText("O");
                break;
            case "field7":
                field7.setText("O");
                break;
            case "field8":
                field8.setText("O");
                break;
            case "field9":
                field9.setText("O");
                break;
            default:
                throw new AssertionError();
        }
        //updateBoard();
    }

}
