package FrontEnd.Objects;

import BackEnd.GameHandler;
import BackEnd.GameObject;
import BackEnd.ObjectHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Spawner extends GameObject {

    javax.swing.Timer tm;
    ObjectHandler handler;
    ActionListener a;

    public  Spawner(float x, float y, ObjectHandler handler){
     this.setCurrentX(x);
     this.setCurrentX(y);
     this.handler = handler;


    }

    @Override
    public void Start() {
       a = new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {

           }
       };

       tm = new Timer(10000,a);
    }


    @Override
    public void Update() {


    }

    @Override
    public void Render(Graphics graphics) {
        graphics.setColor(Color.RED);
        graphics.drawRect((int)getCurrentX(),(int)getCurrentY(),2,2);
    }

}
