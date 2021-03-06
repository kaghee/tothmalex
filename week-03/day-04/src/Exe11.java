import javax.swing.*;
import java.awt.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Exe11 {

    public static void mainDraw(Graphics graphics) {


        graphics.setColor(Color.YELLOW);
        graphics.fillRect(0, 0, WIDTH, HEIGHT);
        graphics.drawRect(0, 0, WIDTH, HEIGHT);

        drawSquare(graphics, 0, 0, HEIGHT, 5);
    }

    static int drawSquare(Graphics g, int x, int y, int size, int n) {

        g.setColor(Color.BLACK);

        g.drawRect(x + size / 3, y, size / 3, size / 3);
        g.drawRect(x + size / 3 * 2, y + size / 3, size / 3, size / 3);
        g.drawRect(x + size / 3, y + size / 3 * 2, size / 3, size / 3);
        g.drawRect(x, y + size / 3, size / 3, size / 3);

        if (n == 0) {
            return 0;
        } else {
            drawSquare(g, x + size / 3, y, size / 3, n - 1);
            drawSquare(g, x + size / 3 * 2, y + size / 3, size / 3, n - 1);
            drawSquare(g, x + size / 3, y + size / 3 * 2, size / 3, n - 1);
            drawSquare(g, x, y + size / 3, size / 3, n - 1);
        } return 0;
    }

    //    Don't touch the code below
    static int WIDTH = 660;
    static int HEIGHT = 660;

    public static void main(String[] args) {
        JFrame jFrame = new JFrame("Drawing");
        jFrame.setSize(new Dimension(WIDTH, HEIGHT));
        jFrame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        jFrame.add(new ImagePanel());
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
    static class ImagePanel extends JPanel{
        @Override
        protected void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);
            mainDraw(graphics);

        }
    }

}

