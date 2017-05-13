package FrontEnd.Levels;

import BackEnd.*;
import FrontEnd.Control.AttackLocation;
import FrontEnd.Control.MousePointer;
import FrontEnd.Objects.Cities;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.util.*;
import java.util.List;

public class MissileCommanderv1 extends GameHandler {


    MousePointer pointer;
    LinkedList <Cities> cities = new LinkedList<Cities>();

    public void Start(){
        StartOfScene();
        this.addMouseListener(pointer);


    }

    public void Update(){

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






}
