package main;


public class EventHandler {
	GamePanel gp;
	//Rectangle eventRect;
	//int eventRectDefaultX, eventRectDefaultY;
	EventRect eventRect[][][];
	
	public EventHandler(GamePanel gp) {
		this.gp = gp;
		eventRect = new EventRect[gp.maxMap][gp.maxColunas][gp.maxLinhas];
		int coluna = 0;
		int linha = 0;
		int map = 0;
		
		while(map < gp.maxMap && coluna < gp.maxColunas && linha < gp.maxLinhas) {
			
			eventRect[map][coluna][linha] = new EventRect();
			eventRect[map][coluna][linha].x = 23;
			eventRect[map][coluna][linha].y = 23;
			eventRect[map][coluna][linha].width = 2;
			eventRect[map][coluna][linha].height = 2;
			eventRect[map][coluna][linha].eventRectDefaultX = eventRect[map][coluna][linha].x;
			eventRect[map][coluna][linha].eventRectDefaultY = eventRect[map][coluna][linha].y;
			coluna++;
			if(coluna == gp.maxColunas) {
				coluna = 0;
				linha++;
				
				if(linha == gp.maxLinhas) {
					linha = 0;
					map++;
				}
			}
		}
	}
	
	public void checkEvent() {
		//teleport map 0 to map1 event
		if(hit(0,7,0,"any") == true ) {
			gp.currentMap = 1;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 10;
		}
		//teleport map 1 to map 0 event
		if(hit(1,7,11,"any") == true) {
			gp.currentMap = 0;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 1;
		}
		//teleport map 1 to map 2 event
		if(hit(1,15,5,"any") == true) {
			gp.currentMap = 2;
			gp.player.x = gp.tileSize * 1;
			gp.player.y = gp.tileSize * 5;
		}
		//teleport map 1 to map 5 event
		if(hit(1,7,0,"any") == true) {
			gp.currentMap = 5;
			gp.player.x = gp.tileSize * 6;
			gp.player.y = gp.tileSize * 10;
		}
		//teleport map 2 to map 1 event
		if(hit(2,0,5,"any") == true) {
			gp.currentMap = 1;
			gp.player.x = gp.tileSize * 14;
			gp.player.y = gp.tileSize * 5;
		}
		//teleport map 2 to map 3 event
		if(hit(2,15,10,"any") == true) {
			gp.currentMap = 3;
			gp.player.x = gp.tileSize * 1;
			gp.player.y = gp.tileSize * 5;
		}
		//teleport map 2 to map 4 event
		if(hit(2,7,0,"any") == true) {
			gp.currentMap = 4;
			gp.player.x = gp.tileSize * 8;
			gp.player.y = gp.tileSize * 10;
		}
		//teleport map 3 to map 2 event
		if(hit(3,0,5,"any") == true) {
			gp.currentMap = 2;
			gp.player.x = gp.tileSize * 14;
			gp.player.y = gp.tileSize * 10;
		}
		//teleport map 4 to map 2 event
		if(hit(4,8,11,"any") == true) {
			gp.currentMap = 2;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 1;
		}
		//teleport map 4 to map 5 event
		if(hit(4,0,5,"any") == true) {
			gp.currentMap = 5;
			gp.player.x = gp.tileSize * 14;
			gp.player.y = gp.tileSize * 6;
		}
		//teleport map 5 to map 1
		if(hit(5,6,11,"any") == true) {
			gp.currentMap = 1;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 1;
		}
		//teleport map 5 to map 4
		if(hit(5,15,6,"any") == true) {
			gp.currentMap = 4;
			gp.player.x = gp.tileSize * 1;
			gp.player.y = gp.tileSize * 5;
		}
		//teleport map 5 to map 6
		if(hit(5,3,0,"any") == true) {
			gp.currentMap = 6;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 10;
		}
		//teleport map 6 to map 5
		if(hit(6,7,11,"any") == true) {
			gp.currentMap = 5;
			gp.player.x = gp.tileSize * 3;
			gp.player.y = gp.tileSize * 1;
		}
		//teleport map 6 to map 7
		if(hit(6,7,2,"any") == true) {
			gp.currentMap = 7;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 10;
		}
		//teleport map 7 to map 6
		if(hit(7,7,11,"any") == true) {
			gp.currentMap = 6;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 3;
		}
		//teleport map 7 to map 8
		if(hit(7,7,0,"any") == true) {
			gp.currentMap = 8;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 10;
		}
		//teleport map 8 to map 7
		if(hit(8,7,11,"any") == true) {
			gp.currentMap = 7;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 1;
		}
		//teleport map 8 to map 9
		if(hit(8,7,0,"any") == true) {
			gp.currentMap = 9;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 10;
		}
		//teleport map 9 to map 8
		if(hit(9,7,11,"any") == true) {
			gp.currentMap = 8;
			gp.player.x = gp.tileSize * 7;
			gp.player.y = gp.tileSize * 1;
		}
		//teleport map 9 to map 10
		if(hit(9,15,6,"any") == true) {
			gp.currentMap = 10;
			gp.player.x = gp.tileSize * 1;
			gp.player.y = gp.tileSize * 6;
		}
		//teleport map 10 to map 9
		if(hit(10,0,6,"any") == true) {
			gp.currentMap = 9;
			gp.player.x = gp.tileSize * 14;
			gp.player.y = gp.tileSize * 6;
		}
		
	}
	
	public boolean hit(int map, int coluna, int linha, String reqDirection) {
		boolean hit =  false;
		if(map == gp.currentMap) {
			gp.player.areaSolida.x = gp.player.x + gp.player.areaSolida.x;
			gp.player.areaSolida.y = gp.player.y + gp.player.areaSolida.y;
			eventRect[map][coluna][linha].x = coluna*gp.tileSize + eventRect[map][coluna][linha].x;
			eventRect[map][coluna][linha].y = linha*gp.tileSize + eventRect[map][coluna][linha].y;
			
			if(gp.player.areaSolida.intersects(eventRect[map][coluna][linha])) {
				if(gp.player.direction.contentEquals(reqDirection) || reqDirection.contentEquals("any")) {
					hit = true;
				}
			}
			gp.player.areaSolida.x = gp.player.areaSolidaPadraoX;
			gp.player.areaSolida.y = gp.player.areaSolidaPadraoY;
			eventRect[map][coluna][linha].x = eventRect[map][coluna][linha].eventRectDefaultX;
			eventRect[map][coluna][linha].y = eventRect[map][coluna][linha].eventRectDefaultY;
		}
		return hit;
	}
}














