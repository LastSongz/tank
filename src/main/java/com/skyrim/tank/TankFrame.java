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
    public TankFrame() throws HeadlessException {
        setSize(800,600);
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
        g.fillRect(x+=10,y+=10,50,50);
    }

    /**
     * 自定义键盘监听内部类
     */
    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("keyPressed");
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
        }
    }
}
