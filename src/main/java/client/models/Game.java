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
    public Player me;
    public Player opponent;
    public Player lastPlayed;
    public String turn;
    public Date date;

    public Game(int _id, Player p1, Player p2, Date d) {
        id = _id;
        me = p1;
        opponent = p2;
        date = d;
    }

    public Game(Player p2) {
        me = Player.player;
        opponent = p2;
    }

    public static void rejectGameRequest() {
        Server.sendRequest(JSONRequests.playReject().toString());
    }

    public static void endCurrentGame() {
        if (Game.currentGame != null) Game.currentGame = null;
        ResponseHandler.tempOpponentUsername = null;
    }

    public void startGame() {
        App.setRoot("GameWindow");
    }

    public void sendGameRequest() {
        Server.sendRequest(JSONRequests.playRequest(opponent.username).toString());
    }

    public static void acceptGameRequest() {
        Server.sendRequest(JSONRequests.playAccept().toString());
    }

    public void play(int index) {
        Server.sendRequest(JSONRequests.play(index).toString());
    }

    public void sendMessage(String message) {
        Server.sendRequest(JSONRequests.messageSend(message).toString());
    }

    public Boolean isMyTurn() {

        if (me.move.equalsIgnoreCase(turn)) {
            return false;
        }
        return true;
    }
}
