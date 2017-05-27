package main;

import main.Game.Foo;
import main.Game.SampleObject;
import main.Tools.*;
import main.*;


import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.BufferedReader;

/**
 * Created by hal on 5/27/17.
 */
public class GameHandler extends Canvas implements Runnable{

    public MouseInput mouseInput;
    public boolean isRunning;

    public static ObjectHandler objectHandler;

    public  ReadMap readMap;


    public synchronized void start(){
        readMap = new ReadMap();

        isRunning =true;

        objectHandler = new ObjectHandler();


        readMap.openFile("map/map-test.txt");


        objectHandler.AddObject(new Foo());

        objectHandler.StartObjects();


        readMap.readFile();
        mouseInput = new MouseInput();
        addMouseListener(mouseInput.mouseListener);
        run();


    }



    public synchronized void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(3);
            return;
        }
        //check if operating system is linux
        //if yes then do this
       if(MainClass.OS.equals("linux")){
          Toolkit.getDefaultToolkit().sync();

       }
        Graphics g = bs.getDrawGraphics();



        g.setColor(Color.black);
        g.fillRect(0, 0, 3000, 3000);

        objectHandler.Render(g);








        g.dispose();
        bs.show();
    }

    public void update(){
    objectHandler.UpdateObjects();
    }

    public void run(){

        long lastTime = System.nanoTime();

        //set the the update 60/sec
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(isRunning)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;

            lastTime = now;
            while(delta >=1)
            {

                update();
                delta--;
            }
            if(isRunning)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                System.out.println("fps:" + frames);
                timer += 1000;

                frames = 0;
            }


        }


    }
}
