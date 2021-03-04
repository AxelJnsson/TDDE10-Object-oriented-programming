package space_invaders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Player {
	
	private double height;
	private double width;
	private int x;
	private int y;
	private Color myColor;
	private Image character;
	private int lives;

	public Player (double height, double width, int x, int y, Color myColor, int lives) {
		
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.myColor = myColor;
		this.lives = lives;
		
		try {
		character = new Image(new FileInputStream("elin.png"));
		} catch(FileNotFoundException e) {
			System.out.println("File not found");
		}
		
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


	public void setHeight(double height) {
		this.height = height;
	}


	public double getWidth() {
		return width;
	}


	public void setWidth(double width) {
		this.width = width;
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
