package org.example;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Skyrim on 2021/6/3 1:01
 */
public class imageTest {

    @Test
    public void test(){
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\KaiXuan\\Desktop\\learning\\tank\\src\\images\\仰卧起坐鸭.jpg"));
            assertNotNull(image);

            BufferedImage image2 = ImageIO.read(imageTest.class.getClassLoader().getResourceAsStream("仰卧起坐鸭.jpg"));
            assertNotNull(image2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
