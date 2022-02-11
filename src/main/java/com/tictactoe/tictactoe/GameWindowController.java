/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.tictactoe.tictactoe;

import com.tictactoe.tictactoe.Models.Game;
import com.tictactoe.tictactoe.Models.Moves;
import com.tictactoe.tictactoe.Models.Player;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
    private Label field1;
    @FXML
    private Label field2;
    @FXML
    private Label field3;
    @FXML
    private Label field4;
    @FXML
    private Label field5;
    @FXML
    private Label field6;
    @FXML
    private Label field7;
    @FXML
    private Label field8;
    @FXML
    private Label field9;
    @FXML
    private Line WinLine;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        p1 = new Player("Essam",Moves.X);
        g = new Game(p1);
        
        
    }

    public void updateBoard() {
        if(g.board[0][0] != Moves.EMPTY) field1.setText(g.board[0][0].toString());
        if(g.board[0][1] != Moves.EMPTY) field2.setText(g.board[0][1].toString());
        if(g.board[0][2] != Moves.EMPTY) field3.setText(g.board[0][2].toString());
        if(g.board[1][0] != Moves.EMPTY) field4.setText(g.board[1][0].toString());
        if(g.board[1][1] != Moves.EMPTY) field5.setText(g.board[1][1].toString());
        if(g.board[1][2] != Moves.EMPTY) field6.setText(g.board[1][2].toString());
        if(g.board[2][0] != Moves.EMPTY) field7.setText(g.board[2][0].toString());
        if(g.board[2][1] != Moves.EMPTY) field8.setText(g.board[2][1].toString());
        if(g.board[2][2] != Moves.EMPTY) field9.setText(g.board[2][2].toString());

    }

    public void selectField(MouseEvent event) {
        if(GameOver) return;
        Label label = (Label) event.getSource();
        String labelText = label.getId();
        switch (labelText)
        {
            case "field1":
                g.play(0, 0);
                break;
            case "field2":
                g.play(0, 1);
                break;
            case "field3":
                g.play(0, 2);

                break;
            case "field4":
                g.play(1, 0);

                break;
            case "field5":
                g.play(1, 1);

                break;
            case "field6":
                g.play(1, 2);

                break;
            case "field7":
                g.play(2, 0);

                break;
            case "field8":
                g.play(2, 1);

                break;
            case "field9":
                g.play(2, 2);

                break;
            default:
                throw new AssertionError();
        }
        updateBoard();
        if(g.checkWin() != Moves.EMPTY){
            GameOver = true;
            System.out.println("lol");
        }
    }

}
