package space_invaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
/**
 * The bullets which spawns when the player presses ENTER and spawns randomly for enemies.
 * @author martin
 *
 */
public class Projectile {

	private double height;
	private double width;
	private int x;
	private int y;
	private Color myColor;

	public Projectile(double height, double width, int x, int y, Color myColor) {
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.myColor = myColor;
	}

	public void drawYourself(GraphicsContext g) {
		g.setFill(myColor);
		g.fillRect(this.x, this.y, height, width);
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


	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

}
