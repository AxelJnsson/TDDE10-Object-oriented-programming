package space_invaders;

import java.util.concurrent.ThreadLocalRandom;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public abstract class Power_Ups {
	
	private double height;
	private double width;
	private int x;
	private int y;
	private Color myColor;
	private Timeline spawn;

	public Power_Ups (double height, double width, int x, int y, Color myColor) {	
	this.height = height;
	this.width = width;
	this.x = x;
	this.y = y;
	this.myColor = myColor;
	
	
	
	 this.spawn = new Timeline();
	
	KeyFrame kf = new KeyFrame(Duration.seconds(0.2), (ae) -> {
		
		if(Math.random() <0.80) {
			int pos = ThreadLocalRandom.current().nextInt(0,950);
			this.x = pos;
			
		}
	});
	
	spawn.getKeyFrames().add(kf);
	spawn.setCycleCount(-1);
	
	}
	
	public abstract void power(Player player);
	
	public abstract void drawYourself(GraphicsContext g, Image image);

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

	public void setHeight(double height) {
		this.height = height;
	}

	public double getWidth() {
		return width;
	}

	public void setWidth(double width) {
		this.width = width;
	}
	
	public void play() {
		spawn.play();
	}
	
	
	
}
