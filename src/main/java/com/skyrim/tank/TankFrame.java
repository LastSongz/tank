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
//    int x = 200;
//    int y = 200;
//    Direct dir = null;
//    private final int SPEED = 10;
    Tank tank = new Tank(200,200,null,10);

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
        tank.paint(g);

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
            stopTank();
        }

        private void setTankDir() {
            if (bu) {
                tank.setDir(Direct.UP);
            }
            if (bd) {
                tank.setDir(Direct.DOWN);
            }
            if (bl) {
                tank.setDir(Direct.LEFT);
            }
            if (br) {
                tank.setDir(Direct.RIGHT);
            }

        }

        private void stopTank(){
            tank.setDir(null);
        }
    }
}
