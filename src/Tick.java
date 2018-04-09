import java.util.ArrayList;
import java.util.List;

public class Tick extends Game {
    public static Game game;
    public static Player player;
    private static double frameRate = 1000 / 60;

    private static List<FallingItem> fallingObjects = new ArrayList<>();

    // Constructor
    public static void init(Game g) {
        game = g;
        player = new Player(100, 650);
    }

    public static List<FallingItem> getFallingObjects() {
        return fallingObjects;
    }



    // Play game like normal
    public static void step() {
        Utilities.sleepThread(frameRate);

        // If mouse is in the window
        /*if (MouseInput.isMouseInputEnabled())
            MouseInput.updateMousePos();*/

        // MOVEMENT
        player.step();


        Game.screen.repaint(); // Draw the screen!
    }
}