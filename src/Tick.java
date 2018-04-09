public class Tick extends Game {
    public static Game game;
    public static Piece piece = new Piece(5, 0);
    private static double frameRate = 1000 / 1;


    // Constructor
    public static void init(Game g) {
        game = g;
    }

    // Play game like normal
    public static void step() {
        Utilities.sleepThread(frameRate);

        // MOVEMENT
        piece.step();

        Game.screen.repaint(); // Draw the screen!
    }
}