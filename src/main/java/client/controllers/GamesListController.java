package client.controllers;

import client.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class GamesListController implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    private void back(ActionEvent ae) throws IOException {
        App.setRoot("PlayerHome");
    }
    @FXML
    private void replay(ActionEvent ae){

    }

}
