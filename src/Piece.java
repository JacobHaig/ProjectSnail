import java.awt.*;
import java.awt.image.BufferedImage;

public class Piece {
    public static BufferedImage grayScale = Images.getImage("piece.png");
    public static BufferedImage redScale = Images.getImage("pieceRed.png");
    public static BufferedImage greenScale = Images.getImage("pieceGreen.png");
    public static BufferedImage orangeScale = Images.getImage("pieceOrange.png");
    public static BufferedImage blueScale = Images.getImage("pieceBlue.png");


    private static int gridWidth = Grid.gridWidth;
    private static Point PieceOffset = Grid.gridOffset;

    public Point pos;
    public Point.Double posVisual;
    public Orientation matrix = new Orientation();

    public BufferedImage curImage;

    Piece(int x, int y) {
        pos = new Point(x, y);
        posVisual = new Point.Double(x, y);

        switch (Utilities.random(4)) {
            case 1:
                curImage = redScale;
                break;
            case 2:
                curImage = greenScale;
                break;
            case 3:
                curImage = orangeScale;
                break;
            case 4:
                curImage = blueScale;
                break;
            default:
                curImage = redScale;
        }
        matrix.randomMatrix(); // New Piece!
    }

    // Move the player and set angle
    public void step() {

        Grid.checkBounds(matrix.getMatrix(), pos);


        // If Piece hits the bottom/ another piece
        if (Grid.checkCollision(matrix.getMatrix(), pos)) {
            Grid.addGrid(matrix.getMatrix(), pos);
            Grid.checkRows();

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
                    // posVisual.x + x   is the matrix offset
                    if (!testing) {
                        xx = (int) (PieceOffset.x + (posVisual.x + x) * gridWidth); //Default
                        yy = (int) (PieceOffset.y + (posVisual.y + y) * gridWidth);
                    } else {
                        xx = PieceOffset.x + (pos.x + x) * gridWidth; // Testing
                        yy = PieceOffset.y + (pos.y + y) * gridWidth;
                    }
                    g.drawImage(curImage, xx, yy, gridWidth, gridWidth, null);

                }
        // DRAW CENTER POINT
        //g.drawImage(curImage, (int) (PieceOffset.x + posVisual.x * gridWidth), (int) (PieceOffset.y + posVisual.y * gridWidth), gridWidth, gridWidth, null);
    }

}
