import java.awt.*;

public class Grid {
    public static int gridWidth = 40;
    public static Point gridSize = new Point(10, 20);
    public static Point gridOffset = new Point(Game.WIDTH / 2 - (gridWidth * gridSize.x / 2), Game.HEIGHT / 2 - (gridWidth * gridSize.y / 2));

    public static int[][] grid = new int[gridSize.y][gridSize.x]; // y and x


    // NOT TESTED
    // Add piece to grid
    public static void addGrid(Matrix m, Point pos) {
        for (int yy = -1; yy < m.getData().length - 1; yy++)
            for (int xx = -1; xx < m.getData()[0].length - 1; xx++)
                if (m.getData()[yy + 1][xx + 1] == 1)
                    grid[pos.y + yy][pos.x + xx] = 1;
    }

    // SLIGHTLY TESTED
    // Checks if the piece collides with the bottom or other piece
    public static boolean checkCollision(Matrix m, Point pos) {
        // grid[15][4] = 1; // Remove. For testing only

        // Loop through the matrix
        for (int yy = -1; yy < m.getData().length - 1; yy++)
            for (int xx = -1; xx < m.getData()[0].length - 1; xx++)
                // If a tile of matrix is there
                if (m.getData()[yy + 1][xx + 1] == 1)
                    // If center + offset is above the bottom of the grid or piece
                    if (pos.y + yy + 1 >= gridSize.y || grid[pos.y + yy + 1][pos.x + xx] == 1)
                        return true;
        return false;
    }


    // Render any grid tiles
    public static void render(Graphics g) {
        // Loop through the matrix
        for (int x = 0; x < Grid.gridSize.x; x++)
            for (int y = 0; y < Grid.gridSize.y; y++)
                // If grid tile is there display it
                if (grid[y][x] == 1)
                    g.drawImage(Piece.redScale, (gridOffset.x + x * gridWidth), (gridOffset.y + y * gridWidth), gridWidth, gridWidth, null);

    }
}