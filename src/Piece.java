import java.awt.*;
import java.awt.image.BufferedImage;

public class Piece {
    public static BufferedImage grayScale = Images.getImage("piece.png");
    public static BufferedImage redScale = Images.getImage("pieceRed.png");
    private static int gridWidth = Grid.gridWidth;
    private static Point PieceOffset = Grid.gridOffset;

    public Point pos;
    public Point.Double posVisual;
    public Orientation matrix = new Orientation();

    public Color c;

    Piece(int x, int y) {
        pos = new Point(x, y);
        posVisual = new Point.Double(x, y);

        c = new Color(0, 255, 180);

        matrix.randomMatrix(); // New Piece!
    }

    // Move the player and set angle
    public void step() {

        Grid.checkBounds(matrix.getMatrix(), pos);

        // If Piece hits the bottom/ another piece
        if (Grid.checkCollision(matrix.getMatrix(), pos)) {
            Grid.addGrid(matrix.getMatrix(), pos);

            // NEW PIECE
            Tick.piece = new Piece(5, 3);
        } else {
            posVisual.setLocation(pos);
            pos.y += 1;
        }
    }

    // Pieces slide!
    public void slide(double t) {
        posVisual.y = (-0.5 * (Math.cos(Math.PI * t) - 1) + pos.y - 1);
        posVisual.x = pos.x;
    }

    // Render the matrix
    public void render(Graphics g) {
        boolean testing = false;

        for (int x = -1; x < matrix.getData()[0].length - 1; x++)
            for (int y = -1; y < matrix.getData().length - 1; y++)
                if (matrix.getData()[y + 1][x + 1] == 1) {

                    int xx, yy;
                    // (posVisual.x + x) == is the matrix offset
                    if (!testing) {
                        xx = (int) (PieceOffset.x + (posVisual.x + x) * gridWidth); //Default
                        yy = (int) (PieceOffset.y + (posVisual.y + y) * gridWidth);
                    } else {
                        xx = PieceOffset.x + (pos.x + x) * gridWidth; // Testing
                        yy = PieceOffset.y + (pos.y + y) * gridWidth;
                    }
                    g.drawImage(grayScale, xx, yy, gridWidth, gridWidth, null);

                }
        g.drawImage(redScale, (int) (PieceOffset.x + posVisual.x * gridWidth), (int) (PieceOffset.y + posVisual.y * gridWidth), gridWidth, gridWidth, null);
    }

}
