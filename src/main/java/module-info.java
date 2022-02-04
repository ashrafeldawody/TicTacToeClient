module com.tictactoe.tictactoe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.tictactoe.tictactoe to javafx.fxml;
    exports com.tictactoe.tictactoe;
}
