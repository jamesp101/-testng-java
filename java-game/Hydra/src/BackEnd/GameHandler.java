package BackEnd;

import BackEnd.Utilities.Time;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.lang.management.OperatingSystemMXBean;

public abstract class GameHandler extends Canvas implements  Runnable{


    private boolean running;
    protected Color backgroundColor  = Color.blue;

    public abstract void Start();
    public abstract void Update();

    private Thread thread = new Thread(this);
    public ObjectHandler objectHandler;



    public synchronized void start(){
        objectHandler = new ObjectHandler();
        objectHandler.StartObjects();

        Start();
        running =true;
        thread.start();
    }
    public void update() {
        Update();
        objectHandler.UpdateObjects();

    }
    public void render(){
        BufferStrategy bs = this.getBufferStrategy();
        if(bs == null){
            createBufferStrategy(2);
            return;
        }

        //check if operating system is linux
        //if yes then do this
        if(Main.operatingSystem.equals("linux")){
            Toolkit.getDefaultToolkit().sync();

        }
            Graphics g = bs.getDrawGraphics();
            g.setColor(backgroundColor);
            g.fillRect(0, 1, Main.windowWidth, Main.windowWidth);


            objectHandler.RenderObjects(g);

            g.dispose();
            bs.show();

    }


    public void run(){
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;
        while(running)
        {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            Time.deltaTime = delta;
            lastTime = now;
            while(delta >=1)
            {

                update();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000)
            {
                timer += 1000;
                System.out.println("FPS: "+ frames);
                frames = 0;
            }


        }

    }
    public void stop(){
       if(running){
           running= false;
           thread.interrupt();
       }
    }


}
