module fr.perso.chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens fr.perso.chess to javafx.fxml;
    exports fr.perso.chess;
    exports fr.perso.chess.view;
    opens fr.perso.chess.view to javafx.fxml;
    exports fr.perso.chess.view.components;
    opens fr.perso.chess.view.components to javafx.fxml;

    exports fr.perso.chess.model.pieces;
    exports fr.perso.chess.model.general;
    exports fr.perso.chess.controller;
    opens fr.perso.chess.controller to javafx.fxml;
}