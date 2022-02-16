/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.models;

import client.App;
import client.controllers.GameWindowController;
import javafx.application.Platform;
import javafx.scene.control.Alert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.pomo.toasterfx.model.impl.ToastTypes;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

/**
 * @author ashra
 */
public class ResponseHandler {
    public static ArrayList<Player> playersList = new ArrayList<>();
    public static ArrayList<Player> gamesList = new ArrayList<>();

    public static void handleResponse(String response) {
        System.out.println(response + "\n");
        if (!isJSONValid(response) || response.isEmpty()) {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "Server Sent Unexpected Response", false);
            return;
        }
        JSONObject parsedResponse = new JSONObject(response);
        String type = parsedResponse.getString("type");
        if (Player.player == null) {
            switch (type) {
                case "login":
                    handleLoginResponse(parsedResponse);
                    break;
                case "register":
                    handleRegisterResponse(parsedResponse);
                    break;
            }
        } else {
            switch (type) {
                case "logout":
                    JSONObject player = parsedResponse.getJSONObject("player");
                    Player.player = new Player(player.getString("username"), player.getInt("points"));
                    break;
                case "get-online-players":
                    handlePlayersList(response);
                    break;
                case "player-connected":
                    Helpers.displayTray("Player Connected", parsedResponse.getString("player") + " is connected", ToastTypes.LIST);
                    break;
                case "play-request":
                    handlePlayResponse(parsedResponse);
                    break;
                case "game-start":
                    handleGameStart(parsedResponse);
                    break;
                case "play":
                    if (GameWindowController.me != null && parsedResponse.getString("status").equalsIgnoreCase("success")) {
                        Platform.runLater(() -> {
                            GameWindowController.me.setMove(parsedResponse.getInt("index"), parsedResponse.getString("move"));
                        });
                    }
                    break;
                case "game-finish":
                    String status = parsedResponse.getString("status");
                    String axis = parsedResponse.getString("win-axis");

                    if (status.equalsIgnoreCase("win")) {
                        Platform.runLater(() -> {
                            GameWindowController.me.handleWin(axis,true);
                        });
                    } else if(status.equalsIgnoreCase("lose")) {
                        Platform.runLater(() -> {
                            GameWindowController.me.handleWin(axis,false);
                        });
                    }else{
                        Platform.runLater(() -> {
                            GameWindowController.me.handleDraw();
                        });
                    }
                    break;
                case "message":
                    System.out.println(parsedResponse);
                    GameWindowController.me.messageRecieved(parsedResponse.getString("from"),parsedResponse.getString("message"));
                    break;
                case "get-history":

                    break;
                case "replay":
                    break;
            }
        }
    }

    private static void handleGameStart(JSONObject response) {
        String status = response.getString("status");
        if (status.equals("success")) {
            String opponentMove = response.getString("move");
            Player.player.move = (opponentMove == "X" ? "O" : "X");
            Player opponent = new Player(response.getString("opponent"), opponentMove);
            Game.currentGame = new Game(opponent);
            App.setRoot("GameWindow");
        } else {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "Couldn't Start Game", false);
        }

    }

    private static void handlePlayResponse(JSONObject response) {
        String status = response.getString("status");
        if (status.equals("success")) {
            String opponent = response.getString("opponent");
            Game.currentGame = new Game(new Player(opponent, ""));
            App.setRoot("gameRequestAccept");
        } else {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", response.getString("opponent"), false);
        }
    }

    private static boolean isJSONValid(String test) {
        try {
            new JSONObject(test);
        } catch (JSONException ex) {
            try {
                new JSONArray(test);
            } catch (JSONException ex1) {
                return false;
            }
        }
        return true;
    }

    private static void handleLoginResponse(JSONObject response) {
        String status = response.getString("status");
        if (status.equals("success")) {
            JSONObject player = response.getJSONObject("player");
            Player.player = new Player(player.getString("username"), player.getInt("points"));
            App.setRoot("PlayerHome");
        } else {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "The username or password is incorrect", false);
        }
    }

    private static void handleRegisterResponse(JSONObject response) {
        String status = response.getString("status");
        if (status.equals("success")) {
            App.setRoot("LoginWindow");
        } else {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "The username already exist", false);
        }
    }

    private static void handlePlayersList(String resp) {
        playersList.clear();
        JSONObject JsonObj = new JSONObject(resp);
        for (Object object : JsonObj.getJSONArray("players")) {
            playersList.add(new Player(((JSONObject) object).getString("username"), ((JSONObject) object).getInt("points")));
        }
    }
}
