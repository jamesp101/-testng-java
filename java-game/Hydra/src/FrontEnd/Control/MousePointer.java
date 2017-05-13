package FrontEnd.Control;

import BackEnd.GameHandler;
import BackEnd.GameObject;
import BackEnd.Main;

import javax.imageio.ImageIO;
import javax.swing.plaf.synth.SynthTextAreaUI;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import BackEnd.*;
import FrontEnd.Objects.Missile;

public class MousePointer extends GameObject implements MouseListener{

   public int state = 0;

   private ObjectHandler handler;

    public MousePointer(ObjectHandler handler){
        setCurrentY( MouseInfo.getPointerInfo().getLocation().y);
        setCurrentX(MouseInfo.getPointerInfo().getLocation().x);
        this.handler = handler;
    }

    Image image;

    public void Start(){

        try{
            image = ImageIO.read(new File("Sprite/aa.png"));
        }
        catch (Exception e){
            System.out.println(e+ "MousePointer");
        }




    }
    public void Update(){

        switch(state){
            default:
                break;
            case 0:
                try{
                    image = ImageIO.read(new File("Sprite/aa.png"));
                }
                catch (Exception e){
                    System.out.println(e+ "MousePointer");
                }
                break;
            case 1:
                try{

                   handler.AddObject(new AttackLocation(getCurrentX(),getCurrentY(),handler));
                   handler.AddObject(new Missile(600,600,(int)getCurrentX(),(int)getCurrentY(),handler));

                }
                catch (Exception e){
                    System.out.println(e+ "MousePointer");
                }
                break;


        }
        state = 0;

        setCurrentY(MouseInfo.getPointerInfo().getLocation().y-Main.frame.getY() - 16);
         setCurrentX(MouseInfo.getPointerInfo().getLocation().x-Main.frame.getX() - 16);


       // System.out.println(getCurrentX() + "  " + getCurrentY());
    }
    public void Render(Graphics graphics){
        Graphics2D graphics2D =(Graphics2D) graphics;
        graphics2D.drawImage(image,(int)getCurrentX(),(int)getCurrentY(),32,32,this);
      /*  AffineTransform old = graphics2D.getTransform();
        graphics2D.rotate(Math.toDegrees(40));
        graphics2D.setTransform(old);

    */


    }
    public void mouseExited(MouseEvent e){

    }
    public void mouseEntered(MouseEvent e) {

    }
    public void mouseClicked (MouseEvent e){

    }
    public void mouseReleased(MouseEvent e){
        state =0;
    }
    public void mousePressed(MouseEvent e){
        state =1;
    }



}
