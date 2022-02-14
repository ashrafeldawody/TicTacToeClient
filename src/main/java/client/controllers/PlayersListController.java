package client.controllers;

import client.App;
import client.models.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PlayersListController implements Initializable {
    @FXML
    private TableView table;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        TableColumn usernameCol = new TableColumn("Name");
        usernameCol.setCellValueFactory(new PropertyValueFactory<>("username"));
        TableColumn pointsCol = new TableColumn("Points");
        pointsCol.setCellValueFactory(new PropertyValueFactory<>("points"));
        pointsCol.setSortType(TableColumn.SortType.DESCENDING);


        table.getColumns().addAll(usernameCol, pointsCol);


        table.getItems().setAll();



    }
    @FXML
    private void back(ActionEvent ae) throws IOException {
        App.setRoot("PlayerHome");
    }
    @FXML
    private void invite(ActionEvent ae){
        Player p = (Player) table.getSelectionModel().getSelectedItem();
        Player.sendGameRequest(p.username);
    }
    @FXML
    private void refresh(ActionEvent ae){

    }
}
