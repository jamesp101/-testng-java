package main;

import javax.swing.*;

public class MainClass {


    public static int FRAME_WIDTH =1280, FRAME_HEIGHT=720;

    public static String OS = System.getProperty("os.name").toLowerCase();
    static JFrame frame;
    static GameHandler game;
    public static void main(String [] args){

        frame = new JFrame();
        game = new GameHandler();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(FRAME_WIDTH,FRAME_HEIGHT);

        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);


        frame.add(game);
        game.start();
    }


}
