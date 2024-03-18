import javax.swing.ImageIcon;
import java.awt.Point;
import java.awt.Graphics;

public abstract class Plant {
    protected ImageIcon image;
    private Point pos;

    public Plant(int x, int y) {
        //Position
        pos = new Point(x, y);
    }

    public void draw(Graphics g) {
        //Draws whatever flower or weed
        if (image != null) {
            image.paintIcon(null, g, pos.x, pos.y);
        } else {
            g.drawString("Flower", pos.x, pos.y);
        }
    }
}










