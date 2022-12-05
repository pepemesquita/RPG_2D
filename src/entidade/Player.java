package entidade;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entidade{
	GamePanel gp;
	KeyHandler keyH;
	int ultimoLado=0;
	int key = 0;
	int moedas = 0;
	
	public Player (GamePanel gp, KeyHandler keyH) {
		this.gp = gp;
		this.keyH = keyH; 
		
		areaSolida = new Rectangle();
		areaSolida.x = 8;
		areaSolida.y = 16;
		areaSolidaPadraoX = areaSolida.x;
		areaSolidaPadraoY = areaSolida.y;
		areaSolida.width = 32;
		areaSolida.height = 32;
		
		
		setValoresPadrao();
		getPlayerImage();
	}
	
	public void setValoresPadrao() {
		x = 100;
		y = 100;
		speed = 3;
		direction = "baixo";
		vidaMax = 25;
		vida = vidaMax;
		danoBase = 2;
		dano = danoBase;
	}
	
	public void getPlayerImage() {
		try {
			up1 = ImageIO.read(getClass().getResourceAsStream("/player/cima.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/player/cima2.png"));
			down1 = ImageIO.read(getClass().getResourceAsStream("/player/baixo.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/player/baixo2.png"));
			left1 = ImageIO.read(getClass().getResourceAsStream("/player/esquerda.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/player/esquerda2.png"));
			right1 = ImageIO.read(getClass().getResourceAsStream("/player/direita.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/player/direita2.png"));
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void update () {   // metodo chamado 60 vezes por segundo
		if(moedas <1000) {
			peso = 1;
		}else if(moedas >= 1000 && moedas < 2000){
			peso = 2;
		}else if(moedas >= 2000 && moedas < 3000){
			peso = 3;
		}else if(moedas >= 3000 && moedas < 4000){
			peso = 4;
		}else if(moedas >= 4000 && moedas < 5000){
			peso = 5;
		}
		if (keyH.cimaPressed == true || keyH.baixoPressed == true ||
				keyH.esqPressed == true || keyH.dirPressed == true) {
			
			if (keyH.cimaPressed == true) {
				direction = "cima";
				ultimoLado=1;
			}
			else if (keyH.baixoPressed == true) {
				direction = "baixo"; 
				ultimoLado=2;
			}
			else if (keyH.esqPressed == true) {
				direction = "esquerda"; 
				ultimoLado=3;
			}
			else if (keyH.dirPressed == true) {
				direction = "direita"; 
				ultimoLado=4;
			}
			
			// Baseado na direção, checa-se a colisão em paredes e tambem em objetos
			colisaoON = false;
			gp.cChecker.checkTile(this);
			int indiceObj = gp.cChecker.checkObject(this, true);
			pegarItem(indiceObj);
			
			
			gp.eHandler.checkEvent();
			
			// Se colisao é falso, então o player se move
			if(colisaoON == false) {
				switch(direction) {
					case "cima": y -= speed; break;
					case "baixo": y += speed; break;
					case "esquerda": x -= speed; break;
					case "direita": x += speed; break;
				}
			}
			
			
			// Para a troca das imagens do player, indicando a movimentação
			spriteCounter++;
			if(spriteCounter > 13) {
				if(spriteNum == 1) {
					spriteNum = 2;
				}
				else if (spriteNum == 2) {
					spriteNum = 1;
				}
				spriteCounter = 0;
			}
		}
	}
	
	public void pegarItem(int indice) {
		if(indice != 999) {
			String objectName = gp.obj[gp.currentMap][indice].name;
			switch(objectName) {
				case "Key":
					key++;
					gp.obj[gp.currentMap][indice] = null;
					System.out.println("Chaves: "+key);
					break;
				
				case "fruta":
					if(vida < vidaMax) {
						vida++;
						gp.obj[gp.currentMap][indice] = null;
						System.out.println("Você recuperou um pouco de vida!!!");
						System.out.println("Vida atual: " + this.vida);
					}else {
						System.out.println("Sua vida esta cheia!!");
					}
					break;
					
				case "Door":
					if(key > 0) {
						gp.obj[gp.currentMap][indice] = null;
						key--;
						System.out.println("Chaves: "+key);
					}else{
						System.out.println("Voce nao tem chaves!!");
					}
					break;
					
				case "doorCastle":
					if(key > 0) {
						gp.obj[gp.currentMap][indice] = null;
						key--;
						System.out.println("Chaves: "+key);
					}else{
						System.out.println("Voce nao tem chaves!!");
					}
					break;
					
				case "Boots":
					speed += 2;
					gp.obj[gp.currentMap][indice] = null;
					break;
					
				case "princesa":
					if(dialogo) {
						System.out.println("**********************************");
						System.out.println("PARABÉNS, VOCÊ TERMINOU O JOGO!!!!");
						System.out.println("**********************************");
						dialogo = false;
					}
					break;
					
				case "monstro":
					if(keyH.allowFight) {
						batalha(indice);
					}
					break;

				case "moedas":
					pegaMoedas(indice);
					break;

				case "escudo":
					possuiEscudo = true;
					System.out.println("Agora você possui um escudo!!!");
					gp.obj[gp.currentMap][indice] = null;
					break;

				case "espada":
					System.out.println("Voce equipou uma espada!!");
					dano += 2;
					gp.obj[gp.currentMap][indice] = null;
					break;
					
				case "NPC":
					if(!dialogo) {
						System.out.println("Voce precisa salvar a princesa!!!");
						System.out.println("Ela esta no castelo, após a floresta!!!");
						dialogo = true;
				
					}
					break;

				default:
					break;
			}
		}
	}


	public void pegaMoedas(int indice) {
		if (indice != 999) {
			if (keyH.ePressed == true) {
				moedas += gp.obj[gp.currentMap][indice].value;
				System.out.println(this.moedas);
				gp.obj[gp.currentMap][indice] = null;
				System.out.println(peso);
			}
		}
		
	}

	public void batalha(int indice) {
		if(indice != 999) {
			if(keyH.pPressed == true) {
				int valorDado = rodaDado();
				System.out.println(valorDado);
				gp.obj[gp.currentMap][indice].vidaMonstro -= dano + valorDado;
				System.out.println("VIDA DO MONSTRO:"+gp.obj[gp.currentMap][indice].vidaMonstro);
				System.out.println("O inimigo irá te atacar!!!");
				keyH.allowFight = false;
				if(possuiEscudo){
					int valorDado2 = rodaDado();
					if (valorDado2 > 4){
						System.out.println("O Escudo BLOQUEOU o dano!!!");
					}else{ this.vida -= gp.obj[gp.currentMap][indice].dano - 1; }

				}else{
					this.vida-= gp.obj[gp.currentMap][indice].dano;
				}
				
				if(vida < 1) {
					gp.currentMap = 0;
					this.x = 100;
					this.y = 100;
					vida = vidaMax;
					System.out.println("Você morreu e voltou para o inicio!!!");
				}

				System.out.println("Sua vida: "+ this.vida);
			}else if(gp.obj[gp.currentMap][indice].vidaMonstro < 1) {
				gp.aSetter.dropaMoeda(gp.obj[gp.currentMap][indice], this);
				gp.obj[gp.currentMap][indice] = null;
				System.out.println("Você matou um inimigo!!!");

			}
		}
	}

	public int rodaDado() {
		int numero = (int) (Math.random() * 5);
		switch (numero) {
			case 0:
				return 1;
			case 1:
				return 2;
			case 2:
				return 3;
			case 3:
				return 4;
			case 4:
				return 5;
			case 5:
				return 6;
			default:
				break;
		}
		return 0;
	}
	
	public void draw(Graphics2D g2) {
		BufferedImage image = null;
		
		switch (direction) {
		case "cima":
			if(spriteNum == 1) {
				image = up1;
			}
			if(spriteNum == 2) {
				image = up2;
			}
			break;
			
		case "baixo":
			if(spriteNum == 1) {
				image = down1;
			}
			if(spriteNum == 2) {
				image = down2;
			}
			break;
			
		case "esquerda":
			if(spriteNum == 1) {
				image = left1;
			}
			if(spriteNum == 2) {
				image = left2;
			}
			break;
			
		case "direita":
			if(spriteNum == 1) {
				image = right1;
			}
			if(spriteNum == 2) {
				image = right2;
			}
			break;
			
		}
		g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
	}
}