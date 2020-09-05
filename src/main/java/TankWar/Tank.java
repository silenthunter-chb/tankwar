package TankWar;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Random;

public class Tank {
      public static final int MOVE_SPEED = 5;
      private int x, y; //坦克坐标
      private Direction direction; //枚举类对象
      private boolean enermy; //判断坦克是否为电脑敌方

      public Tank(int x, int y, Direction direction) {
            this.x = x;
            this.y = y;
            this.direction = direction;
      }

      public Tank(int x, int y, boolean enermy, Direction direction) {
            this(x, y, direction);
            this.enermy = enermy;
      }

      void move() { //根据枚举值控制坦克坐标
            if (this.stopped) {
                  return;
            }
            x+=direction.xFactor * MOVE_SPEED;
            y+=direction.yFactor * MOVE_SPEED;
      }

      Image getImage() {
            String prefix = (this.enermy ? "e" : "");
            return direction.getImage(prefix + "tank");
      }

      //负责将坦克显示到窗口。
      //先调用确定方向枚举对象的方法，再调用改变坦克坐标的方法
      void draw(Graphics g) {
            int oldX = x, oldY = y;
            this.determineDirection();
            this.move();
            if (x < 0) {
                  x = 0;
            } else if (x > 800 - this.getImage().getWidth(null)) {
                  x = 800 - this.getImage().getWidth(null);
            }
            if (y < 0) {
                  y = 0;
            } else if (y > 600 - this.getImage().getHeight(null)) {
                  y = 600 - this.getImage().getHeight(null);
            }
            Rectangle rec = this.getRectangle();
            for (int i = 0; i < GameClient.getInstance().getWalls().size(); i++) {
                  if (rec.intersects(GameClient.getInstance().getWalls().get(i).getRectangle())) {
                        x = oldX;
                        y = oldY;
                        break;
                  }
            }
            for (int i = 0; i < GameClient.getInstance().getEnermyTanks().size(); i++) {
                  if (rec.intersects(GameClient.getInstance().getEnermyTanks().get(i).getRectangle())) {
                        x = oldX;
                        y = oldY;
                        break;
                  }
            }
            g.drawImage(this.getImage(), this.x, this.y, null);
      }

      public Rectangle getRectangle() {
            return new Rectangle(x, y, this.getImage().getWidth(null), this.getImage().getHeight(null));
      }

      private boolean up, down, left, right; //布尔值储存坦克上下左右方向

      //根据用戶按下的方向键，设定方向布尔值。
      //同时按下两个键，可以改变两个方向布尔值。
      public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                        up = true;
                        break;
                  case KeyEvent.VK_DOWN:
                        down = true;
                        break;
                  case KeyEvent.VK_LEFT:
                        left = true;
                        break;
                  case KeyEvent.VK_RIGHT:
                        right = true;
                        break;
                  case KeyEvent.VK_CONTROL:
                        fire();
                        break;
                  case KeyEvent.VK_A:
                        superFire();
                        break;
            }
      }

      void superFire() {
           for (Direction direction : Direction.values()) {
                  Missile missile = new Missile
                          (x + this.getImage().getWidth(null) / 2 - 6, y + this.getImage().getHeight(null) / 2 - 6, enermy, direction);
                  GameClient.getInstance().getMissiles().add(missile);
            }
            String audioFile = new Random().nextBoolean() ? "supershoot.aiff" : "supershoot.wav";
            playAudio(audioFile);
      }

      private void playAudio(String fileName) {
            Media sound = new Media(new File("J:\\tankwar\\assets\\audios\\" + fileName).toURI().toString());
            MediaPlayer mediaPlayer = new MediaPlayer(sound);
            mediaPlayer.play();
      }

      private void fire() {
            Missile missile = new Missile
                    (x + this.getImage().getWidth(null) / 2 - 6, y + this.getImage().getHeight(null) / 2 - 6, enermy, direction);
            GameClient.getInstance().getMissiles().add(missile);
            playAudio("shoot.wav");
      }

      private boolean stopped;

      //根据方向布尔值确定枚举类的对象是哪一个
      private void determineDirection() {
            if (!up && !down && !left && !right) {
                  this.stopped = true;
            } else {
                  if (up && left && !down && !right) { // 上左
                        this.direction = Direction.LEFT_UP;
                  } else if (up && !left && !down && right) { // 上右
                        this.direction = Direction.RIGHT_UP;
                  } else if (up && !left && !down && !right) { // 上
                        this.direction = Direction.UP;
                  } else if (!up && !left && down && !right) {//下
                        this.direction = Direction.DOWN;
                  } else if (!up && left && down && !right) {//下左
                        this.direction = Direction.LEFT_DOWN;
                  } else if (!up && !left && down && right) {//下右
                        this.direction = Direction.RIGHT_DOWN ;
                  } else if (!up && left && !down && !right) { //左
                        this.direction = Direction.LEFT;
                  } else if (!up && !left && !down && right) {//右
                        this.direction = Direction.RIGHT;
                  }
                  this.stopped = false;
            }
      }

      //松开按键，所有方向布尔值false。
      public void keyReleased(KeyEvent e) {
            switch (e.getKeyCode()) {
                  case KeyEvent.VK_UP:
                        up = false;
                        break;
                  case KeyEvent.VK_DOWN:
                        down = false;
                        break;
                  case KeyEvent.VK_LEFT:
                        left = false;
                        break;
                  case KeyEvent.VK_RIGHT:
                        right = false;
                        break;
            }
      }
}
