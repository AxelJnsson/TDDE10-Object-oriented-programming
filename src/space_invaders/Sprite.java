package space_invaders;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Sprite extends Rectangle {
    boolean dead = false;
    final String type;

    Sprite(int x, int y, int w, int h, String type, Color color) {
        super(w, h, color);

        this.type = type;
        setTranslateX(x);
        setTranslateY(y);
    }

   public void moveLeft() {
        setTranslateX(getTranslateX() - 5);
    }

   public void moveRight() {
        setTranslateX(getTranslateX() + 5);
    }

    public void moveUp() {
        setTranslateY(getTranslateY() - 5);
    }

   public void moveDown() {
        setTranslateY(getTranslateY() + 5);
    }
   
   
}
