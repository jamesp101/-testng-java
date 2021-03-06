package FrontEnd.Objects;

import BackEnd.GameObject;
import BackEnd.Main;
import org.omg.CORBA.Object;
import BackEnd.*;
import BackEnd.Utilities.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by pandan on 5/2/2017.
 */
public class Missile extends GameObject{


    public Missile(int x, int y, int targetX, int targetY, ObjectHandler handler){
        setCurrentX(x);
        setCurrentY(y);
        this.targetX = targetX;
        this.targetY = targetY;
        this.handler = handler;
    }
    int targetY,targetX;

    double missileSpeed =14;

    double initialX;
    double initialY;


    ObjectHandler handler;
    javax.swing.Timer tm;
    ActionListener ac ;

    boolean timeUp = false;

    private Collider collision;
    @Override
    public void Start() {

        collision = new Collider(getCurrentX() + 4,getCurrentY() + 4,10,10);
        initialX = getCurrentX();
        initialY = getCurrentY();

        ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
             timeUp = true;
            }
        };

        tm = new Timer(10000,ac);

        objectID = "playermissile";

        c = collision;
    }


    @Override
    public void Update() {

        if(timeUp){
            tm.removeActionListener(ac);
            handler.RemoveObject(this);
        }


        //get angle of the target
        double diffX = targetX - initialX + 14;
        double diffY = targetY - initialY + 14;
        double angle = Math.atan2(diffY, diffX);



        setCurrentY( getCurrentY()+missileSpeed * Math.sin(angle));
        setCurrentX(getCurrentX()+ missileSpeed * Math.cos(angle));

        //check if missile is out of screen
        // if true then destroy this object
        if((getCurrentY() > Main.windowHeight || getCurrentX() > Main.windowWidth) ||
             getCurrentY() < 0 || getCurrentX() < 0 ) {
            handler.RemoveObject(this);

        }



        collision.UpdateLocation(getCurrentX(),getCurrentY());

    }

    @Override
    public void Render(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        g.setColor(Color.white);
        g.fillRect((int)getCurrentX(),(int)getCurrentY(),8,8);
        collision.RenderCollider(graphics);
    }




}
