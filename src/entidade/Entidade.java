package entidade;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Entidade {
	 public int x, y;
	 public int speed;
	 public int peso=0;
	 public boolean dialogo=false;
	 
	 public BufferedImage up1, up2, down1, down2, left1, left2, right1, right2;
	 public String direction;
	 
	 public int spriteCounter = 0;
	 public int spriteNum = 1;
	 
	 // 'hit-box' do player
	 public Rectangle areaSolida;
	 public int areaSolidaPadraoX, areaSolidaPadraoY;
	 public boolean colisaoON = false;
	 
	 public int vidaMax;
	 public int vida;
	 public int danoBase;
	 public int dano;
	 public boolean possuiEscudo = false;

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
}
