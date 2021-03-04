package space_invaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;

public class Beer extends Power_Ups {
	
	public Beer(double height, double width, int x, int y, Color myColor) {
		super(height,width,x,y,myColor);
		
	}

	@Override
	public void power(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void drawYourself(GraphicsContext g, Image image) {
		g.setFill(new ImagePattern(image));
		g.fillRect(this.getX(), this.getY(), this.getHeight(), this.getWidth());

	}

}
