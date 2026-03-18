package fr.perso.chess.view.components;

import javafx.scene.layout.GridPane;


public class BoardView extends GridPane {
    private final CellView[][] cellViews;
    
    public BoardView(){
        cellViews = new CellView[8][8];
    }

    public CellView[][] getAllCellViews(){
        return cellViews;
    }
}