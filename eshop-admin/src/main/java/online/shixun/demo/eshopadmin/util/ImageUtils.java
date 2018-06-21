package online.shixun.demo.eshopadmin.util;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ImageUtils {
    /**
     * 按照固定宽高原图压缩
     *
     * @param inImg
     * @param width
     * @param height
     * @param outImg
     * @throws IOException
     */
    public static void thumbnail(InputStream inImg, int width, int height, OutputStream outImg) throws IOException {
        BufferedImage BI = ImageIO.read(inImg);
        Image image = BI.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        BufferedImage tag = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = tag.getGraphics();
        g.setColor(Color.RED);
        g.drawImage(image, 0, 0, null); // 绘制处理后的图
        g.dispose();
        ImageIO.write(tag, "JPEG", outImg);
    }
}
