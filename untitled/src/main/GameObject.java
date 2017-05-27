package main;

import javax.swing.*;
import java.awt.*;

public abstract  class  GameObject extends JComponent {
//blueprint sa mga object nmo


    public int x;
    public int y;

    public String objectName;
    public String tag;
    public  GameObject(){

    }

    public  GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }
    public  GameObject(int x, int y,String objectName){
        this.x = x;
        this.y = y;
        this.objectName = objectName;
    }

    public  GameObject(int x, int y,String objectName,String tag){
        this.x = x;
        this.y = y;
        this.objectName = objectName;
        this.tag = tag;
    }

    public abstract void Start();
    public abstract void Update();
    public abstract void Render(Graphics graphics);

    void CreateObject(){

    }
    void DestroyObject(){

    }



}
