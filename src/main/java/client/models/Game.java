/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.models;

import client.App;

import java.util.Date;

/**
 *
 * @author ashraf
 */
public class Game {
    public static Game currentGame;
    private int id;
    private String player1;
    private String player2;
    private Date date;
    public Game(int _id, String p1,String p2,Date d){
        id = _id;
        player1 = p1;
        player2 = p2;
        date = d;
    }
    public Game(String p2){
        player1 = Player.player.username;
        player2 = p2;
    }
    public void startGame(){
        App.setRoot("GameWindow");
    }
    public void sendGameRequest(){
        Server.sendRequest(JSONRequests.playRequest(player2).toString());
    }
    public void acceptGameRequest(){
        Server.sendRequest(JSONRequests.playAccept(player2).toString());
    }
    public void play(int index){
        Server.sendRequest(JSONRequests.play(index).toString());
    }
}
