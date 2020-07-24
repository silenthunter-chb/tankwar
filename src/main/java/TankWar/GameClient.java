package TankWar;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameClient extends JComponent {

    public GameClient(){
        this.setPreferredSize(new Dimension(800, 600));
    }

    @Override
    protected void paintComponent(Graphics g) {
//        g.drawImage(new ImageIcon("assets/images/tankD.gif").getImage(), 400, 100, null);
        try {
            g.drawImage(ImageIO.read(new File("assets/images/tankD.gif")), 400, 100, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Udemy的坦克大战");
        frame.setIconImage(new ImageIcon("assets/images/icon.png").getImage());
        frame.setLocation(300, 40);
        frame.add(new GameClient());
        frame.pack();
        frame.setDefaultCloseOperation(3);
        frame.setVisible(true);
    }

}
