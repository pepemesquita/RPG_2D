package main;

import entidade.Player;
import object.*;

public class AssetSetter {
	GamePanel gp;
	
	public AssetSetter(GamePanel gp) {
		this.gp = gp;
	}

	public void setObject() {
		int mapNum = 0;
		
		mapNum = 0;
		gp.obj[mapNum][0] = new NPC();
		gp.obj[mapNum][0].x = 9 * gp.tileSize;
		gp.obj[mapNum][0].y = 4 * gp.tileSize;
		
		mapNum = 1;
		gp.obj[mapNum][0] = new OBJ_Key();
		gp.obj[mapNum][0].x = 1 * gp.tileSize;
		gp.obj[mapNum][0].y = 2 * gp.tileSize;
		
		gp.obj[mapNum][1] = new OBJ_Door();
		gp.obj[mapNum][1].x = 15 * gp.tileSize;
		gp.obj[mapNum][1].y = 5 * gp.tileSize;
		
		gp.obj[mapNum][2] = new MonstroComum();
		gp.obj[mapNum][2].map = mapNum;
		gp.obj[mapNum][2].x = 9 * gp.tileSize;
		gp.obj[mapNum][2].y = 2 * gp.tileSize;
		
		gp.obj[mapNum][3] = new MonstroComum();
		gp.obj[mapNum][3].map = mapNum;
		gp.obj[mapNum][3].x = 3 * gp.tileSize;
		gp.obj[mapNum][3].y = 7 * gp.tileSize;
		
		gp.obj[mapNum][4] = new OBJ_Espada();
		gp.obj[mapNum][4].x = 1 * gp.tileSize;
		gp.obj[mapNum][4].y = 10 * gp.tileSize;
		
		mapNum = 2;
		gp.obj[mapNum][0] = new OBJ_Boots();
		gp.obj[mapNum][0].x = 11 * gp.tileSize;
		gp.obj[mapNum][0].y = 5 * gp.tileSize;
		
		mapNum = 3;
		gp.obj[mapNum][0] = new OBJ_Escudo();
		gp.obj[mapNum][0].x = 6 * gp.tileSize;
		gp.obj[mapNum][0].y = 5 * gp.tileSize;
		
		mapNum = 4;
		gp.obj[mapNum][0] = new OBJ_Fruta();
		gp.obj[mapNum][0].x = 9 * gp.tileSize;
		gp.obj[mapNum][0].y = 4 * gp.tileSize;
		
		mapNum = 6;
		gp.obj[mapNum][0] = new OBJ_DoorCastle();
		gp.obj[mapNum][0].x = 7 * gp.tileSize;
		gp.obj[mapNum][0].y = 2 * gp.tileSize;
		
		gp.obj[mapNum][1] = new MonstroComum();
		gp.obj[mapNum][1].map = mapNum;
		gp.obj[mapNum][1].x = 7 * gp.tileSize;
		gp.obj[mapNum][1].y = 3 * gp.tileSize;
		
		gp.obj[mapNum][2] = new MonstroComum();
		gp.obj[mapNum][2].map = mapNum;
		gp.obj[mapNum][2].x = 2 * gp.tileSize;
		gp.obj[mapNum][2].y = 3 * gp.tileSize;
		
		gp.obj[mapNum][3] = new OBJ_Key();
		gp.obj[mapNum][3].map = mapNum;
		gp.obj[mapNum][3].x = 1 * gp.tileSize;
		gp.obj[mapNum][3].y = 1 * gp.tileSize;
		
		mapNum = 7;
		gp.obj[mapNum][0] = new OBJ_Fruta();
		gp.obj[mapNum][0].x = 5 * gp.tileSize;
		gp.obj[mapNum][0].y = 5 * gp.tileSize;
		
		mapNum = 8;
		gp.obj[mapNum][2] = new MonstroComum();
		gp.obj[mapNum][2].map = mapNum;
		gp.obj[mapNum][2].x = 7 * gp.tileSize;
		gp.obj[mapNum][2].y = 5 * gp.tileSize;
		
		mapNum = 9;
		gp.obj[mapNum][2] = new MonstroChefe();
		gp.obj[mapNum][2].x = 7 * gp.tileSize;
		gp.obj[mapNum][2].y = 3 * gp.tileSize;
		
		mapNum = 10;
		gp.obj[mapNum][2] = new Princesa();
		gp.obj[mapNum][2].x = 6 * gp.tileSize;
		gp.obj[mapNum][2].y = 6 * gp.tileSize;
				
	}
	public void dropaMoeda(SuperObject so, Player p){
		int mapNum = so.getMap();
		gp.obj[mapNum][5] = new OBJ_Moedas();
		gp.obj[mapNum][5].x = p.getX();
		gp.obj[mapNum][5].y = p.getY();
		System.out.println("Dropou moeda!!!");
	}

}