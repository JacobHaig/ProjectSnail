import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

    // Global Key pressed
    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Arrow Keys && WASD
        if (key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D)
            Tick.piece.pos.x += 1;
        else if (key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A)
            Tick.piece.pos.x -= 1;
        else if (key == KeyEvent.VK_UP || key == KeyEvent.VK_W)
            Orientation.rotationRight();
        else if (key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) {
        }

        // When Key press also change Visual Pos
        Tick.piece.posVisual.x = Tick.piece.pos.x;

        Grid.checkBounds(Tick.piece.matrix.getMatrix(), Tick.piece.pos);

        Game.screen.repaint(); // Draw the screen!
    }

    // Global Key released
    @Override
    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();
/*
		// Arrow Keys
		if (key == KeyEvent.VK_RIGHT)
			Tick.piece.setMovingRight(false);
		else if (key == KeyEvent.VK_LEFT)
			Tick.piece.setMovingLeft(false);
		else if (key == KeyEvent.VK_UP)
			Tick.piece.setMovingUp(false);
		else if (key == KeyEvent.VK_DOWN)
			Tick.piece.setMovingDown(false);*/

    }
}
