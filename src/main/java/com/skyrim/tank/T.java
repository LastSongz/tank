package com.skyrim.tank;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by Skyrim on 2021/5/22 14:10
 */
public class T {
    public static void main(String[] args) throws InterruptedException {
//        Frame frame = new Frame();
//        frame.setSize(800,600);
//        frame.setResizable(false);
//        frame.setTitle("TAnk War");
//        frame.addWindowListener(new WindowAdapter() {
//            @Override
//            public void windowClosing(WindowEvent e) {
//                System.exit(0);
//            }
//        });
//        frame.setVisible(true);


        TankFrame frame = new TankFrame();

        for (int i = 0; i < 5; i++) {
            frame.enemies.add(new Tank(200, 200 + i * 60, Direct.DOWN, 50, frame));
        }

        while (true) {
            Thread.sleep(50);
            frame.repaint();
        }
    }
}
