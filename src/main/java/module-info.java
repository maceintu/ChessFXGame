module fr.perso.chess {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;


    opens fr.perso.chess to javafx.fxml;
    exports fr.perso.chess;
    exports fr.perso.chess.frontend;
    opens fr.perso.chess.frontend to javafx.fxml;
    exports fr.perso.chess.frontend.components;
    opens fr.perso.chess.frontend.components to javafx.fxml;

    exports fr.perso.chess.backend.pieces;
    exports fr.perso.chess.backend.general;
}