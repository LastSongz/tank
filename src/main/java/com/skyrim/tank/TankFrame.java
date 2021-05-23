package com.skyrim.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Skyrim on 2021/5/23 10:29
 */
public class TankFrame extends Frame {
    int x = 200;
    int y = 200;
    Direct dir = Direct.UP;
    private final int SPEED = 10;

    public TankFrame() throws HeadlessException {
        setSize(800, 600);
        setResizable(false);
        setTitle("TAnk War");
        setVisible(true);
        //添加一个键盘监听器
        addKeyListener(new MyKeyListener());

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x, y, 50, 50);
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
//        y+=10;
    }

    /**
     * 自定义键盘监听内部类
     */
    class MyKeyListener extends KeyAdapter {
        boolean bu = false;
        boolean bd = false;
        boolean bl = false;
        boolean br = false;

        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bu = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + key);
            }
            setTankDir();
//            System.out.println("keyPressed");
//            x+=10;
//            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key) {
                case KeyEvent.VK_UP:
                    bu = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                case KeyEvent.VK_LEFT:
                    bl = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + key);
            }
            setTankDir();
        }

        private void setTankDir() {
            if (bu) {
                dir = Direct.UP;
            }

            if (bd) {
                dir = Direct.DOWN;
            }
            if (bl) {
                dir = Direct.LEFT;
            }
            if (br) {
                dir = Direct.RIGHT;
            }

        }
    }
}
