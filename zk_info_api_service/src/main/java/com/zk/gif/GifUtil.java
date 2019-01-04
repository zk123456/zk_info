package com.zk.gif;

import com.gif4j.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * @Author Zhangk
 * @Date 18:08 2018/11/9
 * @Description
 */
public class GifUtil {
    /**
     * 缩放gif图片
     * @param src
     * @param dest
     * @param width
     * @param height
     * @throws IOException
     */
    public static void makeGif(File src, File dest, int width, int height)
            throws IOException {
        GifImage gifImage = GifDecoder.decode(src);// 创建一个GifImage对象.
        GifImage resizeIMG = GifTransformer.resize(gifImage, width, height,
                true);
        GifEncoder.encode(resizeIMG, dest);
    }

    public static void makeGif(String src, String dest, int width, int height)
            throws IOException {
        GifImage gifImage = GifDecoder.decode(new File(src));// 创建一个GifImage对象.
        makeGif(new File(src), new File(dest), gifImage.getScreenWidth() / 2,
                gifImage.getScreenHeight() / 2);

    }

    public static void makeGif(File src, File dest) throws IOException {
        GifImage gifImage = GifDecoder.decode(src);// 创建一个GifImage对象.
        makeGif(src, dest, gifImage.getScreenWidth() / 2, gifImage
                .getScreenHeight() / 2);

    }

    public static void makeGif(String src, String dest) throws IOException {
        makeGif(new File(src), new File(dest));
    }

    /**
     * 在图片中加文字水印
     * @param src
     * @param watermarkText
     * @param dest
     * @throws IOException
     */
    public static void addTextWatermarkToGif(File src, String watermarkText, File dest)throws IOException {
        //水印初始化、设置（字体、样式、大小、颜色）
        TextPainter textPainter = new TextPainter(new Font("黑体", Font.ITALIC, 12));
        textPainter.setOutlinePaint(Color.WHITE);
        BufferedImage renderedWatermarkText = textPainter.renderString(watermarkText, true);
        //图片对象
        GifImage gf = GifDecoder.decode(src);
        //获取图片大小
        int iw = gf.getScreenWidth();
        int ih = gf.getScreenHeight();
        //获取水印大小
        int tw = renderedWatermarkText.getWidth();
        int th = renderedWatermarkText.getHeight();
        //水印位置
        Point p = new Point();
        p.x = iw - tw - 5;
        p.y = ih - th - 4;
        //加水印
        Watermark watermark = new Watermark(renderedWatermarkText, p);
        gf = watermark.apply(GifDecoder.decode(src), true);
        //输出
        GifEncoder.encode(gf, dest);

    }

    /**
     * 在图片中加图片水印
     * @param src
     * @param dest
     * @throws IOException
     */
    public static void addImageWatermarkToGif(File src, String watermarkPath, File dest)throws IOException {
        BufferedImage renderedWatermarkText = ImageIO.read(new File(watermarkPath));
        //图片对象
        GifImage gf = GifDecoder.decode(src);
        //获取原始图片大小
        int width = gf.getScreenWidth();
        int height = gf.getScreenHeight();
        //获取水印大小
        int width_biao = renderedWatermarkText.getWidth();
        int height_biao = renderedWatermarkText.getHeight();


        int new_width_biao = width_biao;

        int new_height_biao = height_biao;

        if(width_biao > width){

            new_width_biao = width;

            new_height_biao = (int) ((double)new_width_biao/width_biao*height);

        }

        if(new_height_biao > height){

            new_height_biao = height;

            new_width_biao = (int)

                    ((double)new_height_biao/height_biao*new_width_biao);

        }

            /*int x = (width-new_width_biao)/2;
            int y = (height-new_height_biao)/2;*/
        int x = width-new_width_biao;
        int y = height-new_height_biao;

        //水印位置
        Point p = new Point();
        p.x = x;
        p.y = y;
        //加水印
        Watermark watermark = new Watermark(renderedWatermarkText, p);
        //水印透明度
        watermark.setTransparency(50);
        gf = watermark.apply(GifDecoder.decode(src), false);
        //输出
        GifEncoder.encode(gf, dest);

    }


    public static void main(String[] arg) throws Exception{
        GifUtil.addImageWatermarkToGif(new File("C:\\Users\\Administrator.000\\Pictures\\11.gif"),
                "C:\\Users\\Administrator.000\\Pictures\\watermark.png", new File("C:\\Users\\Administrator.000\\Pictures\\5.gif"));
    }
}
