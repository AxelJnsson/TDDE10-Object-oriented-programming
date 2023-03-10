package logic;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;

public class GameModel {

	private GameState currentState;

	public GameModel() {
		this.currentState = new MenuState(this);
	}

	public void draw(GraphicsContext g) {
		currentState.draw(g);
	}

	public void keyPressed(KeyEvent key) {
		currentState.keyPressed(key);
	}

	public void update() {
		currentState.update();
	}

	public GameState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(GameState currentState) {
		this.currentState = currentState;
	}

}
