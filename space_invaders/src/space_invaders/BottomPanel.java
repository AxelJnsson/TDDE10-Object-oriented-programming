package space_invaders;


import javafx.scene.control.Button;
import javafx.scene.layout.HBox;


/**
 * Creates the bottom panel which has a play and a quit button.
 * @author martin
 *
 */
public class BottomPanel extends HBox {

	private Button playButton;
	private Button quitButton;
	private GameFrame frame;
	private boolean close;

	public BottomPanel(GameFrame frame, Timer timer) {
		this.frame = frame;
		close = false;
		setStyle("-fx-background-color: #d4d6d5;");
		setHeight(100);
		setWidth(1000);
		playButton = new Button("Play");
		quitButton = new Button("Quit");
		getChildren().add(playButton);
		getChildren().add(quitButton);

		playButton.setOnAction(event -> {
			this.frame.getG().getModel().setCurrentState(
					new PlayState(frame.getG().getModel(), frame.getG().getModel().getCurrentState(), false, timer));
			timer.setScore(5000);
			timer.setPlayerHealth(3);
			timer.play();

		});
		quitButton.setOnAction(event -> {
			this.setClose(true);
		});

	}

	public boolean isClose() {
		return close;
	}

	public void setClose(boolean close) {
		this.close = close;
	}

}
