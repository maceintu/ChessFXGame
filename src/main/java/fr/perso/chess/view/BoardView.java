package fr.perso.chess.view;

import javafx.scene.layout.GridPane;


public class BoardView extends GridPane {
    private final CellView[][] cellViews;
    
    public BoardView(){
        cellViews = new CellView[8][8];
        for (int r = 0; r < cellViews.length; r++) {
            for (int c = 0; c < cellViews.length; c++) {
                CellView cell = new CellView(r, c);
                cellViews[r][c] = cell;
                this.add(cell, c, r);
            }
        }
    }
    public CellView getCell(int row, int col) {
        return cellViews[row][col];
    }

    public CellView[][] getAllCellViews(){
        return cellViews;
    }
}