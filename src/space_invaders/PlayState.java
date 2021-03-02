package space_invaders; 


import java.util.ArrayList;
import java.util.Random;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
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
	private ArrayList<Player> lives = new ArrayList<>();
	//private double t;
	
	public PlayState(GameModel model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.GREEN;
		playPosX = 500;
		playPosY=700;
		//t = 0;
		
		lives.add(new Player(20,40,playPosX,playPosY,Color.BLUE));
		
		enemyPosX = 50;
		for(int i = 0; i < 20; i++) {
			enemies.add(new Enemy(20,40,enemyPosX, 80, Color.RED));
			enemies.get(i).setX(enemyPosX);
			enemyPosX += 50;
		}
	}
	
	public void draw(GraphicsContext g) {
		drawBg(g, bgColor);
		g.setFill(fontColor);
		
		if(lives.size() != 0) {
		lives.get(0).drawYourself(g);
		}
		
		for(int i = 0; i < enemies.size(); i++) {
		
			enemies.get(i).drawYourself(g);
			
			if(Math.random() <0.03) {
				enemyprojs.add(new Projectile (2,7,enemies.get(i).getX()+10, 120,Color.WHITE));
				
				
			}
			
			for(int a = 0; a < enemyprojs.size(); a++) {
				enemyprojs.get(a).drawYourself(g);
			}
			
		}
		
		for(int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).drawYourself(g);
		}
	}
	
	@Override
	public void activate() {
		//repaint();
	}
	
	@Override
	public void deactivate() {
		//gc.clearRect(0, 0, 1000, 750);
	}

	@Override
	public void update() {
		
   for(int i = 0; i<projectiles.size(); i++) {
			projectiles.get(i).setY(projectiles.get(i).getY() - 5);
			
			Rectangle2D rectProj = new Rectangle2D(projectiles.get(i).getX(),projectiles.get(i).getY(),projectiles.get(i).getWidth(),projectiles.get(i).getHeight());
			
	for(int j = 0; j < enemies.size(); j++) {
			Rectangle2D rectEnemy = new Rectangle2D(enemies.get(j).getX(),enemies.get(j).getY(),enemies.get(j).getWidth(),enemies.get(j).getHeight()+17);
		
		if(rectProj.intersects(rectEnemy)) {
				enemies.remove(j);
				projectiles.remove(i);
			}
	}
			
		}
   
   for(int i = 0; i< enemyprojs.size(); i++) {
	   enemyprojs.get(i).setY(enemyprojs.get(i).getY() + 5);
   
	   Rectangle2D rectProj = new Rectangle2D(enemyprojs.get(i).getX(),enemyprojs.get(i).getY(),enemyprojs.get(i).getWidth(),enemyprojs.get(i).getHeight());
   
	   for(int j = 0; j < lives.size(); j++) {
			Rectangle2D rectPlayer = new Rectangle2D(lives.get(j).getX(),lives.get(j).getY(),lives.get(j).getWidth() , lives.get(j).getHeight()+17);
		
		if(rectProj.intersects(rectPlayer)) {
				lives.remove(j);
				enemyprojs.remove(i);
			}
	   
	   }
	   
   }
   
	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getCode() + " i PlayState");

		if (key.getCode() == KeyCode.A) {
		
			lives.get(0).setX(lives.get(0).getX()-5);
			}
		
		if (key.getCode() == KeyCode.D) {
			lives.get(0).setX(lives.get(0).getX()+5);
		}
		
		if (key.getCode() == KeyCode.ENTER) {
			projectiles.add(new Projectile(2,7,lives.get(0).getX()+10, playPosY,Color.WHITE));
		}
		
		
	}
	
	
}
