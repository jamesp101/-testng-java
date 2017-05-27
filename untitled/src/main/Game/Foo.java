package main.Game;

import main.GameObject;

import java.awt.*;

/**
 * Created by hal on 5/27/17.
 */
public class Foo extends GameObject {
    public Foo(int x, int y) {
        super(x, y);
    }
    public Foo() {

    }
    @Override
    public void Start() {

    }

    @Override
    public void Update() {

    }



    @Override
    public void Render(Graphics graphics) {

        graphics.fillRect(0,0,0,0);
        graphics.setColor(Color.yellow);
    }
}
