import javax.swing.*;
import java.awt.*;

public class Game extends JFrame {
    public static final int WIDTH = 800;
    public static final int HEIGHT = 1000;

    public static Game game;
    public static Screen screen;


    public Game() {
        // Setting up the window
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setResizable(false);
        this.setTitle("Tetris!");
        this.setLocationRelativeTo(null);
        this.setLayout(new GridLayout(1, 1, 0, 0));

        // Mouse and Key Listeners
        addKeyListener(new KeyInput());

        // Create the Screen!
        screen = new Screen();
        this.add(screen);
        this.setVisible(true);

    }

    // Main
    public static void main(String[] args) {
        // Start the Game!
        game = new Game();
        Tick.init(game);

        //new Music();

        while(true){
            Tick.tick();
        }
    }
}