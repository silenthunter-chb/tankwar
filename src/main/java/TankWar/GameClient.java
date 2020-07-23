package TankWar;

import javax.swing.*;
import java.awt.*;

public class GameClient extends JComponent {

    public GameClient(){
        this.setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(new ImageIcon("assets/images/tankD.gif").getImage(), 400, 100, null);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Udemy的坦克大战");
        frame.add(new GameClient());
        frame.pack();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

}
