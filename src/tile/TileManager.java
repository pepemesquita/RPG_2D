package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.GamePanel;

public class TileManager {
	
	GamePanel gp;
	public Tile[] tile;
	public int mapTileNum[][][];
	
	public TileManager (GamePanel gp) {
		this.gp = gp;
		tile = new Tile[30];
		mapTileNum = new int[gp.maxMap][gp.maxColunas][gp.maxLinhas];
		getTileImage();
		loadMap("/maps/map00.txt", 0);
		loadMap("/maps/map01.txt", 1);
		loadMap("/maps/map02.txt", 2);
		loadMap("/maps/map03.txt", 3);
		loadMap("/maps/map04.txt", 4);
		loadMap("/maps/map05.txt", 5);
		loadMap("/maps/map06.txt", 6);
		loadMap("/maps/map07.txt", 7);
		loadMap("/maps/map08.txt", 8);
		loadMap("/maps/map09.txt", 9);
		loadMap("/maps/map10.txt", 10);
	}
	
	public void getTileImage() {
		
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/tiles/earth.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/tiles/sand.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/tiles/escadaEsq.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/tiles/escadaDir.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall.png"));
			tile[5].colisao = true;
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/tiles/tree.png"));
			tile[6].colisao = true;
			
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water00.png"));
			tile[7].colisao = true;
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/tiles/water01.png"));
			tile[8].colisao = true;
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/tiles/grass_old.png"));
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floor.png"));
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/tiles/table.png"));
			tile[11].colisao = true;
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/tiles/black.png"));
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wallCastle.png"));
			tile[13].colisao = true;
			
			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/tiles/flagRed.png"));
			tile[14].colisao = true;
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wallBrick.png"));
			tile[15].colisao = true;
			
			tile[16] = new Tile();
			tile[16].image = ImageIO.read(getClass().getResourceAsStream("/tiles/floorCastle.png"));
			
			tile[17] = new Tile();
			tile[17].image = ImageIO.read(getClass().getResourceAsStream("/tiles/stairs_mid.png"));
			
			tile[18] = new Tile();
			tile[18].image = ImageIO.read(getClass().getResourceAsStream("/tiles/stairs_bottom.png"));
			
			tile[19] = new Tile();
			tile[19].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wall_gratings.png"));
			tile[19].colisao = true;
			
			tile[20] = new Tile();
			tile[20].image = ImageIO.read(getClass().getResourceAsStream("/tiles/wallgargula.png"));
			tile[20].colisao = true;
			
			tile[21] = new Tile();
			tile[21].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lava1.png"));
			tile[21].colisao = true;
			
			tile[22] = new Tile();
			tile[22].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lava2.png"));
			tile[22].colisao = true;
			
			tile[23] = new Tile();
			tile[23].image = ImageIO.read(getClass().getResourceAsStream("/tiles/lava3.png"));
			tile[23].colisao = true;
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public void loadMap(String filePath, int map) {
		try {
			InputStream is = getClass().getResourceAsStream(filePath);
			BufferedReader br = new BufferedReader(new InputStreamReader(is)); //formato para ler o txt
			int coluna = 0;
			int linha = 0;
			
			while(coluna < gp.maxColunas && linha < gp.maxLinhas) {
				String line = br.readLine();
				
				while(coluna < gp.maxColunas) {
					String numbers[] = line.split(" ");
					int num = Integer.parseInt(numbers[coluna]);
					mapTileNum[map][coluna][linha] = num;
					coluna++;
				}
				if(coluna == gp.maxColunas) {
					coluna = 0;
					linha++;
				}
			}
			br.close();
		}
		catch(Exception e) {
			
		}
	}
	
	public void draw(Graphics2D g2) {
		int coluna = 0;
		int linha = 0;
		int x = 0;
		int y = 0;
		
		while(coluna < gp.maxColunas && linha < gp.maxLinhas) {
			int tileNum = mapTileNum[gp.currentMap][coluna][linha];
			g2.drawImage(tile[tileNum].image, x, y, gp.tileSize, gp.tileSize, null);
			coluna++;
			x += gp.tileSize;
			
			if(coluna == gp.maxColunas) {
				coluna = 0;
				x = 0;
				linha++;
				y += gp.tileSize;
			}
		}
	}
}



