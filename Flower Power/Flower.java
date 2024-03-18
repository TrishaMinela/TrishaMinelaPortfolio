import javax.swing.ImageIcon;

public class Flower extends Plant{

    public Flower(int x, int y) {
        //Random Flowers
        super(x,y);
        int rand = (int) (Math.random() * 4);
        String fileName = "src/flower" + rand + ".png";
        image = new ImageIcon(fileName);
    }


}
