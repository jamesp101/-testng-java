package FrontEnd.Objects;

import BackEnd.*;
import BackEnd.Utilities.ImageHandler;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.Buffer;
import javax.imageio.ImageIO;

public class Cities extends  GameObject{

    public Cities(int x,int y){
        super.setCurrentX(x);
        super.setCurrentY(y);
    }

    BufferedImage image;

    @Override
    public void Update() {

    }

    @Override
    public void Start() {
       image =  ImageHandler.GetBufferedImage("Sprite/Sprite-0001.png");
    }

    @Override
    public void Render(Graphics graphics) {
        Graphics2D graphics2D =(Graphics2D) graphics;

        graphics2D.drawImage(image,(int)getCurrentX(),(int)getCurrentY(),128,128,this);


    }
}
