package com.skyrim.tank;

import java.awt.*;

/**
 * Created by Skyrim on 2021/5/30 12:08
 */
public class Bullet {
    private Integer x, y;
    private Direct dir;
    private static Integer WIDTH = 10, HEIGHT = 10;
    private static final Integer SPEED = 5;
    private Boolean live = true;
    private TankFrame tf = null;

    public Bullet(Integer x, Integer y, Direct dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        if (!live){
            tf.bullets.remove(this );
        }
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);
        g.setColor(color);
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
}
