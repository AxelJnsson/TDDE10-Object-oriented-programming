package space_invaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;


/**
 * Represents one of the Power-Ups. This Power-Up grants you increased health.
 * @author martin
 *
 */
public class Wine {

	private double height;
	private double width;
	private int x;
	private int y;

	public Wine(double height, double width, int x, int y) {

		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;

	}

	public void power(Player player) {
		player.setLives(player.getLives() + 1);

	}

	public void drawYourself(GraphicsContext g, Image image) {
		g.setFill(new ImagePattern(image));
		g.fillRect(this.getX(), this.getY(), this.getHeight(), this.getWidth());

	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double getHeight() {
		return height;
	}

	public double getWidth() {
		return width;
	}

}
