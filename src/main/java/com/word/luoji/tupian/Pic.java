package com.word.luoji.tupian;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.*;
import java.io.*;


public class Pic {

    public float bilv(String a,String b){
        float percent = compare(getData(a),
                getData(b));
        return percent;
    }
    public static int[] getData(String name) {
        try {
            BufferedImage img = ImageIO.read(new File(name));
            BufferedImage slt = new BufferedImage(100, 100,
                    BufferedImage.TYPE_INT_RGB);
            slt.getGraphics().drawImage(img, 0, 0, 100, 100, null);

            int[] data = new int[256];
            for (int x = 0; x < slt.getWidth(); x++) {
                for (int y = 0; y < slt.getHeight(); y++) {
                    int rgb = slt.getRGB(x, y);
                    Color myColor = new Color(rgb);
                    int r = myColor.getRed();
                    int g = myColor.getGreen();
                    int b = myColor.getBlue();
                    data[(r + g + b) / 3]++;
                }
            }

            return data;
        } catch (Exception exception) {
            return null;
        }
    }

    public static float compare(int[] s, int[] t) {
        try {
            float result = 0F;
            for (int i = 0; i < 256; i++) {
                int abs = Math.abs(s[i] - t[i]);
                int max = Math.max(s[i], t[i]);
                result += (1 - ((float) abs / (max == 0 ? 1 : max)));
            }
            return (result / 256) * 100;
        } catch (Exception exception) {
            return 0;
        }
    }
}
