package objects;



import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import javafx.scene.paint.ImagePattern;

/**
 * The player is the character you play as. It draws it self and has getters and setters which helps you move it around at the playing field.
 * @author martin
 *
 */
public class Player {

	private double height;
	private double width;
	private int x;
	private int y;
	private int lives;

	public Player(double height, double width, int x, int y, int lives) {

		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.lives = lives;

	}

	public void drawYourself(GraphicsContext g, Image image) {
		g.setFill(new ImagePattern(image));
		g.fillRect(this.x, this.y, height, width);

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}


	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

}
