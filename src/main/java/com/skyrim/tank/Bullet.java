package com.skyrim.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Skyrim on 2021/5/30 12:08
 */
public class Bullet {
    private Integer x, y;
    private Direct dir;
    private static BufferedImage ImageDir = ResourcesMgr.bulletU;
    public static int WIDTH = ImageDir.getWidth(), HEIGHT = ImageDir.getHeight();
    private static final Integer SPEED = 15;
    private Boolean live = true;
    private TankFrame tf = null;

    public Bullet(Integer x, Integer y, Direct dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live) {
            tf.bullets.remove(this);
        }
//        Color color = g.getColor();
//        g.setColor(Color.red);
//        g.fillOval(x, y, WIDTH, HEIGHT);
//        g.setColor(color);
        switch (dir) {
            case UP:
                ImageDir = ResourcesMgr.bulletU;
                break;
            case DOWN:
                ImageDir = ResourcesMgr.bulletD;
                break;
            case LEFT:
                ImageDir = ResourcesMgr.bulletL;
                break;
            case RIGHT:
                ImageDir = ResourcesMgr.bulletR;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dir);
        }
        g.drawImage(ImageDir, x, y, null);

        move();
    }

    public void move() {
        switch (dir) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dir);
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_WEIDTH || y > TankFrame.GAME_HEIGHT) {
            live = false;
        }
    }

    public Boolean getLive() {
        return live;
    }
}
