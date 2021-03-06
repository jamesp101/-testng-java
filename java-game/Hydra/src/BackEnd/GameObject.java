package BackEnd;

import BackEnd.Utilities.Collider;

import javax.swing.*;
import java.awt.*;

public abstract class GameObject extends JComponent {



    public GameObject(){
        currentY = Main.windowHeight /2;
        currentX = Main.windowWidth /2;
    }
    public GameObject(int x, int y){
        this.currentX = x;
        this.currentY = y;
    }

    private double currentX;
    private double currentY;
    public String objectID ="defaultID";
    public Collider c;

    public double getCurrentY() {
        return currentY;
    }

    public double getCurrentX(){
        return currentX;
    }

    public void setCurrentY(double currentY) {
        this.currentY = currentY;
    }

    public void setCurrentX(double currentX) {
        this.currentX = currentX;
    }

    public abstract void Start();
    public abstract void Update();
    public abstract void Render(Graphics graphics);

}
