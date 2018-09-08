import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

/**
 * @Author: yanshilong
 * @Date: 18-9-9 上午12:04
 * @Version 1.0
 */
public class OpenPng {
    public String OcrTest(String path){
        String aa = null;
        BASE64Encoder encoder = new sun.misc.BASE64Encoder();
        File file=new File(path);
        BufferedImage bi;

        try {
            bi=ImageIO.read(file);
            ByteArrayOutputStream baos=new ByteArrayOutputStream();
            ImageIO.write(bi,"png",baos);
            byte[] bytes=baos.toByteArray();
           aa=encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return aa;
    }

    public static void main(String[] args) {
        OpenPng pp=new OpenPng();
        String aaa=pp.OcrTest("/home/syl/图片/2018-07-15 09-49-48 的屏幕截图.png");
        System.out.println(aaa);
    }
}
