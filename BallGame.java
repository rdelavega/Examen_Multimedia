package ExamUnitTwo;

import javax.swing.*;

public class BallGame extends JFrame {

    public BallGame() {

        setTitle("Fly Swatter Game");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(new GamePanel());

        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new BallGame();
    }
}