package FrontEnd.Objects;

import BackEnd.GameHandler;
import BackEnd.GameObject;
import BackEnd.Main;
import BackEnd.ObjectHandler;
import BackEnd.Utilities.Collider;

import javax.swing.text.MutableAttributeSet;
import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by hal on 5/13/17.
 */
public class EnemyMissile extends GameObject {

    float width = 15;
    float height = 15;

    float initialx;
    float initialy;

    public Collider collider;
    float targetx;
    float targety;

    float missileSpeed = 2;
    ObjectHandler handler;

    boolean isHit = false;

    public EnemyMissile (float x, float y, ObjectHandler handler){
        setCurrentX(x);
        setCurrentY(y);

        initialx = x;
        initialy = y;
        this.objectID = "enemymissile";
        this.handler = handler;
    }

    @Override
    public void Start() {
        collider = new Collider(getCurrentX(),getCurrentY(),width,height);
        this.c = collider;



        targetx = ThreadLocalRandom.current().nextInt(1,1280);
        targety = 720;


    }


    @Override
    public void Update() {
        float diffx =targetx - initialx + 2;
        float diffy =targety - initialy + 2;

        double angle = Math.atan2(diffy,diffx);

        setCurrentY( getCurrentY()+missileSpeed * Math.sin(angle));
        setCurrentX(getCurrentX()+ missileSpeed * Math.cos(angle));

        for(GameObject go: handler.objects){
            if(go.objectID.equals("playermissile") && !go.objectID.equals(null)){
                if(go.c != null){
                    if(collider.CheckCollision(go.c)){
                       isHit = true;
                    }
                }
            }
        }
        if(isHit){
            handler.RemoveObject(this);
        }

        collider.UpdateLocation(getCurrentX(),getCurrentY());

    }

    @Override
    public void Render(Graphics graphics) {
        graphics.fillRect((int)getCurrentX(),(int)getCurrentY(),4,4);
        collider.RenderCollider(graphics);
    }
}
