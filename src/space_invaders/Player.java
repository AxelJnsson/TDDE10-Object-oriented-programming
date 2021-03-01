package space_invaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player {
	
	private double height;
	private double width;
	private int x;
	private int y;
	private Color myColor;

	public Player(double height, double width, int x, int y, Color myColor) {
		
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

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}
	
	
	
}
