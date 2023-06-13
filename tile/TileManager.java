package tile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import java.awt.Polygon; 
import java.awt.AlphaComposite; 

import javax.imageio.ImageIO;

import Main.UtilityTool;
import Main.gamePanel;
// import Main.UtilityTool; 
import java.awt.Graphics2D; 

public class TileManager {
    gamePanel jz; 
    public Tile[] tile; 
    public int mapTileNum[] []; 

    public TileManager(gamePanel jz) {
        this.jz = jz; 
        tile = new Tile[10]; 
        mapTileNum = new int[jz.maxWorldCol] [jz.maxWorldCol];

        getTileImage(); 
        loadMap("/r/resources/maps/map1.txt"); 
    }

    public void getTileImage() {
    System.out.println("Image loading started");

    String[] filePaths = {
        "/r/resources/tiles/waterTile.png", // 0
        "/r/resources/tiles/sandTile.png", // 1
        "/r/resources/tiles/wallTile.png", // 2
        "/r/resources/tiles/sandTile2.png", // 3
        "/r/resources/tiles/sandTile3.png", // 4
        "/r/resources/tiles/sandTile4.png", // 5
        "/r/resources/tiles/sandTile5.png" //
    };

    for (int i = 0; i < filePaths.length; i++) {
        setup(i, filePaths[i]);
    }

    System.out.println("Image loading finished");
}

    public void setup(int index, String filePath) {
        UtilityTool uTool = new UtilityTool(); 

        try {
            tile[index] = new Tile(); 
            tile[index].image = ImageIO.read(getClass().getResourceAsStream(filePath)); 
            tile[index].image = uTool.scaleImage(tile[index].image, jz.tileSize, jz.tileSize); 
        } catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    public void loadMap(String filePath) {
         try {
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
    
            ArrayList<ArrayList<Integer>> mapTileNums = new ArrayList<>(); // Use ArrayList instead of fixed size array
    
            while (true) { // Loop until end of file is reached
                String line = br.readLine(); 
    
                if (line == null) {
                    break;
                }
    
                String[] numbers = line.split(" ");
                ArrayList<Integer> rowTileNums = new ArrayList<>(); // Create a new row of tile numbers
    
                for (int i = 0; i < numbers.length; i++) {
                    int num = Integer.parseInt(numbers[i]);
                    rowTileNums.add(num); // Add tile number to current row
                }
    
                mapTileNums.add(rowTileNums); // Add current row to map
            }
            
            br.close();
    
            // Convert ArrayList of ArrayLists to 2D array
            int[][] mapTiles = new int[mapTileNums.size()][];
            for (int i = 0; i < mapTileNums.size(); i++) {
                ArrayList<Integer> rowTileNums = mapTileNums.get(i);
                int[] rowTiles = new int[rowTileNums.size()];
                for (int j = 0; j < rowTileNums.size(); j++) {
                    rowTiles[j] = rowTileNums.get(j);
                }
                mapTiles[i] = rowTiles;
            }
    
            // Use mapTiles to generate map
            generateMap(mapTiles);
        }
        catch(Exception e){
            System.err.println(e); 
        } 
    }
    
   public void generateMap(int[][] mapTiles) {
        // Set the dimensions of the map
        int numCols = jz.maxWorldCol;
        int numRows = jz.maxWorldRow;
    
        // Allocate memory for the map data
        mapTileNum = new int[numCols][numRows];
    
        // Load the map data from the file
        for (int i = 0; i < numCols; i++) {
            for (int j = 0; j < numRows; j++) {
                mapTileNum[i][j] = mapTiles[j][i];
            }
        }
    } 

    public void draw(Graphics2D g2) {
        int playerWorldX = jz.player.worldX;
        int playerWorldY = jz.player.worldY;
        int playerScreenX = jz.player.screenX;
        int playerScreenY = jz.player.screenY;
        int tileSize = jz.tileSize;
        int radius = jz.player.radius;
    
        int playerTileX = playerWorldX / tileSize;
        int playerTileY = playerWorldY / tileSize;
    
        int tileSizeDiv8 = tileSize / 8;
    
        for (int dx = -radius; dx <= radius; dx++) {
            for (int dy = -radius; dy <= radius; dy++) {
                int worldX = playerTileX + dx;
                int worldY = playerTileY + dy;
    
                if (worldX >= 0 && worldX < jz.maxWorldCol && worldY >= 0 && worldY < jz.maxWorldRow) {
                    int tileNum = mapTileNum[worldX][worldY];
                    int worldXOffset = worldX * tileSize;
                    int worldYOffset = worldY * tileSize;
                    int screenX = worldXOffset - playerWorldX + playerScreenX - tileSize;
                    int screenY = worldYOffset - playerWorldY + playerScreenY - tileSize;
                    screenX -= tileSizeDiv8 * worldX;
    
                    if (isInsideCircle(screenX + tileSize / 2, screenY + tileSize / 2, radius * tileSize)) {
                        int[] xPoints;
                        int[] yPoints;
                        Polygon trapezoid;
    
                        if ((worldY + worldX) % 2 == 0) {
                            // Bottom-first trapezoid
                            xPoints = new int[]{screenX, screenX + tileSize, screenX + (tileSize * 7 / 8), screenX + tileSize / 8};
                            yPoints = new int[]{screenY + tileSize, screenY + tileSize, screenY, screenY};
                            trapezoid = new Polygon(xPoints, yPoints, 4);
                        } else {
                            // Top-first trapezoid
                            xPoints = new int[]{screenX + tileSize / 8, screenX + (tileSize * 7 / 8), screenX + tileSize, screenX};
                            yPoints = new int[]{screenY + tileSize, screenY + tileSize, screenY, screenY};
                            trapezoid = new Polygon(xPoints, yPoints, 4);
                        }
    
                        g2.clip(trapezoid);
                        g2.drawImage(tile[tileNum].image, screenX, screenY, null);
                        g2.setClip(null);
                    }
                }
            }
        }
    } 
    
    
    private boolean isInsideCircle(int x, int y, int radius) {
        int centerX = jz.screenWidth / 2;
        int centerY = jz.screenHeight / 2;
    
        int dx = x - centerX;
        int dy = y - centerY;
    
        return dx * dx + dy * dy <= radius * radius;
    }
    
    
    
private boolean isTileInView(int x, int y, int screenWidth, int screenHeight) {
    int tileSize = jz.tileSize;
    return x + tileSize >= 0 && x <= screenWidth && y + tileSize >= 0 && y <= screenHeight;
}
}