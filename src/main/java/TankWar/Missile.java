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
            x+=direction.xFactor * SPEED;
            y+=direction.yFactor * SPEED;
      }

      public void draw(Graphics g) {
            this.move();
            if (x < 0 || x > 800 || y < 0 || y > 600) {
                  return;
            }
            g.drawImage(this.getImage(), x, y, null);
      }
}
