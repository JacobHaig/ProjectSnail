import java.awt.*;
import java.util.ArrayList;

class Tile {
    public int x;
    public int y;

    public Color c;

    Tile(int x, int y, Color c) {
        this.x = x;
        this.y = y;
        this.c = c;
    }

}

public class Grid {
    public static int gridWidth = 40;
    public static Point gridSize = new Point(10, 20);
    public static Point gridOffset = new Point(Game.WIDTH / 2 - (gridWidth * gridSize.x / 2), Game.HEIGHT / 2 - (gridWidth * gridSize.y / 2));


    public static ArrayList<Tile> tiles = new ArrayList<Tile>();
    public static int[][] grid = new int[gridSize.y][gridSize.x]; // y and x


    // NOT TESTED
    // Add piece to grid
    public static void addGrid(Matrix m, Point pos) {
        for (int yy = -1; yy < m.getData().length - 1; yy++)
            for (int xx = -1; xx < m.getData()[0].length - 1; xx++)
                if (m.getData()[yy + 1][xx + 1] == 1) {
                    grid[pos.y + yy][pos.x + xx] = 1;
                    tiles.add(new Tile(pos.x + xx, pos.y + yy, Tick.piece.c));
                }
    }


    // Check/ Fix pos if it goes Out Of Bounds
    public static void checkBounds(Matrix m, Point pos) {
        // Loop through the matrix
        for (int yy = -1; yy < m.getData().length - 1; yy++)
            for (int xx = -1; xx < m.getData()[0].length - 1; xx++) {

                // Only the tiles
                if (m.getData()[yy + 1][xx + 1] == 1) {

                    // Left
                    if ((pos.x + xx) <= -1)
                        pos.x += 1;

                    // Right
                    if ((pos.x + xx) >= grid[0].length)
                        pos.x -= 1;

                    // Below the Ground
                    if ((pos.y + yy) >= grid.length) {
                        Tick.piece.pos.y -= 1;
                        checkBounds(m, pos);
                    }
                }
            }
    }


    // Checks if the piece collides with the bottom or other piece
    public static boolean checkCollision(Matrix m, Point pos) {
        // Loop through the matrix
        for (int yy = -1; yy < m.getData().length - 1; yy++)
            for (int xx = -1; xx < m.getData()[0].length - 1; xx++) {

                // If a matrix has a tile at location
                if (m.getData()[yy + 1][xx + 1] == 1) {

                    // if intersects with another peice
                    if (grid[pos.y + yy][pos.x + xx] == 1)
                        pos.x += ((pos.x + xx) < pos.x) ? 1 : -1;

                    // If matrix is right above the bottom of the grid
                    if (pos.y + yy + 1 >= gridSize.y)
                        return true;
                    // If matrix is right above another peice
                    if (grid[pos.y + yy + 1][pos.x + xx] == 1)
                        return true;
                }
            }
        return false;
    }


    // Render any grid tiles
    public static void render(Graphics g) {
        // Loop through the matrix
        for (Tile tile : tiles) {

            g.drawImage(Piece.redScale, (gridOffset.x + tile.x * gridWidth), (gridOffset.y + tile.y * gridWidth), gridWidth, gridWidth, null);
        }

        /*for (int x = 0; x < Grid.gridSize.x; x++)
            for (int y = 0; y < Grid.gridSize.y; y++)
                // If grid tile is there display it
                if (grid[y][x] == 1)
                    g.drawImage(Piece.redScale, (gridOffset.x + x * gridWidth), (gridOffset.y + y * gridWidth), gridWidth, gridWidth, null);
           */
    }
}