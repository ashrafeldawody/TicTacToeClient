/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.models;

import client.App;
import javafx.scene.control.Alert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

/**
 * @author ashra
 */
public class ResponseHandler {

    public static void handleResponse(String response) {
        if (!isJSONValid(response) || response.isEmpty()) {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "Server Sent Unexpected Response", false);
            return;
        }
        JSONObject parsedResponse = new JSONObject(response);
        String type = parsedResponse.getString("type");
        if (Server.player == null) {
            switch (type) {
                case "login":
                    handleLoginResponse(parsedResponse);
                    break;
                case "register":

                    break;
            }
        } else {
            switch (type) {
                case "logout":
                    JSONObject player = parsedResponse.getJSONObject("player");
                    Server.player = new Player(player.getString("username"), player.getInt("points"));
                    break;
                case "register":

                    break;
            }
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
        if (status.equals("success")){
            JSONObject player = response.getJSONObject("player");
            Server.player = new Player(player.getString("username"), player.getInt("points"));
            App.setRoot("PlayerHome");
        }else{
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "The username or password is incorrect",false);
        }
    }

    private static void handlePlayersList(String resp){
        ArrayList<Player> playersList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray(resp);
        for(Object object: jsonArray){
            playersList.add(new Player(((JSONObject)object).getString("username"),((JSONObject)object).getInt("points")));
        }
        //add to table somehow
    }
}
