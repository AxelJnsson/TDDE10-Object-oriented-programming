package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

public abstract class GameState {

	protected GameModel model;

	public GameState(GameModel model) {
		this.model = model;
	}

	public abstract void update();

	public abstract void draw(GraphicsContext g);

	public abstract void keyPressed(KeyEvent key);

	public void drawBg(GraphicsContext g, Color color) {
		g.setFill(color);
		g.fillRect(0, 0, 1000, 800);
	}

}
