package space_invaders;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileWriter;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;

/**
 * This is state you end up in when you play the game. Contains several methods which spawn power-ups and moves the player around for example.
 * @author martin
 *
 */
public class PlayState extends GameState {

	private int playPosX;
	private int playPosY;
	private int enemyPosX;
	private Player player;
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList<Projectile> enemyprojs = new ArrayList<>();
	private ArrayList<Wine> wines = new ArrayList<>();
	private ArrayList<Beer> beers = new ArrayList<>();
	private int projectileSpeed;
	private int projSpeedEnemy;
	private boolean bossLevel;

	private Image bg_1;
	private Image ch_1;
	private Image enemy_1;
	private Image pu_1;
	private Image pu_2;

	private Image bg_2;
	private Image ch_2;
	private Image enemy_2;

	private GameState menuState;
	private Timer timer;

	public PlayState(GameModel model, GameState menuState, boolean bossLevel, Timer timer) {
		super(model);
		this.timer = timer;
		playPosX = 500;
		playPosY = 650;
		this.menuState = menuState;
		projectileSpeed = 5;
		projSpeedEnemy = 5;
		this.bossLevel = bossLevel;

		player = new Player(50, 75, playPosX, playPosY, 3);

		enemyPosX = 50;
		for (int i = 0; i < 18; i++) {
			enemies.add(new Enemy(50, 75, enemyPosX, 80));
			enemies.get(i).setX(enemyPosX);
			enemyPosX += 50;

		}

		try {
			bg_1 = new Image(new FileInputStream("space.png"));
			ch_1 = new Image(new FileInputStream("elin.png"));
			enemy_1 = new Image(new FileInputStream("elli.png"));
			pu_1 = new Image(new FileInputStream("wine.png"));
			pu_2 = new Image(new FileInputStream("granges.png"));

			bg_2 = new Image(new FileInputStream("bg2.png"));
			ch_2 = new Image(new FileInputStream("axel.png"));
			enemy_2 = new Image(new FileInputStream("martin.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}

	}

	public void draw(GraphicsContext g) {

		if (this.bossLevel == false) {
			g.drawImage(bg_1, 0, 0);
		} else {
			g.drawImage(bg_2, 0, 0);
		}

		if (player.getLives() != 0) {
			if (this.bossLevel == false) {
				player.drawYourself(g, ch_1);
			} else {
				player.drawYourself(g, ch_2);
			}

		}

		for (int i = 0; i < enemies.size(); i++) {

			enemies.get(i).play();

			if (this.bossLevel == false) {

				enemies.get(i).drawYourself(g, enemy_1);

			} else {
				enemies.get(i).drawYourself(g, enemy_2);
			}

			if (Math.random() < 0.005) {
				enemyprojs
						.add(new Projectile(2, 7, enemies.get(i).getX() + 25, enemies.get(i).getY() + 37, Color.WHITE));

			}

			for (int a = 0; a < enemyprojs.size(); a++) {
				enemyprojs.get(a).drawYourself(g);
			}

		}

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).drawYourself(g);
		}

		for (int i = 0; i < wines.size(); i++) {
			wines.get(i).drawYourself(g, pu_1);
		}

		if (Math.random() < 0.01) {
			int pos = ThreadLocalRandom.current().nextInt(0, 950);
			wines.add(new Wine(40, 60, pos, -100));
		}

		for (int i = 0; i < beers.size(); i++) {
			beers.get(i).drawYourself(g, pu_2);
		}

		if (Math.random() < 0.01) {
			int pos = ThreadLocalRandom.current().nextInt(0, 950);
			beers.add(new Beer(40, 60, pos, -100));
		}

	}

	@Override
	public void update() {

		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).setY(projectiles.get(i).getY() - projectileSpeed);

			Rectangle2D rectProj = new Rectangle2D(projectiles.get(i).getX(), projectiles.get(i).getY(),
					projectiles.get(i).getWidth() - 2, projectiles.get(i).getHeight());

			for (int j = 0; j < enemies.size(); j++) {
				Rectangle2D rectEnemy = new Rectangle2D(enemies.get(j).getX(), enemies.get(j).getY(),
						enemies.get(j).getWidth() - 31, enemies.get(j).getHeight() + 32);

				if (rectProj.intersects(rectEnemy)) {
					enemies.remove(j);
					projectiles.remove(i);
				}

				if (projectiles.get(i).getY() <= -100) {
					projectiles.remove(i);
				}
			}

		}

		for (int i = 0; i < enemyprojs.size(); i++) {
			enemyprojs.get(i).setY(enemyprojs.get(i).getY() + projSpeedEnemy);

			Rectangle2D rectProj = new Rectangle2D(enemyprojs.get(i).getX(), enemyprojs.get(i).getY(),
					enemyprojs.get(i).getWidth() - 2, enemyprojs.get(i).getHeight());

			Rectangle2D rectPlayer = new Rectangle2D(player.getX(), player.getY(), player.getWidth() - 31,
					player.getHeight() + 32);

			if (rectProj.intersects(rectPlayer)) {
				player.setLives(player.getLives() - 1);
				timer.setPlayerHealth(timer.getPlayerHealth() - 1);
				enemyprojs.remove(i);
			}

			if (enemyprojs.get(i).getY() >= 800) {
				enemyprojs.remove(i);
			}

		}

		for (int i = 0; i < wines.size(); i++) {

			Rectangle2D rectWine = new Rectangle2D(wines.get(i).getX(), wines.get(i).getY(),
					wines.get(i).getWidth() - 2, wines.get(i).getHeight());

			Rectangle2D rectPlayer = new Rectangle2D(player.getX(), player.getY(), player.getWidth() - 31,
					player.getHeight() + 32);

			if (rectWine.intersects(rectPlayer)) {
				wines.remove(i);
				wines.get(i).power(player);
				timer.setPlayerHealth(timer.getPlayerHealth() + 1);
			}

			if (wines.get(i).getY() >= 800) {
				wines.remove(i);
			}

		}

		for (int i = 0; i < wines.size(); i++) {
			wines.get(i).setY(wines.get(i).getY() + 3);
		}

		for (int i = 0; i < beers.size(); i++) {

			Rectangle2D rectBeer = new Rectangle2D(beers.get(i).getX(), beers.get(i).getY(),
					beers.get(i).getWidth() - 2, beers.get(i).getHeight());

			Rectangle2D rectPlayer = new Rectangle2D(player.getX(), player.getY(), player.getWidth() - 31,
					player.getHeight() + 32);

			if (rectBeer.intersects(rectPlayer)) {
				beers.remove(i);
				beers.get(i).power(this);
			}

			if (beers.get(i).getY() >= 800) {
				beers.remove(i);
			}

		}

		for (int i = 0; i < beers.size(); i++) {
			beers.get(i).setY(beers.get(i).getY() + 3);
		}

		if (player.getLives() == 0) {
			timer.stop();
			this.model.setCurrentState(menuState);

		}

		if (enemies.size() == 0) {

			if (this.bossLevel == false) {

				for (int i = 0; i < projectiles.size(); i++) {
					projectiles.remove(i);
				}

				for (int i = 0; i < enemyprojs.size(); i++) {
					enemyprojs.remove(i);
				}

				for (int i = 0; i < beers.size(); i++) {
					beers.remove(i);
				}

				for (int i = 0; i < wines.size(); i++) {
					wines.remove(i);
				}
				this.bossLevel = true;

				Integer bossPosX = 50;
				for (int i = 0; i < 9; i++) {
					enemies.add(new Enemy(50, 75, bossPosX, 80));
					enemies.get(i).setX(bossPosX);
					bossPosX += 100;

				}

				this.projSpeedEnemy += 2;

			} else {
				timer.stop();

				try {
					File file = new File("highscore.txt");
					Scanner reader = new Scanner(file);

					ArrayList<Integer> scores = new ArrayList<>();

					while (reader.hasNextInt()) {

						scores.add(reader.nextInt());

					}

					scores.add(timer.getScore());
					Collections.sort(scores);

					PrintWriter cleaner = new PrintWriter(file);
					cleaner.print("");
					cleaner.close();

					BufferedWriter writer = new BufferedWriter(new FileWriter(file, true));

					if (scores.size() > 5) {
						scores.remove(0);
					}

					for (int i = scores.size() - 1; i >= 0; i--) {
						writer.write(Integer.toString(scores.get(i)));
						writer.newLine();
					}

					reader.close();
					writer.close();

					System.out.println("Successfully wrote to the file.");
				} catch (IOException e) {
					System.out.println("An error occurred.");
					e.printStackTrace();
				}

				this.model.setCurrentState(menuState);
			}
		}

	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getCode() + " i PlayState");

		if (key.getCode() == KeyCode.A) {

			if (player.getX() > 0) {
				player.setX(player.getX() - 8);
			}
		}

		if (key.getCode() == KeyCode.D) {
			if (player.getX() < 950) {
				player.setX(player.getX() + 8);
			}
		}

		if (key.getCode() == KeyCode.ENTER) {
			projectiles.add(new Projectile(2, 7, player.getX() + 25, playPosY, Color.WHITE));

		}

	}

	public int getProjectileSpeed() {
		return projectileSpeed;
	}

	public void setProjectileSpeed(int projectileSpeed) {
		this.projectileSpeed = projectileSpeed;
	}

}
