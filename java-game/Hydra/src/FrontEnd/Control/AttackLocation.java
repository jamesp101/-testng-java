package FrontEnd.Control;

import BackEnd.GameObject;
import BackEnd.Utilities.ImageHandler;
import BackEnd.Utilities.Time;

import javax.swing.Timer;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

import BackEnd.*;

public class AttackLocation extends GameObject{


    Timer timer;
    ActionListener actionListener;
    ObjectHandler handler;
    BufferedImage image;

    public AttackLocation(double x, double y,ObjectHandler handler) {
        this.handler = handler;
        this.setCurrentX(x);
        this.setCurrentY(y);

        actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                timer.stop();
            }
        };

        timer = new Timer(900,actionListener);
        timer.start();

    }


    public void Start(){
        image = ImageHandler.GetBufferedImage("Sprite/attac.png");

    }
    public void Update(){
        if(!timer.isRunning()){
            timer.removeActionListener(actionListener);
            handler.RemoveObject(this);
        }


    }
    public void Render(Graphics graphics){
        Graphics2D graphics2D = (Graphics2D)graphics;

        graphics2D.drawImage(image,(int)getCurrentX(),(int)getCurrentY(),32,32,null);


    }


}
