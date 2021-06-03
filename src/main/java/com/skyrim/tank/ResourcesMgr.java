package com.skyrim.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Created by Skyrim on 2021/6/3 21:46
 */
public class ResourcesMgr {
    public static BufferedImage tankU, tankD, tankL, tankR;
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    static {
        try {
            tankU = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("tankU.gif"));
            tankD = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("tankD.gif"));
            tankL = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("tankL.gif"));
            tankR = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("tankR.gif"));

            bulletU = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("bulletU.gif"));
            bulletD = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("bulletD.gif"));
            bulletL = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("bulletL.gif"));
            bulletR = ImageIO.read(ResourcesMgr.class.getClassLoader().getResourceAsStream("bulletR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
