package com.skyrim.tank;

import java.awt.*;
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
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fillRect(x+=10,y+=10,50,50);
    }
}
