import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class MathProblem {
    private int num1, num2, answer;
    private String ops;
    private String userInput = "";

    public MathProblem() {

        int operator = (int) (Math.random() * 4);
        if (operator == 0) {
            ops = "+";
            num1 = (int) (13 * Math.random());
            num2 = (int) (13 * Math.random());
            answer = num1 + num2;
        } else if (operator == 1) {
            ops = "-";
            num1 = (int) (13 * Math.random());
            num2 = (int) (13 * Math.random());
            int sum = num1 + num2;
            num1 = sum;
            answer = num1 - num2;
        } else if (operator == 2) {
            ops = "\u00D7";
            num1 = (int) (13 * Math.random());
            num2 = (int) (13 * Math.random());
            answer = num1 * num2;
        } else if (operator == 3) {
            ops = "\u00F7";
            num1 = (int) (13 * Math.random());
            num2 = (int) (13 * Math.random());
            int product = num1 * num2;
            num1 = product;
            if (num2 == 0) {
                num2 = 2;
            }
            answer = num1 / num2;
        }
        System.out.println(num1 + " " + ops + " " + num2 + " = " + answer);

    }

    public void draw(Graphics g) {
        g.setColor(Color.DARK_GRAY);
        g.setFont((new Font("Dialog", Font.PLAIN, 40)));
        g.drawString(num1 + " " + ops + " " + num2 + " = " + userInput, 300, 300);
    }

    public int receiveUserInput(KeyEvent c) {
        char ui = c.getKeyChar();
        if (ui >= '0' && ui <= '9') {
            userInput += ui;
        } else if (c.getKeyCode() == KeyEvent.VK_DELETE || c.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            if (userInput.length() > 0) {
                userInput = userInput.substring(0, userInput.length() - 1);
            }
        }
        if (c.getKeyCode() == KeyEvent.VK_ENTER) {
            if (Integer.parseInt(userInput) == answer) {
                userInput = "";
                return Garden.FLOWER;
            } else {
                userInput = "";
                return Garden.WEED;
            }
        }
        return Garden.CONTINUE;
    }
}