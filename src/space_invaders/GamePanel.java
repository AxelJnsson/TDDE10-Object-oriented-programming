package space_invaders;

import javafx.scene.canvas.Canvas;

public class GamePanel extends Canvas{

	private GameModel model;
	
	public GamePanel(final GameModel model, int width, int height) {
		this.model = model;
		this.setWidth(width);
		this.setHeight(height);
	}
	
	  public void repaint() {
	    	model.draw(getGraphicsContext2D());
	    }

	public GameModel getModel() {
		return model;
	}

	public void setModel(GameModel model) {
		this.model = model;
	}
	  
	
}
