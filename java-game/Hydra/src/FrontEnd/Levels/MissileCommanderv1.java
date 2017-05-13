package FrontEnd.Levels;

import BackEnd.*;
import FrontEnd.Control.AttackLocation;
import FrontEnd.Control.MousePointer;
import FrontEnd.Objects.Cities;
import FrontEnd.Objects.EnemyMissile;
import FrontEnd.Objects.Missile;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class MissileCommanderv1 extends GameHandler {


    MousePointer pointer;
    LinkedList <Cities> cities = new LinkedList<Cities>();

    int level = 0;
    float timed;

    javax.swing.Timer timer;
    javax.swing.Timer spawnTimer;

    ActionListener ac;
    ActionListener spawnAction;


    public void Start(){
        StartOfScene();
        this.addMouseListener(pointer);
        level =1;
        Levels();
    }

    public void Update(){
        if (!timer.isRunning()){
            System.out.println("Level:" +level);

            Levels();
            timer.start();
        }

    }


    void StartOfScene(){
        backgroundColor = java.awt.Color.black;

        int citiesLocation = 30;
        float div = Main.windowWidth/6;

        for(int a = 0; a <= 6; a++){
            cities.add(new Cities(citiesLocation,500))  ;
            objectHandler.AddObject(cities.get(a));
            citiesLocation += div;
        }
        pointer = new MousePointer(this.objectHandler);
        objectHandler.AddObject(pointer);



        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Point hotSpot = new Point(0,0);
        BufferedImage cursorImage = new BufferedImage(1, 1, BufferedImage.TRANSLUCENT);
        Cursor invisibleCursor = toolkit.createCustomCursor(cursorImage, hotSpot, "InvisibleCursor");
        this.setCursor(invisibleCursor);
        this.addMouseListener(pointer);
    }

    void Levels(){
        timed = (level * 3000);


         ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                timer.stop();
                spawnTimer.stop();
                level++;
            }
        };


         spawnAction = new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent actionEvent) {
            objectHandler.AddObject(new EnemyMissile( ThreadLocalRandom.current().nextInt(1,1280+1),1,objectHandler));
             }
         };


        timer =  new Timer((int)timed,ac);
        timer.start();


        int t = (int)(timed/level)/ (level - (level/2));
        System.out.println(t);
         spawnTimer = new Timer(t,spawnAction);
         spawnTimer.start();

    }

}
