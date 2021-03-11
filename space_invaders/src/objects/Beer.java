package objects;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import logic.PlayState;

/**
 * Represents one of the Power-Ups. This Power-Up grants you increased projectile speed.
 * @author martin
 *
 */
public class Beer {

	private double height;
	private double width;
	private int x;
	private int y;

	public Beer(double height, double width, int x, int y) {
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;

	}

	public void power(PlayState play) {
		play.setProjectileSpeed(play.getProjectileSpeed() + 1);

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
