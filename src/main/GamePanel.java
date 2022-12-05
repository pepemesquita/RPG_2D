package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import entidade.Player;
import object.SuperObject;
import tile.TileManager;

public class GamePanel extends JPanel implements Runnable {
	
	// configs de tela
	final int originalTileSize = 16;
	final int escala = 3;
	
	public final int tileSize = originalTileSize * escala;
	public final int maxColunas = 16;
	public final int maxLinhas = 12; //3:4 
	public final int largTela = tileSize * maxColunas; //768
	public final int altTela = tileSize * maxLinhas; //576
	
	public final int maxMap = 11;
	public int currentMap = 0;
	
	// System
	int fps = 60;
	TileManager tileM = new TileManager(this);
	KeyHandler keyH = new KeyHandler();
	Thread gameThread;
	public CollisionChecker cChecker = new CollisionChecker(this);
	public AssetSetter aSetter = new AssetSetter(this);
	Player player = new Player(this, keyH); 
	public SuperObject obj[][] = new SuperObject[maxMap][11]; // slots para objetos que irao aparecer na tela
	public EventHandler eHandler = new EventHandler(this);
	
	public GamePanel() {
		this.setPreferredSize(new Dimension(largTela, altTela));
		this.setBackground(Color.black);
		this.setDoubleBuffered(true);     
		this.addKeyListener(keyH);
		this.setFocusable(true);
	}
	
	public void setupGame() {
		aSetter.setObject();
	}
	
	public void startGameThread() {
		gameThread = new Thread(this);
		gameThread.start();
	}

	@Override
	public void run() {
		double drawInterval = 1000000000/fps;
		double delta = 0;
		long lastTime = System.nanoTime();
		long currentTime;
				
		while(gameThread != null) {
			currentTime= System.nanoTime();
			delta+= (currentTime - lastTime) / drawInterval;
			lastTime = currentTime;
			
			if(delta >= 1) {
				update();
				repaint();       //método do paintComponent
				delta--;
			}
		}
	}
	
	// atualiza as informações do player
	public void update() {
		player.update();
	}
	
	// desenha a informação atualizada
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics g2 = (Graphics2D)g;
		
		
		tileM.draw((Graphics2D) g2); //Back Ground
		
		for(int i = 0; i < obj.length; i++) {
			if(obj[currentMap][i] != null) {
				obj[currentMap][i].draw((Graphics2D) g2, this); //Objects
			}
		}
		
		player.draw((Graphics2D) g2); //Player
		g2.dispose();
	}
}