package TankWar;

import javax.swing.*;
import java.awt.*;

public final class Tools {

      public static Image getImage(String filename) {
            return new ImageIcon("assets/images/" + filename).getImage();
      }

}
