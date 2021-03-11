package logic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.scene.canvas.GraphicsContext;

import javafx.scene.input.KeyEvent;

import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * The menustate displays the highscores and is where you will end up when the game is finished.
 * @author martin
 *
 */
public class MenuState extends GameState {

	private String info;
	private Color bgColor;
	private Color fontColor;
	private String data;

	public MenuState(GameModel model) {
		super(model);
		info = "WELCOME TO SPACE INVADERS\n                 HIGH SCORES";
		bgColor = Color.BLACK;
		fontColor = Color.GREEN;

	}

	@Override
	public void draw(GraphicsContext g) {
		drawBg(g, bgColor);
		g.setFill(fontColor);
		g.setFont(new Font(30));
		g.fillText(info, 250, 200);
		g.setFont(new Font(30));
		int i = 290;
		try {
			File hs = new File("highscore.txt");
			Scanner myReader = new Scanner(hs);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();
				g.fillText(data, 400, i);
				i += 30;
			}
			myReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}

	}

	@Override
	public void keyPressed(KeyEvent key) {

		System.out.println("Trycker på " + key.getText() + " i MenuState");

	}

	@Override
	public void update() {
	}

}
