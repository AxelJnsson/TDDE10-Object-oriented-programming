package space_invaders;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import java.util.concurrent.ThreadLocalRandom;

public class Enemy {

	private double height;
	private double width;
	private int x;
	private int y;
	private Color myColor;
	private Timeline movement;

	public Enemy(double height, double width, int x, int y, Color myColor) {
		this.height = height;
		this.width = width;
		this.x = x;
		this.y = y;
		this.myColor = myColor;
		
		this.movement = new Timeline();
		
		KeyFrame kf = new KeyFrame(Duration.seconds(1), (ae) -> {
			
			if(Math.random() <0.80) {
				int choice = ThreadLocalRandom.current().nextInt(0,4);
				if(choice == 0 && this.x > 0) {
					this.x -=5;
				} else if (choice == 1 && this.x <950){
					this.x +=5;
				} else if(choice == 2 && this.y >80) {
					this.y -= 15;
				} else if(choice == 3 && this.y < 400){
					this.y +=15;
				}
				
			}
		});
		
		movement.getKeyFrames().add(kf);
		movement.setCycleCount(-1);
	
		
	}

	public void drawYourself(GraphicsContext g, Image image) {
		
		g.setFill(new ImagePattern(image));
		
		g.fillRect(this.x, this.y, height, width);
	}

	public int getX() {
		return this.x;
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
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	public void play() {
		movement.play();
	}

	
	
	
}
