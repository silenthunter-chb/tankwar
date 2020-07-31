package TankWar;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

public class GameClient extends JComponent {

      private static final GameClient INSTANCE = new GameClient();
      public static GameClient getInstance(){
            return INSTANCE;
      }
      private Tank playerTank;
      private ArrayList<Tank> enermyTanks;
      private List<Wall> walls;

      public List<Wall> getWalls() {
            return walls;
      }

      private GameClient() {
            setPreferredSize(new Dimension(800, 600));
            playerTank = new Tank(400, 100, Direction.DOWN);
            enermyTanks = new ArrayList<>(12);
            for (int i = 0; i < 3; i++) {//加入电脑敌人坦克，3行4列
                  for (int x = 0; x < 4; x++) {
                        enermyTanks.add(new Tank(250 + x * 100, 400 + i * 40, true, Direction.UP));
                  }
            }
            walls = Arrays.asList(
                    new Wall(200, 140, true, 15),
                    new Wall(200, 540, true, 15),
                    new Wall(100, 80, false, 15),
                    new Wall(700, 80, false, 15)
            );

      }

      @Override
      protected void paintComponent(Graphics g) {
            g.setColor(Color.black);
            g.fillRect(0, 0, 800, 600);
            playerTank.draw(g);
            for (int i = 0; i < enermyTanks.size(); i++) {
                  enermyTanks.get(i).draw(g);
            }
            for (int i = 0; i < walls.size(); i++) {
                  walls.get(i).draw(g);
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
