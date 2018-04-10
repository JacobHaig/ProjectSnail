import javax.swing.*;
import java.awt.*;

public class Screen extends JPanel {
    //private static BufferedImage backgroundImage = Images.getImage("Game-Background.png");

    Screen() { // Calling repaint() calls everything need to paint() aswell as paint() itself
        repaint();
    }

    @Override
    public void paint(Graphics g) {

        BackGround.render(g);

        Tick.piece.render(g);

    }
}
