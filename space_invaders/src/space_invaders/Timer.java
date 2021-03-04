package space_invaders;

import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class Timer extends HBox{

	private int score;
	private Label timer;
	private Label info;
	private Label playHealth;
	private Timeline counter;
	
	public Timer(GameFrame frame) {
		this.score = 5000;
		setStyle("-fx-background-color: #d4d6d5;");
		setHeight(100);
		setWidth(1000);
		info = new Label("Score: ");
		timer = new Label(Integer.toString(score));
		Label health = new Label("   Health: ");
		playHealth = new Label();
		getChildren().add(info);
		getChildren().add(timer);
		getChildren().add(health);
	
	
		
		counter = new Timeline();
		
		KeyFrame kf = new KeyFrame(Duration.seconds(1), (ae) -> {
		score -=2;
		
		timer.setText(Integer.toString(score));
		
		
		});
		
		counter.getKeyFrames().add(kf);
		counter.setCycleCount(-1);
		}
	
	
	public void play() {
		counter.play();
	}

		
	}
	
	
