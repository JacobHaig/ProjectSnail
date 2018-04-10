public class Render extends Thread {
    private static Game game;

    Render(Game g) {
        game = g;
    }

    public void run() {
        while (true) {
            Utilities.sleepThread(Tick.frameDur);

            Game.screen.repaint(); // Draw the screen!
        }
    }
}
