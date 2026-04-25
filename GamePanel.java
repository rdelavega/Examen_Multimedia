package ExamUnitTwo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GamePanel extends JPanel implements MouseListener {

    Ball ball = new Ball(100, 100);

    int score = 0;
    int hitCount = 0;
    boolean gameWon = false;

    static final int WIN_SCORE = 10;

    Timer timer;

    JButton restartButton;

    Image swatterImage;
    Image flyImage;
    Image backgroundImage;

    int mouseX = 0;
    int mouseY = 0;

    public GamePanel() {

        setLayout(null);
        addMouseListener(this);

        flyImage        = new ImageIcon("mosca.png").getImage();
        swatterImage    = new ImageIcon("matamoscas.png").getImage();
        backgroundImage = new ImageIcon("cocina.jpg.jpeg").getImage();

        addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouseX = e.getX();
                mouseY = e.getY();
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                mouseMoved(e);
            }
        });

        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
            new java.awt.image.BufferedImage(1, 1, java.awt.image.BufferedImage.TYPE_INT_ARGB),
            new Point(),
            "blank"
        ));

        restartButton = new JButton("Restart");
        restartButton.setBounds(650, 20, 100, 30);
        restartButton.addActionListener(e -> restartGame());
        add(restartButton);

        timer = new Timer(50, e -> updateGame());
        timer.start();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);

        Graphics2D g2 = (Graphics2D) g.create();

        double angle = Math.atan2(ball.ySpeed, ball.xSpeed) + Math.PI / 2;

        g2.translate(ball.x + ball.size / 2, ball.y + ball.size / 2);
        g2.rotate(angle);
        g2.drawImage(flyImage, -ball.size / 2, -ball.size / 2, ball.size, ball.size, this);
        g2.dispose();

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 20));
        g.drawString("Score: " + score, 20, 30);

        if (gameWon) {
            g.setColor(new Color(247, 255, 0, 255));
            g.setFont(new Font("Arial", Font.BOLD, 70));
            FontMetrics fm = g.getFontMetrics();
            String msg = "You Win!";
            int msgX = (getWidth() - fm.stringWidth(msg)) / 2;
            int msgY = getHeight() / 2;
            g.drawString(msg, msgX, msgY);
        }

        g.drawImage(swatterImage, mouseX - 45, mouseY - 45, 80, 80, this);
    }

    public void updateGame() {

        ball.move();

        if (ball.x <= 0 || ball.x + ball.size >= getWidth()) {
            ball.bounceX();
        }

        if (ball.y <= 0 || ball.y + ball.size >= getHeight()) {
            ball.bounceY();
        }

        repaint();
    }

    public void restartGame() {
        score    = 0;
        hitCount = 0;
        gameWon  = false;
        ball.resetSpeed();
        ball.randomPosition(getWidth(), getHeight());
        timer.start();
        repaint();
    }

    public void mousePressed(MouseEvent e) {

        if (gameWon) return;

        int mx = e.getX();
        int my = e.getY();

        if (ball.containsPoint(mx, my)) {

            score++;
            hitCount++;

            Toolkit.getDefaultToolkit().beep();

            if (hitCount % 3 == 0) {
                ball.increaseSpeed();
            }

            ball.randomPosition(getWidth(), getHeight());

            if (score >= WIN_SCORE) {
                gameWon = true;
                timer.stop();
            }
        }

        repaint();
    }

    public void mouseClicked(MouseEvent e)  {}
    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e)  {}
    public void mouseExited(MouseEvent e)   {}
}
