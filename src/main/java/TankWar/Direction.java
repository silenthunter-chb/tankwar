package TankWar;

import java.awt.*;

public enum Direction {
      UP("U", 0, -1), //上
      DOWN("D", 0, 1), //下
      LEFT("L", -1, 0), //左
      RIGHT("R", 1, 0), //右
      LEFT_UP("LU", -1, -1), //上左
      RIGHT_UP("RU", 1, -1), //上右
      LEFT_DOWN("LD", -1, 1), //下左
      RIGHT_DOWN("RD", 1, 1); //下右

      private final String abbrev;
      final int xFactor, yFactor;

      Direction(String abbrev, int xFactor, int yFactor) {
            this.abbrev = abbrev;
            this.xFactor = xFactor;
            this.yFactor = yFactor;
      }

      Image getImage(String prefix){
            return Tools.getImage(prefix + abbrev + ".gif");
      }
}
