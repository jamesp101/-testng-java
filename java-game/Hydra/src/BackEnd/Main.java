package BackEnd;

import javax.swing.*;
import java.awt.*;
import FrontEnd.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import FrontEnd.Levels.MissileCommanderv1;


public class Main {

    public static int windowWidth = 1280;
    public static int windowHeight = 720;

    public static JFrame frame;
    private static GameHandler handler;


    public static String operatingSystem;

    public static void main(String args [] ){

        operatingSystem = System.getProperty("os.name").toLowerCase();

        frame  = new JFrame();
        handler = new MissileCommanderv1();


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(windowWidth,windowHeight));
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.add(handler);
        System.out.println(frame.getComponent(0).toString());
        handler.start();



    }
    public static void ReplaceComponent(Component component){
        frame.remove(frame.getComponent(0));
        frame.add(component);
    }


}
