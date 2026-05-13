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

        // 3. On demande l'image au cache !
        Image pieceImage = ImageFactory.getImage(colorString, typeString);

        if (pieceImage != null) {
            // 4. On place l'image dans un ImageView (le lecteur d'image de JavaFX)
            ImageView imageView = new ImageView(pieceImage);

            // 5. On adapte la taille (Laisse un peu de marge par rapport aux 50px de ta case)
            imageView.setFitWidth(40);
            imageView.setFitHeight(40);
            imageView.setPreserveRatio(true); // Ne déforme pas l'image
            imageView.setSmooth(true); // Lissage pour faire joli

            // 6. On l'ajoute au centre du StackPane
            this.getChildren().add(imageView);
        } else {
            // SI L'IMAGE MANQUE (bug de nommage), on affiche un texte rouge d'erreur pour te prévenir !
            System.err.println("IMAGE NON TROUVÉE : " + colorString + typeString + ".png");
        }
    }
}