/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package client.models;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 *
 * @author ashra
 */
public class Helpers {
    public static void showDialog(Alert.AlertType type,String title,String header,String content,Boolean exit){
        Platform.runLater(()->{
            Alert a = new Alert(type);
            a.setTitle(title);
            a.setHeaderText(header);
            a.setResizable(true);
            a.setContentText(content);
            a.showAndWait();
            if(exit) Platform.exit();
        });
    }
        public static void displayTray(String title,String text) {
        SystemTray tray = SystemTray.getSystemTray();
        Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
        TrayIcon trayIcon = new TrayIcon(image, "Client Notification");
        //Let the system resize the image if needed
        trayIcon.setImageAutoSize(true);
        //Set tooltip text for the tray icon
        trayIcon.setToolTip("Client Notification");
        try
        {
            tray.add(trayIcon);
        } catch (AWTException ex)
        {
            Logger.getLogger(Helpers.class.getName()).log(Level.SEVERE, null, ex);
        }
        trayIcon.displayMessage(title, text, MessageType.INFO);
    }
}
