/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.models;

import client.App;

import java.util.Date;

/**
 * @author ashraf
 */
public class Game {
    public static Game currentGame;
    public int id;
    public Player player1;
    public Player player2;
    public Player lastPlayed;
    public Date date;

    public Game(int _id, Player p1, Player p2, Date d) {
        id = _id;
        player1 = p1;
        player2 = p2;
        date = d;
    }

    public Game(Player p2) {
        player1 = Player.player;
        player2 = p2;
    }

    public void startGame() {
        App.setRoot("GameWindow");
    }

    public void sendGameRequest() {
        Server.sendRequest(JSONRequests.playRequest(player2.username).toString());
    }

    public void acceptGameRequest() {
        Server.sendRequest(JSONRequests.playAccept(player2.username).toString());
    }

    public void play(int index) {
        Server.sendRequest(JSONRequests.play(index).toString());
    }

    public void sendMessage(String message) {
        Server.sendRequest(JSONRequests.messageSend(message).toString());
    }
}
