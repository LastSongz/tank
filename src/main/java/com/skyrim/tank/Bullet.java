package com.skyrim.tank;

import java.awt.*;

/**
 * Created by Skyrim on 2021/5/30 12:08
 */
public class Bullet {
    private static Integer x, y;
    private static Direct dir;
    private Integer WIDTH = 5, HEIGHT = 5;
    private final Integer SPEED = 5;

    public Bullet(Integer x, Integer y,Direct dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x, y, WIDTH, HEIGHT);;
        g.setColor(color);
        move();
    }
    public void move(){
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
}
