/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.controllers;

import client.App;
import client.models.Helpers;
import client.models.Server;
import client.models.Player;

import java.io.IOException;
import javafx.scene.control.Alert;
import org.json.JSONObject;

/**
 *
 * @author ashra
 */
public class ResponseHandler {

    public static void handleLogin(String response) throws IOException {
        JSONObject parsedRequest = new JSONObject(response);
        String status = (String) parsedRequest.get("status");

        if (status.equals("success"))
        {
            JSONObject player = parsedRequest.getJSONObject("player");
            Server.player = new Player(player.getString("username"), player.getInt("points"));
            App.setRoot("/fxml/GameWindow");
        } else
        {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "The username or password is incorrect");
        }
    }
}
