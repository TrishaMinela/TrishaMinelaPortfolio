import java.awt.Graphics;
import java.util.ArrayList;

public class Garden {

    private ArrayList<Plant> plants;
    int x,y;
    public static final int CONTINUE = 0;
    public static final int FLOWER = 1;
    public static final int WEED = 2;

    public Garden() {
        //initial values of x and y
        x = 0;
        y = 370;
        //setting the flowers and weed to their positions
        plants = new ArrayList<>();
    }

    public void draw(Graphics g) {
        for (var p : plants) {
            p.draw(g);
        }
    }

    public void clear() {
        plants.clear();
        x = 0;
        y = 370;
    }

    public boolean isFull() {
        return plants.size() >= 16;
    }

    public void newFlower() {
        var f = new Flower(x, y);
        plants.add(f);
        x += 40;
        if (y == 370) {
            y = 340;
        } else {
            y = 370;
        }
    }

    public void newWeed(){
        var w = new Weed(x, y);
        plants.add(w);
        x += 40;
        if (y == 370) {
            y = 340;
        } else {
            y = 370;
        }
    }
}
