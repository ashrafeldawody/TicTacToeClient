/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.models;

import javafx.scene.control.Alert;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author ashra
 */
public class RequestHandler {

    public static void handleRequest(String request) {
        if (!isJSONValid(request) || request.isEmpty())
        {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "Server Sent Unexpected Response");
            return;
        }
        JSONObject parsedRequest = new JSONObject(request);
        String action = (String) parsedRequest.get("action");
        if (Server.player == null)
        {
            switch (action)
            {
                case "login":
                   /* String status = (String) parsedRequest.get("status");

                    if (status.equals("success"))
                    {
                        JSONObject player = parsedRequest.getJSONObject("player");
                        Server.player = new Player(player.getString("username"), player.getInt("points"));
                    } else
                    {
                        Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "The username or password is incorrect");
                    }*/
                    break;
                case "register":

                    break;
            }
        } else
        {
            switch (action)
            {
                case "logout":
                    JSONObject player = parsedRequest.getJSONObject("player");
                    Server.player = new Player(player.getString("username"), player.getInt("points"));
                    break;
                case "register":

                    break;
            }
        }
    }

    private static boolean isJSONValid(String test) {
        try
        {
            new JSONObject(test);
        } catch (JSONException ex)
        {
            try
            {
                new JSONArray(test);
            } catch (JSONException ex1)
            {
                return false;
            }
        }
        return true;
    }
}
