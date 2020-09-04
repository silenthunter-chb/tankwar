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

      private Image getImage() {
            return direction.getImage("missile");
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
                  case LEFT_UP: //上左
                        x -= SPEED;
                        y -= SPEED;
                        break;
                  case RIGHT_UP://上右
                        x += SPEED;
                        y -= SPEED;
                        break;
                  case LEFT_DOWN://下左
                        x -= SPEED;
                        y += SPEED;
                        break;
                  case RIGHT_DOWN://下右
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
