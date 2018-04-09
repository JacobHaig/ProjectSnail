import java.awt.*;
import java.awt.image.BufferedImage;

public class Piece {

    private static boolean movingRight = false;
    private static boolean movingLeft = false;
    private static boolean movingUp = false;
    private static boolean movingDown = false;


    private static int pieceSize = BackGround.gridSize;
    private static Point PieceOffset = BackGround.gridOffset;

    private static BufferedImage grayScale = Images.getImage("piece.png");

    private Point pos;
    private Arrangements order = new Arrangements();


    Piece(int x, int y) {
        pos = new Point(x, y);
        order.T();
    }

    // Move the player and set angle
    public void step() {

    }

    public void render(Graphics g) {

        //System.out.println(order.getString()[0].length() + " " + order.getString().length);

        for (int x = -1; x < order.getData()[0].length - 1; x++)
            for (int y = -1; y < order.getData().length - 1; y++)
                if (order.getData()[x + 1][y + 1] == 1)
                    g.drawImage(grayScale, PieceOffset.x + (pos.x + x) * pieceSize, PieceOffset.y + (pos.y + y) * pieceSize, pieceSize, pieceSize, null);

        //g.drawImage(grayScale, 100, 100, pieceSize, pieceSize, null);

        //g.drawImage(grayScale, PieceOffset.x + (pos.x) * pieceSize, PieceOffset.y + (pos.y) * pieceSize, pieceSize, pieceSize, null);
    }


    public void setMovingRight(boolean movingRight) {
        Piece.movingRight = movingRight;
    }

    public void setMovingLeft(boolean movingLeft) {
        Piece.movingLeft = movingLeft;
    }

    public void setMovingUp(boolean movingUp) {
        Piece.movingUp = movingUp;
    }

    public void setMovingDown(boolean movingDown) {
        Piece.movingDown = movingDown;
    }
}
