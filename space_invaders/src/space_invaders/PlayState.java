package space_invaders; 


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;


public class PlayState extends GameState {

	private Color bgColor;
	private Color fontColor;
	private GraphicsContext gc;
	private int playPosX;
	private int playPosY;
	private int enemyPosX;
	private Player player;
	private ArrayList<Projectile> projectiles = new ArrayList<>();
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private ArrayList <Projectile> enemyprojs = new ArrayList<>();
	private ArrayList<Power_Ups> powerUps = new ArrayList<>();
	
	private Image bg;
	private Image ch;
	private Image enemy;
	private Image pu_1;

	
	public PlayState(GameModel model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.GREEN;
		playPosX = 500;
		playPosY=650;
		//MenuState menuState = new MenuState(this.model);
		//t = 0;
		
		player = new Player(50,75,playPosX,playPosY,Color.BLUE,3);
		
		
		enemyPosX = 50;
		for(int i = 0; i < 18; i++) {
			enemies.add(new Enemy(50,75,enemyPosX, 80, Color.RED));
			enemies.get(i).setX(enemyPosX);
			enemyPosX += 50;	
			
		}
		
		
		try {
			bg = new Image(new FileInputStream("space.png"));
			ch = new Image(new FileInputStream("elin.png"));
			enemy = new Image(new FileInputStream("elli.png"));
			pu_1 =  new Image(new FileInputStream("beer.png"));
		} catch (FileNotFoundException e) {
			System.out.println("Unable to find image-files!");
		}
		
		powerUps.add(new Beer(40,60, 500, -100 ,Color.BLACK));
	}
	
	public void draw(GraphicsContext g) {
		g.drawImage(bg, 0, 0);
		
		if(player.getLives() != 0) {
		player.drawYourself(g, ch);
		}
		
		for(int i = 0; i < enemies.size(); i++) {
			
			enemies.get(i).play();
		
			enemies.get(i).drawYourself(g, enemy);
			
			if(Math.random() <0.005) {
				enemyprojs.add(new Projectile (2,7,enemies.get(i).getX()+25, enemies.get(i).getY()+37,Color.WHITE));
				
				
			}
			
			for(int a = 0; a < enemyprojs.size(); a++) {
				enemyprojs.get(a).drawYourself(g);
			}
			
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).drawYourself(g);
		}
		
		for(int i = 0; i<powerUps.size(); i++) {
			powerUps.get(i).drawYourself(g, pu_1);
		}
	}
	
	@Override
	public void activate() {
		//repaint();
	}
	
	@Override
	public void deactivate() {
		
	}

	@Override
	public void update() {
		
   for(int i = 0; i<projectiles.size(); i++) {
			projectiles.get(i).setY(projectiles.get(i).getY() - 5);
			
			Rectangle2D rectProj = new Rectangle2D(projectiles.get(i).getX(),projectiles.get(i).getY(),projectiles.get(i).getWidth()-2,projectiles.get(i).getHeight());
			
	for(int j = 0; j < enemies.size(); j++) {
			Rectangle2D rectEnemy = new Rectangle2D(enemies.get(j).getX(),enemies.get(j).getY(),enemies.get(j).getWidth()-31,enemies.get(j).getHeight()+32);
		
		if(rectProj.intersects(rectEnemy)) {
				enemies.remove(j);
				projectiles.remove(i);
			}
	}
			
		}
   
   for(int i = 0; i< enemyprojs.size(); i++) {
	   enemyprojs.get(i).setY(enemyprojs.get(i).getY() + 5);
   
	   Rectangle2D rectProj = new Rectangle2D(enemyprojs.get(i).getX(),enemyprojs.get(i).getY(),enemyprojs.get(i).getWidth()-2,enemyprojs.get(i).getHeight());
   
	   for(int j = 0; j < player.getLives(); j++) {
			Rectangle2D rectPlayer = new Rectangle2D(player.getX(),player.getY(),player.getWidth()-31 , player.getHeight()+32);
		
		if(rectProj.intersects(rectPlayer)) {
				player.setLives(player.getLives()-1);;
				enemyprojs.remove(i);
			}
	   
	   }
	   
   }
   
   for(int i = 0; i < powerUps.size(); i++) {
	   powerUps.get(i).setY(powerUps.get(i).getY()+5);
   }
   
	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getCode() + " i PlayState");

		if (key.getCode() == KeyCode.A) {
		
			if(player.getX() > 0) {
			player.setX(player.getX()-5);
			}
			}
		
		if (key.getCode() == KeyCode.D) {
			if(player.getX() < 950) {
			player.setX(player.getX()+5);
			}
		}
		
		if (key.getCode() == KeyCode.ENTER) {
			projectiles.add(new Projectile(2,7,player.getX()+25, playPosY,Color.WHITE));
		}
		
		
	}

	
	
	
}
