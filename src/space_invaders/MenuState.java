package space_invaders;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class MenuState extends GameState {

	private String info;
	private Color bgColor;
	private Color fontColor;
	private GraphicsContext gc;
	
	private PlayState playState;
	
	public MenuState(GameModel model) {
		super(model);
		playState = new PlayState(model);
		info = "Press PLAY to start the game!";
		bgColor = Color.BLACK;
		fontColor = Color.GREEN;
	}
	
	@Override
	public void draw(GraphicsContext g) {
		drawBg(g, bgColor);

		g.setFill(fontColor);
		g.setFont(new Font(30)); 
		g.fillText(info, 250, 200);
	}
	
	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getText() + " i MenuState");

		//if (key.getCode() == KeyCode.ENTER) {
		//	model.switchState(playState);
		//} else if (key.getCode() == KeyCode.ESCAPE) {
		//	System.exit(0);
		//}
	}
	
	@Override
	public void update() {
	}
	
	@Override
	public void activate() {

	}
	
	@Override
	public void deactivate() {
		//gc.clearRect(0, 0, 1000, 750);
	}

}
