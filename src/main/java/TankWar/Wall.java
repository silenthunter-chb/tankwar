package TankWar;

import java.awt.*;

public class Wall {
      private int x, y;
      private boolean horizontal;
      private int bricks;
      private final Image brickImage;

      public Wall(int x, int y, boolean horizontal, int bricks) {
            this.x = x;
            this.y = y;
            this.horizontal = horizontal;
            this.bricks = bricks;
            this.brickImage = Tools.getImage("brick.png");
      }

      public Rectangle getRectangle() {
            if (horizontal) {
                  return new Rectangle(x, y, bricks * brickImage.getWidth(null), brickImage.getHeight(null));
            } else {
                  return new Rectangle(x, y, brickImage.getWidth(null), brickImage.getHeight(null) * bricks);
            }
      }

      public void draw(Graphics g) {
            if (horizontal) {
                  for (int i = 0; i < bricks; i++) {
                        g.drawImage(brickImage, x + i * brickImage.getWidth(null), y, null);
                  }
            } else {
                  for (int i = 0; i < bricks; i++) {
                        g.drawImage(brickImage, x, y + i * brickImage.getHeight(null), null);
                  }
            }

      }
}
