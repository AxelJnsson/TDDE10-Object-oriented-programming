package space_invaders;

import javafx.scene.layout.HBox;

public class GameFrame extends HBox{
	private GamePanel g;
	
	public GameFrame(GameModel model, int width, int height) {
		
		g= new GamePanel(model,width,height);
		this.getChildren().add(g);
	}

	public void repaint() {
		g.repaint();
	}

	public GamePanel getG() {
		return g;
	}

	public void setG(GamePanel g) {
		this.g = g;
	}
	
}
