package com.skyrim.tank;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Skyrim on 2021/5/24 21:59
 */
public class Tank {
    private int x, y;
    private static BufferedImage ImageDir = ResourcesMgr.tankU;
    public static int WIDTH = ImageDir.getWidth(), HEIGHT = ImageDir.getHeight();
    private Direct dir = Direct.UP;
    private int SPEED;
    private Boolean moving = false;
    private TankFrame tf;
    private Boolean living = true;

    public Tank(int x, int y, Direct dir, int SPEED, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.SPEED = SPEED;
        this.tf = tf;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Direct getDir() {
        return dir;
    }

    public void setDir(Direct dir) {
        this.dir = dir;
    }

    public int getSPEED() {
        return SPEED;
    }

    public void setSPEED(int SPEED) {
        this.SPEED = SPEED;
    }

    public Boolean getMoving() {
        return moving;
    }

    public void setMoving(Boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        if (!living) {
            tf.enemies.remove(this);
        }
//        Color color = g.getColor();
//        g.setColor(Color.cyan);
//        g.fillRect(x, y, WIDTH, HEIGHT);
//        g.setColor(color);
        switch (dir) {
            case UP:
                ImageDir = ResourcesMgr.tankU;
                break;
            case DOWN:
                ImageDir = ResourcesMgr.tankD;
                break;
            case LEFT:
                ImageDir = ResourcesMgr.tankL;
                break;
            case RIGHT:
                ImageDir = ResourcesMgr.tankR;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + dir);
        }
        g.drawImage(ImageDir, x, y, null);
        move(g);
    }

    public void move(Graphics g) {
        if (!moving) {
            return;
        }
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
    }

    public void fire() {
        int bx = this.x + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + Tank.HEIGHT / 2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bx, by, this.dir, this.tf));
    }
    public Boolean getLiving() {
        return living;
    }
    public void die() {
        this.living = false;
    }
}
