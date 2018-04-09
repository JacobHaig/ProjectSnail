import java.awt.*;

public class BackGround {

    public static Point grid = new Point(10, 20);
    public static int gridSize = 40;
    public static Point gridOffset = new Point(Game.WIDTH / 2 - (gridSize * grid.x / 2), Game.HEIGHT / 2 - (gridSize * grid.y / 2));

    private static Color GRAY = new Color(66, 66, 66);
    private static Color WHITE = new Color(255, 255, 255);

    public static void render(Graphics g) {

        // Cover the BackGround with a color
        g.setColor(GRAY);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        // Lay out the Grid
        g.setColor(WHITE);
        for (int x = 0; x < grid.x; x++) {
            for (int y = 0; y < grid.y; y++) {
                g.drawRect(gridOffset.x + x * gridSize, gridOffset.y + y * gridSize, gridSize, gridSize);
            }
        }

    }
}
