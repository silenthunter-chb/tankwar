package TankWar;

import java.awt.*;

public enum Direction {
      UP("U"), //上
      DOWN("D"), //下
      LEFT("L"), //左
      RIGHT("R"), //右
      LEFT_UP("LU"), //上左
      RIGHT_UP("RU"), //上右
      LEFT_DOWN("LD"), //下左
      RIGHT_DOWN("RD"); //下右

      private final String abbrev;

      Direction(String abbrev) {
            this.abbrev = abbrev;
      }

      Image getImage(String prefix){
            return Tools.getImage(prefix + abbrev + ".gif");
      }
}
