package com.skyrim.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Skyrim on 2021/5/23 10:29
 */
public class TankFrame extends Frame {
    //    int x = 200;
//    int y = 200;
//    Direct dir = null;
//    private final int SPEED = 10;
    static final int GAME_HEIGHT = 600, GAME_WEIDTH = 800;
    List<Bullet> bullets = new ArrayList<>();
    Tank tank = new Tank(200, 200, 50, 50, Direct.UP, 10,this);

    public TankFrame() throws HeadlessException {
        setSize(GAME_WEIDTH, GAME_HEIGHT);
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

    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {
        if (offScreenImage == null){
            offScreenImage = this.createImage(GAME_WEIDTH,GAME_HEIGHT);
        }
        Graphics offScreenG = offScreenImage.getGraphics();
        Color screenGColor = offScreenG.getColor();
        offScreenG.setColor(Color.BLACK);
        offScreenG.fillRect(0,0,GAME_WEIDTH,GAME_HEIGHT);
        offScreenG.setColor(screenGColor);
        paint(offScreenG);
        g.drawImage(offScreenImage,0,0,null);
    }

    @Override
    public void paint(Graphics g) {

        Color gColor = g.getColor();
        g.setColor(Color.cyan);
        g.drawString("子弹的数量:"+bullets.size(),10,60);
        g.setColor(gColor);


        tank.paint(g);
        for (int i = 0; i < bullets.size(); i++) {
            bullets.get(i).paint(g);
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
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
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
                case KeyEvent.VK_CONTROL:
                    tank.fire();
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + key);
            }
            setTankDir();
//            stopTank();
        }

        private void setTankDir() {
            if (!bu && !bd && !bl && !br) {
                tank.setMoving(false);
            } else {
                tank.setMoving(true);
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


        }

//        坦克停止初版
//        private void stopTank(){
//            tank.setDir(null);
//        }
    }
}
