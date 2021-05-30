package com.skyrim.tank;

import java.awt.*;

/**
 * Created by Skyrim on 2021/5/24 21:59
 */
public class Tank {
    private int x, y;
    private Direct dir = null;
    private int SPEED;
    private Boolean moving= false;

    public Tank(int x, int y, Direct dir, int SPEED) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.SPEED = SPEED;
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
        g.fillRect(x, y, 50, 50);
        move();
    }

    public void move(){
        if (!moving){
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
}
