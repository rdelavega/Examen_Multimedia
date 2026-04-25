package ExamUnitTwo;

import java.awt.Color;
import java.util.Random;

public class                  Ball {

    int x;
    int y;
    int size;

    int xSpeed;
    int ySpeed;

    Color color;

    Random random = new Random();

    public Ball(int x, int y) {

        this.x = x;
        this.y = y;

        size = 120;

        xSpeed = 6;
        ySpeed = 6;

        color = randomColor();
    }

    public void move() {
        x += xSpeed;
        y += ySpeed;
    }

    public void bounceX() {
        xSpeed *= -1;
    }

    public void bounceY() {
        ySpeed *= -1;
    }

    public void increaseSpeed() {

        if(xSpeed > 0)
            xSpeed++;
        else
            xSpeed--;

        if(ySpeed > 0)
            ySpeed++;
        else
            ySpeed--;
    }

    public void randomPosition(int panelWidth, int panelHeight){
        x = random.nextInt(panelWidth - size);
        y = random.nextInt(panelHeight - size);
    }

    public void randomizeColor(){
        color = randomColor();
    }

    private Color randomColor(){
        return new Color(
                random.nextInt(256),
                random.nextInt(256),
                random.nextInt(256)
        );
    }

    public void resetSpeed() {
        xSpeed = 4;
        ySpeed = 4;
    }

    public boolean containsPoint(int mx, int my){

    	int margin = 5;

    	return mx >= x - margin &&
    	       mx <= x + size + margin &&
    	       my >= y - margin &&
    	       my <= y + size + margin;
    }
}