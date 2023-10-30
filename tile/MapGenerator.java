package tile;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import Main.gamePanel;

import lib.FastNoiseLite;

public class MapGenerator {
    public int[][] mapGrid = new int[50][50];
    Thread mapThread;
    gamePanel jz;

    public MapGenerator(gamePanel jz) {
        this.jz = jz; 
    }

    public void generateMap() {
        FastNoiseLite noise = new FastNoiseLite();
        noise.SetSeed((int) System.currentTimeMillis());
        noise.SetNoiseType(FastNoiseLite.NoiseType.OpenSimplex2S);
        noise.SetFractalOctaves(4); // Set number of octaves to 4
        noise.SetFractalLacunarity((float) 0.85);
        noise.SetFrequency(0.025f);

        Random rand = ThreadLocalRandom.current(); // Use ThreadLocalRandom to avoid synchronization issues

        // Generate tiles using FastNoiseLite 0.01 to 0.1
        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                float noiseValue = (float) noise.GetNoise(i, j);
                if (noiseValue <= 0.06) {
                    mapGrid[i][j] = 0; // water
                } else if (noiseValue >= 0.059) {
                    float randValue = rand.nextFloat();
                    if (randValue < 0.35) {
                        mapGrid[i][j] = 1; // normal sand (35% chance)
                    } else if (randValue < 0.7) {
                        mapGrid[i][j] = 3; // alt sand (35% chance)
                    } else if (randValue < 0.9) {
                        mapGrid[i][j] = 4; // grass with vegetation (20% chance)
                    } else if (randValue < 0.98) {
                        mapGrid[i][j] = 5; // tile 5 (2% chance)
                    } else if (randValue < 0.99) {
                        mapGrid[i][j] = 6; // tile 6 (2% chance)
                    }
                }
                
            }
        }

      /*   for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                
            } 
        } */

        // Saves map to text file
        try {
            PrintWriter writer = new PrintWriter("r/resources/maps/map1.txt", "UTF-8");
            for (int i = 0; i < 50; i++) {
                for (int j = 0; j < 50; j++) {
                    writer.print(mapGrid[i][j] + " ");
                }
                writer.println();
            }
            writer.close();
            System.out.println("Grid saved to map1.txt");
        } catch (IOException e) {
            System.out.println("Error saving grid to map1.txt");
        }
    }

} 



