package org.example;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        try {
            BufferedImage image2 = ImageIO.read(App.class.getClassLoader().getResourceAsStream("images/仰卧起坐鸭.jpg"));
            System.out.println(image2.getGraphics());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
