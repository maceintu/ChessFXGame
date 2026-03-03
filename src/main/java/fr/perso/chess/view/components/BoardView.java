package fr.perso.chess.view.components;

import fr.perso.chess.model.general.Cell;
import fr.perso.chess.model.general.GameController;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;

import java.util.HashMap;
import java.util.Map;

public class BoardView extends GridPane {
    private final Map<Cell, CellView> viewMap = new HashMap<>();

    public BoardView(GameController gc) {

        gc.setOnMovesAvailable(cells -> {
            clearHints();
            cells.forEach(this::showHintOn);
        });

        // 1. Configuration des contraintes de taille (8x8)
        for (int i = 0; i < 8; i++) {
            ColumnConstraints col = new ColumnConstraints();
            col.setPercentWidth(100.0 / 8);
            col.setHgrow(Priority.ALWAYS);
            this.getColumnConstraints().add(col);

            RowConstraints row = new RowConstraints();
            row.setPercentHeight(100.0 / 8);
            row.setVgrow(Priority.ALWAYS);
            this.getRowConstraints().add(row);
        }

        for (Cell cell : gc.getBoard().cellMap.values()) {
            CellView cellView = new CellView(cell, gc::onCellPressed);

            viewMap.put(cell, cellView);
            this.add(cellView, cell.position.col(), 7 - cell.position.row());
        }
    }

    public void clearHints() {
        viewMap.values().forEach(cv -> cv.showDot(false));
    }

    public void showHintOn(Cell cell) {
        CellView cv = viewMap.get(cell);
        if (cv != null) {
            cv.showDot(true);
        }
    }
}