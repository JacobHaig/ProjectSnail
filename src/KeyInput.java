import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter {

	// Global Key pressed
	@Override
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		//if (key == KeyEvent.VK_Y)
		//Game.gameStart = false;

		// Arrow Keys
		if (key == KeyEvent.VK_RIGHT)
			Tick.piece.setMovingRight(true);
		else if (key == KeyEvent.VK_LEFT)
			Tick.piece.setMovingLeft(true);
		else if (key == KeyEvent.VK_UP)
			Tick.piece.setMovingUp(true);
		else if (key == KeyEvent.VK_DOWN)
			Tick.piece.setMovingDown(true);

		// WASD Keys
		if (key == KeyEvent.VK_D)
			Tick.piece.setMovingRight(true);
		else if (key == KeyEvent.VK_A)
			Tick.piece.setMovingLeft(true);
		else if (key == KeyEvent.VK_W)
			Tick.piece.setMovingUp(true);
		else if (key == KeyEvent.VK_S)
			Tick.piece.setMovingDown(true);

		//if (key == KeyEvent.VK_ESCAPE)
		//Game.gamePaused = !Game.gamePaused;
	}

	// Global Key released
	@Override
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		// Arrow Keys
		if (key == KeyEvent.VK_RIGHT)
			Tick.piece.setMovingRight(false);
		else if (key == KeyEvent.VK_LEFT)
			Tick.piece.setMovingLeft(false);
		else if (key == KeyEvent.VK_UP)
			Tick.piece.setMovingUp(false);
		else if (key == KeyEvent.VK_DOWN)
			Tick.piece.setMovingDown(false);

		// WASD Keys
		if (key == KeyEvent.VK_D)
			Tick.piece.setMovingRight(false);
		else if (key == KeyEvent.VK_A)
			Tick.piece.setMovingLeft(false);
		else if (key == KeyEvent.VK_W)
			Tick.piece.setMovingUp(false);
		else if (key == KeyEvent.VK_S)
			Tick.piece.setMovingDown(false);
	}
}
