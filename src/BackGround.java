import java.awt.*;

public class BackGround {

    private static Color GRAY = new Color(66, 66, 66);
    private static Color WHITE = new Color(255, 255, 255);

    public static void render(Graphics g) {

        // Cover the BackGround with a color
        g.setColor(GRAY);
        g.fillRect(0, 0, Game.WIDTH, Game.HEIGHT);

        // Lay out the Grid
        g.setColor(WHITE);
        for (int x = 0; x < Grid.gridSize.x; x++)
            for (int y = 0; y < Grid.gridSize.y; y++)
                g.drawRect(Grid.gridOffset.x + x * Grid.gridWidth, Grid.gridOffset.y + y * Grid.gridWidth, Grid.gridWidth, Grid.gridWidth);


    }
}
