package main.Game;

import main.GameObject;

import java.awt.*;

/**
 * Created by hal on 5/27/17.
 */
public class SampleObject extends GameObject {
    public SampleObject(int x, int y) {
        super(x, y);
    }
    public SampleObject() {

    }
    @Override
    public void Start() {

    }

    @Override
    public void Update() {

    }



    @Override
    public void Render(Graphics graphics) {


        graphics.fillRect(30,30,33,23);
        graphics.setColor(Color.GREEN);
    }
}
