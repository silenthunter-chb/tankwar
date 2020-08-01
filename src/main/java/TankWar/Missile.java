package TankWar;

import javax.swing.*;
import java.awt.*;

class Missile {
      public static final int SPEED = 10;
      private int x, y;
      private final boolean enermy;
      private final Direction direction;

      public Missile(int x, int y, boolean enermy, Direction direction) {
            this.x = x;
            this.y = y;
            this.enermy = enermy;
            this.direction = direction;
      }

      Image getImage() {
            switch (direction) {
                  case UP: //上
                        return new ImageIcon("J:\\tankwar\\assets\\images\\missileU.gif").getImage();
                  case DOWN: //下
                        return new ImageIcon("J:\\tankwar\\assets\\images\\missileD.gif").getImage();
                  case LEFT: //左
                        return new ImageIcon("J:\\tankwar\\assets\\images\\missileL.gif").getImage();
                  case RIGHT: //右
                        return new ImageIcon("J:\\tankwar\\assets\\images\\missileR.gif").getImage();
                  case UPLEFT: //上左
                        return new ImageIcon("J:\\tankwar\\assets\\images\\missileLU.gif").getImage();
                  case UPRIGHT: //上右
                        return new ImageIcon("J:\\tankwar\\assets\\images\\missileRU.gif").getImage();
                  case DOWNLEFT: //下左
                        return new ImageIcon("J:\\tankwar\\assets\\images\\missileLD.gif").getImage();
                  case DOWNRIGHT: //下右
                        return new ImageIcon("J:\\tankwar\\assets\\images\\missileRD.gif").getImage();
            }
            return null;
      }

      void move() {
            switch (direction) {
                  case UP: //上
                        y -= SPEED;
                        break;
                  case DOWN: //下
                        y += SPEED;
                        break;
                  case LEFT: //左
                        x -= SPEED;
                        break;
                  case RIGHT: //右
                        x += SPEED;
                        break;
                  case UPLEFT: //上左
                        x -= SPEED;
                        y -= SPEED;
                        break;
                  case UPRIGHT://上右
                        x += SPEED;
                        y -= SPEED;
                        break;
                  case DOWNLEFT://下左
                        x -= SPEED;
                        y += SPEED;
                        break;
                  case DOWNRIGHT://下右
                        x += SPEED;
                        y += SPEED;
                        break;
            }
      }

      public void draw(Graphics g) {
            this.move();
            if (x < 0 || x > 800 || y < 0 || y > 600) {
                  return;
            }
            g.drawImage(this.getImage(), x, y, null);
      }
}
