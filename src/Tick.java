public class Tick extends Game {


    private static final double slideSpeed = 2;
    public static final double frameRate = 30.0;
    public static final double frameDur = 1.0 / frameRate;
    private static final double stepRate = frameRate / slideSpeed;

    public static Game game;
    public static Piece piece = new Piece(5, 10);
    public static double timer = 0;

    // Constructor
    public static void init(Game g) {
        game = g;
    }

    // Play game like normal
    public static void tick() {
        Utilities.sleepThread(frameDur);


        // gets called ever stepRate = frameRate / 15 = 30 / 15 = 2 per second
        if (timer % stepRate == 0) {

            // MOVEMENT
            piece.step();
        }

        timer += 1;

        Game.screen.repaint(); // Draw the screen!
    }
}