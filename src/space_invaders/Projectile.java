package space_invaders;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

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
	
	public void drawYourself(GraphicsContext g, int x, int y, Color myColor) {
		g.setFill(myColor);
		g.fillRect(this.x, this.y, height, width);
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	

}
