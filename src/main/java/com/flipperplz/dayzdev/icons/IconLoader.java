package com.flipperplz.dayzdev.icons;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class IconLoader {

    private static final Map<String, Icon> cache = new HashMap<>();

    public static Icon loadIcon(String name) {
        Icon icon = cache.get(name);
        if (icon != null)
            return icon;
        String filepath = "./icons/" + name + ".png";
        try {
            URL url = IconLoader.class.getClassLoader().getResource(filepath);
            System.out.println("Loading Icon for " + name + " from " + url);
            BufferedImage img = ImageIO.read(url);
            icon = new ImageIcon(img.getScaledInstance(16,16,BufferedImage.SCALE_SMOOTH));
            cache.put(name, icon);
            return icon;
        } catch (Exception e) {
            System.err.println("Could not load Icon: " + filepath + " Exception: " + e.getClass().getSimpleName() + " Message: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}
