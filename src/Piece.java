import java.awt.*;
import java.awt.image.BufferedImage;

public class Piece {

    private static int gridSize = BackGround.gridSize;
    private static Point PieceOffset = BackGround.gridOffset;

    private static BufferedImage grayScale = Images.getImage("piece.png");

    public Point pos;
    public Point.Double posVisual;

    private Arrangements matrix = new Arrangements();


    Piece(int x, int y) {
        pos = new Point(x, y);
        posVisual = new Point.Double(x, y);

        matrix.T();
    }

    // Move the player and set angle
    public void step() {

        pos.y += 1;

        posVisual.y = pos.y;

        // slide();
    }

    private void slide(double t) {
        posVisual.y += (-0.5 * (Math.cos(Math.PI * t) - 1));
    }


    public void render(Graphics g) {

        for (int x = -1; x < matrix.getData()[0].length - 1; x++)
            for (int y = -1; y < matrix.getData().length - 1; y++)
                if (matrix.getData()[y + 1][x + 1] == 1) {

                    // (posVisual.x + x) == is the matrix offset
                    int xx = (int) (PieceOffset.x + (posVisual.x + x) * gridSize);
                    int yy = (int) (PieceOffset.y + (posVisual.y + y) * gridSize);

                    g.drawImage(grayScale, xx, yy, gridSize, gridSize, null);
                }
    }

}
