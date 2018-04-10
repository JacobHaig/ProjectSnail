import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

//Import the Image from the res Folder
public class Images {
    private static Images image;

    public static BufferedImage getImage(String arg) {
        image = new Images();
        return image.createImage(arg);
    }

    private BufferedImage createImage(String str) {

        try {
            return ImageIO.read(this.getClass().getResourceAsStream("/" + str));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
