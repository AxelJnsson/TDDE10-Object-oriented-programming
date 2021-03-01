package space_invaders; 


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
	private Player player;
	private Projectile proj;
	
	public PlayState(GameModel model) {
		super(model);
		bgColor = Color.BLACK;
		fontColor = Color.GREEN;
		playPosX = 500;
		playPosY=700;
		player = new Player(20,40,playPosX,playPosY,Color.BLUE);
		proj = new Projectile(10,10,playPosX,playPosY,Color.WHITE);
	}
	
	public void draw(GraphicsContext g) {
		drawBg(g, bgColor);
		g.setFill(fontColor);
		player.drawYourself(g, player.getX(), playPosY, Color.BLUE);
		proj.drawYourself(g, playPosX, proj.getY(),Color.WHITE);
		
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
		
	}

	@Override
	public void keyPressed(KeyEvent key) {
		System.out.println("Trycker på " + key.getCode() + " i PlayState");

		if (key.getCode() == KeyCode.A) {
		
			player.setX(player.getX()-5);
			}
		
		if (key.getCode() == KeyCode.D) {
			player.setX(player.getX()+5);
		}
		
		if (key.getCode() == KeyCode.P) {
			proj.setY(proj.getY()-10);
		}
		
		//if (key.getCode() == KeyCode.ESCAPE)
			//model.switchState(new MenuState(model));
		
	}
	
	
}
