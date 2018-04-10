public class Tick extends Game {

    public static final double frameRate = 30.0;
    public static final double frameDur = 1.0 / frameRate;
    private static final double slideSpeed = 1;
    private static final double stepRate = frameRate / slideSpeed;

    public static Game game;
    public static Piece piece = new Piece(5, 10);
    public static double timer = 0;

    // Constructor
    public static void init(Game g) {
        game = g;
    }

    // Move Game forward one Tick
    public static void tick() {
        Utilities.sleepThread(frameDur);

        // gets called ever stepRate = frameRate / 15 = 30 / 15 = 2 per second
        if (timer % stepRate == 0) {

            // MOVEMENT
            piece.step();
        }

        piece.slide((timer % stepRate) / stepRate);


        timer += 1;
        Game.screen.repaint(); // Draw the screen!
    }
}