package space_invaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class Enemy {

	private double height;
	private double width;
	private int x;
	private int y;
	private Color myColor;

	public Enemy(double height, double width, int x, int y, Color myColor) {
		height = 20;
		width = 15;
		this.x = x;
		this.y = y;
		myColor = Color.RED;
		
	}

	public void drawYourself(GraphicsContext g, double x, double y, Color myColor) {
		g.setFill(myColor);
		g.fillRect(this.x, this.y, height, width);
	}
	
}
