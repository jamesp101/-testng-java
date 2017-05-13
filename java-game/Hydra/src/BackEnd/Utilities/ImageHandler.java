package BackEnd.Utilities;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;

/**
 * Created by pandan on 4/30/2017.
 */
public class ImageHandler {

    public static Image GetImage(String pathname){
        try{
          Image  image = ImageIO.read(new File(pathname));
            return  image;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }
    public static BufferedImage GetBufferedImage(String pathname){
        try{
            BufferedImage  image = ImageIO.read(new File(pathname));
            return  image;
        }
        catch (Exception e){
            System.out.println(e);
        }
        return  null;
    }





}
