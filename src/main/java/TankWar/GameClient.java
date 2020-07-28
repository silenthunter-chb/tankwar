package TankWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

public class GameClient extends JComponent {

      private Tank playerTank;
      private ArrayList<Tank> enermyTanks;
      private ArrayList<Wall> walls;

      public GameClient() {
            this.setPreferredSize(new Dimension(800, 600));
            playerTank = new Tank(400, 100, Direction.DOWN);
            enermyTanks = new ArrayList<>(12);
            for (int i = 0; i < 3; i++) {
                  for (int x = 0; x < 4; x++) {
                        enermyTanks.add(new Tank(250 + x * 100, 400 + i * 40, true, Direction.UP));
                  }
            }
      }

      @Override
      protected void paintComponent(Graphics g) {
            playerTank.draw(g);
            for (int i = 0; i < enermyTanks.size(); i++) {
                  enermyTanks.get(i).draw(g);
            }
      }

      public static void main(String[] args) {
            JFrame frame = new JFrame();
            frame.setTitle("Udemy的坦克大战");
            frame.setIconImage(new ImageIcon("assets/images/icon.png").getImage());
            frame.setLocation(300, 40);
            final GameClient client = new GameClient();
            frame.add(client);
            frame.pack();
            frame.setDefaultCloseOperation(3);
            frame.setVisible(true);
            //在窗口增加键盘监听，用KeyAdapter匿名内部类
            frame.addKeyListener(new KeyAdapter() {
                  @Override
                  public void keyPressed(KeyEvent e) {
                        client.playerTank.keyPressed(e); //调用坦克类的keyPressed方法
                  }

                  @Override
                  public void keyReleased(KeyEvent e) {
                        client.playerTank.keyReleased(e); //调用坦克类的keyreleased方法
                  }
            });

            while (true) {
                  client.repaint(); //重画paintComponent方法
                  try {
                        Thread.sleep(50); //间隔50毫秒重画一次
                  } catch (InterruptedException e) {
                        e.printStackTrace();
                  }
            }

      }

}
