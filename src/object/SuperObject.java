package object;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.GamePanel;

public class SuperObject {
	
	public BufferedImage image;
	public String name;
	public int dano;
	public int vidaMonstro;
	public boolean colisao = false;
	public int x, y;
	public Rectangle areaSolida = new Rectangle(0,0,48,48); //hit-box do object
	public int areaSolidaPadraoX = 0;
	public int areaSolidaPadraoY = 0;
	public int value;
	public int map;

	public int getValue(){
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public int getMap() {
		return map;
	}

	public void setMap(int map) {
		this.map = map;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw(Graphics2D g2, GamePanel gp) {
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}

