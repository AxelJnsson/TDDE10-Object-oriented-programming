package logic;

import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

/**
 * A HBox which displays the current score and the players current health.
 * @author martin
 *
 */
public class Timer extends HBox {

	private int score;
	private Label timer;
	private Label info;
	private Label playHealth;
	private Timeline counter;
	private int playerHealth;

	public Timer(GameFrame frame) {
		this.score = 5000;
		this.playerHealth = 3;
		setStyle("-fx-background-color: #d4d6d5;");
		setHeight(100);
		setWidth(1000);
		info = new Label("Score: ");
		timer = new Label(Integer.toString(score));
		Label health = new Label("   Health: ");
		playHealth = new Label(Integer.toString(playerHealth));
		getChildren().add(info);
		getChildren().add(timer);
		getChildren().add(health);
		getChildren().add(playHealth);

		counter = new Timeline();

		KeyFrame kf = new KeyFrame(Duration.seconds(0.1), (ae) -> {
			score -= 2;

			timer.setText(Integer.toString(score));
			playHealth.setText(Integer.toString(playerHealth));

		});

		counter.getKeyFrames().add(kf);
		counter.setCycleCount(-1);
	}

	public void play() {
		counter.play();
	}

	public void stop() {
		counter.stop();
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPlayerHealth() {
		return playerHealth;
	}

	public void setPlayerHealth(int playerHealth) {
		this.playerHealth = playerHealth;
	}

}
