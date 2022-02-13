/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tictactoe.Models;

import org.json.JSONObject;

/**
 *
 * @author ashra
 */
public class Player {
    public String username;
    public int points = 0;
    public Boolean online;
    public Player(String _username,int _points){
            username =_username;
            points = _points;
    }
    public static String login(String username,String password){
        JSONObject request = new JSONObject();
        request.put("action", "login");
        request.put("username", username);
        request.put("password", password);
        Server.sendRequest(request.toString());
        String str = Server.waitForResponse();
        return str;
    }
}
