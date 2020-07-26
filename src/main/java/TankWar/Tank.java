package TankWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;

public class Tank {
    private int x, y;
    private Direction direction;

    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    void move() {
        switch (direction) {
            case UP: //上
                y -= 5;
                break;
            case DOWN: //下
                y += 5;
                break;
            case LEFT: //左
                x -= 5;
                break;
            case RIGHT: //右
                x += 5;
                break;
            case UPLEFT: //上左
                x-=5;
                y-=5;
                break;
            case UPRIGHT://上右
                x+=5;
                y-=5;
                break;
            case DOWNLEFT://下左
                x-=5;
                y+=5;
                break;
            case DOWNRIGHT://下右
                x+=5;
                y+=5;
                break;
        }
    }

 public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    Image getImage() {
        switch (direction) {
            case UP: //上
                return new ImageIcon("J:\\tankwar\\assets\\images\\tankU.gif").getImage();
            case DOWN: //下
                return new ImageIcon("J:\\tankwar\\assets\\images\\tankD.gif").getImage();
            case LEFT: //左
                return new ImageIcon("J:\\tankwar\\assets\\images\\tankL.gif").getImage();
            case RIGHT: //右
                return new ImageIcon("J:\\tankwar\\assets\\images\\tankR.gif").getImage();
            case UPLEFT: //上左
                return new ImageIcon("J:\\tankwar\\assets\\images\\tankLU.gif").getImage();
            case UPRIGHT: //上右
                return new ImageIcon("J:\\tankwar\\assets\\images\\tankRU.gif").getImage();
            case DOWNLEFT: //下左
                return new ImageIcon("J:\\tankwar\\assets\\images\\tankLD.gif").getImage();
            case DOWNRIGHT: //下右
                return new ImageIcon("J:\\tankwar\\assets\\images\\tankRD.gif").getImage();
        }
        return null;
    }

    void draw(Graphics g) {
        this.determineDirection();
        this.move();
        g.drawImage(this.getImage(), this.x, this.y, null);
    }

    private boolean up, down, left, right;

    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = true;
                break;
            case KeyEvent.VK_DOWN:
                down = true;
                break;
            case KeyEvent.VK_LEFT:
                left = true;
                break;
            case KeyEvent.VK_RIGHT:
                right = true;
                break;
        }
    }

    private void determineDirection() {
        if (up && left && !down && !right) { // 上左
            this.direction = Direction.UPLEFT;
        } else if (up && !left && !down && right) { // 上右
            this.direction = Direction.UPRIGHT;
        } else if (up && !left && !down && !right) { // 上
            this.direction = Direction.UP;
        } else if (!up && !left && down && !right) {//下
            this.direction = Direction.DOWN;
        } else if (!up && left && down && !right) {//下左
            this.direction = Direction.DOWNLEFT;
        } else if (!up && !left && down && right) {//下右
            this.direction = Direction.DOWNRIGHT;
        } else if (!up && left && !down && !right) { //左
            this.direction = Direction.LEFT;
        } else if (!up && !left && !down && right) {//右
            this.direction = Direction.RIGHT;
        }

    }

    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP:
                up = false;
                break;
            case KeyEvent.VK_DOWN:
                down = false;
                break;
            case KeyEvent.VK_LEFT:
                left = false;
                break;
            case KeyEvent.VK_RIGHT:
                right = false;
                break;
        }
    }
}
