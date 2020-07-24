package TankWar;

import javax.swing.*;
import java.awt.*;

public class Tank {
    private int x, y;
    private Direction direction;

    public Tank(int x, int y, Direction direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    Image getImage(){
        switch (direction){
            case UP: return new ImageIcon("J:\\tankwar\\assets\\images\\tankU.gif" ).getImage();
            case DOWN: return new ImageIcon("J:\\tankwar\\assets\\images\\tankD.gif" ).getImage();
            case LEFT: return new ImageIcon("J:\\tankwar\\assets\\images\\tankL.gif" ).getImage();
            case RIGHT: return new ImageIcon("J:\\tankwar\\assets\\images\\tankR.gif" ).getImage();
        }
        return null;
    }

}
