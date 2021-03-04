package space_invaders;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class BottomPanel extends HBox {
	
	private Button playButton;
	private Button quitButton;
	private PlayState playState;
	private GameFrame frame;
	private boolean close;
	
	public BottomPanel(GameFrame frame) {
		this.frame = frame;
		Timer timer = new Timer(frame);
		close = false;
		setStyle("-fx-background-color: #d4d6d5;");
		setHeight(100);
		setWidth(1000);
		playButton  = new Button("Play");
		quitButton = new Button("Quit");
		getChildren().add(playButton);
		getChildren().add(quitButton);
		playState = new PlayState(frame.getG().getModel());
		
		playButton.setOnAction(event -> {
			this.frame.getG().getModel().setCurrentState(playState);
			//timer.play();
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
