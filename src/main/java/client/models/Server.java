/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Alert;

/**
 *
 * @author ashra
 */
public abstract class Server {
    
    private static BufferedReader inputStream;
    private static PrintStream outputStream;
    public static Player player = null;
    private static Socket socket;
    public static void connect(String ipAddress, int portNumber) {
        try
        {
            socket = new Socket(InetAddress.getByName(ipAddress), portNumber);
            inputStream = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            outputStream = new PrintStream(socket.getOutputStream());

        } catch (IOException e)
        {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Error", "Failed to connect to server");
        }
        startListening();
    }
    public static void sendRequest(String line) {
        outputStream.println(line);
    }
    public static String waitForResponse(){
        String str = null;
        if(socket.isClosed()){
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Disconnected!", "Server Has been disconnected");
            return str;
        }
        try
        {
            str = inputStream.readLine();
        } catch (IOException ex)
        {
            Helpers.showDialog(Alert.AlertType.ERROR, "Failed", "Failed", "Server didn't respond");
        }
        return str;
    }
    public static void startListening() {
        new Thread(() ->
        {
            try
            {
                while (true)
                {
                    String str = inputStream.readLine();
                    System.err.println(str);
                    RequestHandler.handleRequest(str);
                }
            } catch (IOException ex)
            {
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }


}
