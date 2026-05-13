package fr.perso.chess.view;

import javafx.scene.image.Image;

import java.util.HashMap;
import java.util.Map;

public class ImageFactory {
    private static final Map<String, Image> cache = new HashMap<>();
    private static final String BASE_PATH = "/fr/perso/chess/images/";

    // Charge les images en mémoire
    public static void preload() {
        String[] colors = {"White", "Black"};
        String[] types = {"Pawn", "Tower", "Knight", "Bishop", "Queen", "King"};

        for (String color : colors) {
            for (String type : types) {
                String filename = color + type + ".png";
                String fullPath = BASE_PATH + filename;
                try {
                    Image img = new Image(ImageFactory.class.getResourceAsStream(fullPath));
                    if (img.isError()) {
                        System.err.println("Erreur de chargement pour : " + fullPath);
                    } else {
                        cache.put(filename, img);
                    }
                } catch (Exception e) {
                    System.err.println("Fichier introuvable : " + fullPath);
                }
            }
        }
    }

    public static Image getImage(String color, String type) {
        String key = color + type + ".png";
        return cache.get(key);
    }
}