package main.Game.Map;

import main.GameObject;

import java.awt.*;

/**
 * Created by hal on 5/27/17.
 */
public class SampleObject2 extends GameObject {
    public SampleObject2(int x, int y) {
        super(x, y);
    }
    public SampleObject2() {

    }
    @Override
    public void Start() {

    }

    @Override
    public void Update() {

    }



    @Override
    public void Render(Graphics graphics) {


        graphics.fillRect(x,y,33,23);
        graphics.setColor(Color.RED);
    }
}
