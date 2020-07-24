package TankWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class GameClient extends JComponent {

    private Tank playerTank;

    public GameClient() {
        this.setPreferredSize(new Dimension(800, 600));
        playerTank = new Tank(400, 100, Direction.DOWN);
    }

    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(playerTank.getImage(), playerTank.getX(), playerTank.getY(), null);
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
        frame.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                    case KeyEvent.VK_UP:
                    case KeyEvent.VK_DOWN:
                    case KeyEvent.VK_LEFT:
                    case KeyEvent.VK_RIGHT:
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
            }
        });
    }

}
