package space_invaders;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;

import javafx.scene.Scene;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class Main extends Application {

	public static void main(String[] args) {

		launch(args);

	}

	@Override
	public void start(Stage gameStage) throws Exception {

		gameStage.setTitle("SPACE INVADERS");

		gameStage.setWidth(1000);
		gameStage.setHeight(800);

		VBox layout = new VBox();
		GameModel model = new GameModel();
		GameFrame frame = new GameFrame(model, 1000, 730);
		Timer timer = new Timer(frame);
		HBox bot = new BottomPanel(frame, timer);

		layout.getChildren().add(timer);
		layout.getChildren().add(frame);
		layout.getChildren().add(bot);
		Scene gameScene = new Scene(layout);

		final double targetFps = 50.0;
		final double nanoPerUpdate = 1000000000.0 / targetFps;

		gameStage.setScene(gameScene);

		gameScene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				// We send it on to the model, to handle it in the various
				// states of the game.
				model.keyPressed(event);
			}
		});

		new AnimationTimer() {
			long lastUpdate = 0;

			// This method will be called
			public void handle(long now) {
				// Perform game update and game rendering. This will
				// execute approximately 60 times per second, or as
				// close to that as possible. Can vary greatly between systems.
				// If we want closer control we use something like the
				// if-statement below to control frame rate.

				if ((now - lastUpdate) > nanoPerUpdate) {
					if (((BottomPanel) bot).isClose() == true) {
						gameStage.close();
					}
					model.update();
					frame.repaint();
					lastUpdate = now;

				}
			}
		}.start(); // We start the timer.

		gameStage.show();

	}
}