package fr.perso.chess.view;

import fr.perso.chess.model.general.PlayerColor;
import fr.perso.chess.model.pieces.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;

public class PieceView extends StackPane {
    public PieceView(Piece piece) {
        String colorString = (piece.getColor() == PlayerColor.WHITE) ? "White" : "Black";
        String typeString = piece.getClass().getSimpleName();
        Image pieceImage = ImageFactory.getImage(colorString, typeString);
        if (pieceImage != null) {
            ImageView imageView = new ImageView(pieceImage);
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            this.getChildren().add(imageView);
        } else {
            System.err.println("image not found : " + colorString + typeString + ".png");
        }
    }
}