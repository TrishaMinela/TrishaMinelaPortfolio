import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JOptionPane;

public class FlowerPower extends JPanel implements KeyListener {

    private Garden garden;
    private MathProblem problem;
    private int state;
    private static final int MAIN_LOOP = 3;
    private static final int ENDGAME = 4;
    private int score;
    private String player;
    private int attempts;

    public FlowerPower() {
        garden = new Garden();
        problem = new MathProblem();
        state = MAIN_LOOP;
        score = 0;
        player = JOptionPane.showInputDialog("Enter your name:");
        addKeyListener(this);
        attempts = 0;
    }

    @Override
    public void paintComponent(Graphics g) {
        requestFocusInWindow();
        super.paintComponent(g);
        // Drawing the sky
        g.setColor(new Color(135, 206, 250));
        g.fillRect(0, 0, 800, 400);

        // Drawing the grass
        g.setColor(new Color(50, 205, 50));
        g.fillRect(0, 400, 800, 200);

        // Drawing the sun
        g.setColor(Color.YELLOW);
        g.fillOval(getWidth() - 170, 70, 120, 120);

        // Drawing the garden if the user is playing then gameover if not
        garden.draw(g);
        if (state == MAIN_LOOP){
            problem.draw(g);
            //player name and score
            g.setFont(new Font("Dialog", Font.BOLD, 20));
            g.setColor(Color.BLACK);
            g.drawString("Player: " + player, 600, 50);
            g.drawString("Score: " + score, 50, 50);
            if ((attempts == 1) || (attempts == 2)) {
                g.setColor(Color.RED);
                g.setFont(new Font("Dialog", Font.BOLD, 30));
                g.drawString("Try Again", 300, 200);
            }
        } else if (state == ENDGAME) {
            g.setColor(Color.BLACK);
            g.setFont((new Font("Dialog", Font.PLAIN, 20)));
            g.drawString("Game Over. Do you want to play again? (y/n)", 200, 300);
        }

    }

    public void keyPressed(KeyEvent e) {
        if (state == MAIN_LOOP) {
            int result = problem.receiveUserInput(e);
            if (result == 1) {
                garden.newFlower();
                score += 10;
                if (garden.isFull()) {
                    state = ENDGAME;
                } else {
                    problem = new MathProblem();
                    attempts = 0;
                }
            } else if (result == 2) {
                if (attempts < 2) {
                    attempts++;
                } else {
                    garden.newWeed();
                    score -= 5;
                    if (garden.isFull()) {
                        state = ENDGAME;
                    } else {
                        problem = new MathProblem();
                    }
                    attempts = 0;
                }
            }
        } else if (state == ENDGAME) {
            char input = e.getKeyChar();
            if (input == 'y') {
                garden.clear();
                state = MAIN_LOOP;
                problem = new MathProblem();
            } else if (input == 'n') {
                System.exit(0);
            }
        }

        repaint();
    }


    public void keyReleased(KeyEvent e){

    }

    public void keyTyped(KeyEvent e){


    }



    public static void main(String[] args) {
        var window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setSize(800,600);
        window.setContentPane(new FlowerPower());
        window.setVisible(true);
    }
}
