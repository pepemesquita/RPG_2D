package main;

import entidade.Entidade;

public class CollisionChecker {
	GamePanel gp;
	
	public CollisionChecker(GamePanel gp) {
		this.gp = gp;
	}
	
	public void checkTile(Entidade entidade) {
		
		int leftX = entidade.x + entidade.areaSolida.x;
		int rightX = entidade.x + entidade.areaSolida.x + entidade.areaSolida.width;
		int topY = entidade.y + entidade.areaSolida.y;
		int bottomY = entidade.y + entidade.areaSolida.y + entidade.areaSolida.height;
		
		int colunaEsquerda = leftX/gp.tileSize;
		int colunaDireita = rightX/gp.tileSize;
		int linhaTop = topY/gp.tileSize;
		int linhaBottom = bottomY/gp.tileSize;
		
		int tileNum1, tileNum2;
		
		switch(entidade.direction) {
			case "cima":
				linhaTop = (topY - entidade.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[gp.currentMap][colunaEsquerda][linhaTop];
				tileNum2 = gp.tileM.mapTileNum[gp.currentMap][colunaDireita][linhaTop];
				if(gp.tileM.tile[tileNum1].colisao == true || gp.tileM.tile[tileNum2].colisao == true) {
					entidade.colisaoON = true;
				}
				break;
				
			case "baixo":
				linhaBottom = (bottomY + entidade.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[gp.currentMap][colunaEsquerda][linhaBottom];
				tileNum2 = gp.tileM.mapTileNum[gp.currentMap][colunaDireita][linhaBottom];
				if(gp.tileM.tile[tileNum1].colisao == true || gp.tileM.tile[tileNum2].colisao == true) {
					entidade.colisaoON = true;
				}
				break;
				
			case "esquerda":
				colunaEsquerda = (leftX - entidade.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[gp.currentMap][colunaEsquerda][linhaTop];
				tileNum2 = gp.tileM.mapTileNum[gp.currentMap][colunaEsquerda][linhaBottom];
				if(gp.tileM.tile[tileNum1].colisao == true || gp.tileM.tile[tileNum2].colisao == true) {
					entidade.colisaoON = true;
				}
				break;
				
			case "direita":
				colunaDireita = (rightX + entidade.speed)/gp.tileSize;
				tileNum1 = gp.tileM.mapTileNum[gp.currentMap][colunaDireita][linhaTop];
				tileNum2 = gp.tileM.mapTileNum[gp.currentMap][colunaDireita][linhaBottom];
				if(gp.tileM.tile[tileNum1].colisao == true || gp.tileM.tile[tileNum2].colisao == true) {
					entidade.colisaoON = true;
				}
				break;
		}
	}
	
	public int checkObject(Entidade entidade, boolean player) {
		int indice = 999;
		
		for(int i = 0; i < gp.obj.length; i++) {
			if(gp.obj[gp.currentMap][i] != null) {
				entidade.areaSolida.x = entidade.x + entidade.areaSolida.x;
				entidade.areaSolida.y = entidade.y + entidade.areaSolida.y;
				
				gp.obj[gp.currentMap][i].areaSolida.x = gp.obj[gp.currentMap][i].x + gp.obj[gp.currentMap][i].areaSolida.x;
				gp.obj[gp.currentMap][i].areaSolida.y = gp.obj[gp.currentMap][i].y + gp.obj[gp.currentMap][i].areaSolida.y;
				
				switch(entidade.direction) {
					case "cima":
						entidade.areaSolida.y -= entidade.speed;
						if(entidade.areaSolida.intersects(gp.obj[gp.currentMap][i].areaSolida)) {
							if(gp.obj[gp.currentMap][i].colisao == true) {
								entidade.colisaoON = true;
							}
							if(player == true) {
								indice = i;
							}
						}
						break;
					case "baixo":
						entidade.areaSolida.y += entidade.speed;
						if(entidade.areaSolida.intersects(gp.obj[gp.currentMap][i].areaSolida)) {
							if(gp.obj[gp.currentMap][i].colisao == true) {
								entidade.colisaoON = true;
							}
							if(player == true) {
								indice = i;
							}
						}
						break;
					case "esquerda":
						entidade.areaSolida.x -= entidade.speed;
						if(entidade.areaSolida.intersects(gp.obj[gp.currentMap][i].areaSolida)) {
							if(gp.obj[gp.currentMap][i].colisao == true) {
								entidade.colisaoON = true;
							}
							if(player == true) {
								indice = i;
							}
						}
						break;
					case "direita":
						entidade.areaSolida.x += entidade.speed;
						if(entidade.areaSolida.intersects(gp.obj[gp.currentMap][i].areaSolida)) {
							if(gp.obj[gp.currentMap][i].colisao == true) {
								entidade.colisaoON = true;
							}
							if(player == true) {
								indice = i;
							}
						}
						break;
				}
				entidade.areaSolida.x = entidade.areaSolidaPadraoX;
				entidade.areaSolida.y = entidade.areaSolidaPadraoY;
				gp.obj[gp.currentMap][i].areaSolida.x = gp.obj[gp.currentMap][i].areaSolidaPadraoX;
				gp.obj[gp.currentMap][i].areaSolida.y = gp.obj[gp.currentMap][i].areaSolidaPadraoY;
			}
		}
		return indice;
	}
}