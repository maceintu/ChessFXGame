package fr.perso.chess.view;

import java.util.HashMap;
import java.util.Map;

import fr.perso.chess.model.general.PlayerColor;
import fr.perso.chess.model.pieces.Piece;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;

public class PieceView extends StackPane {

    private static final Map<String, Image> cache = new HashMap<>();

    public PieceView(Piece piece) {
        String color = piece.getColor() == PlayerColor.WHITE ? "White" : "Black";
        String type = piece.getName();
        Image pieceImage = cache.computeIfAbsent(color + type + ".png", PieceView::loadImage);
        if (pieceImage != null) {
            ImageView imageView = new ImageView(pieceImage);
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            this.getChildren().add(imageView);
        } else
            System.err.println("image not found : " + color + type + ".png");
    }

    private static Image loadImage(String key) {
        String fullPath = "/" + key;
        Image img = new Image(PieceView.class.getResourceAsStream(fullPath));
        if (img.isError())
            throw new IllegalStateException(fullPath + " corrupted");
        return img;
    }
}