package main.Tools;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GTime {

    ActionListener ac;
    Timer timer;

    public int time;
    boolean timeUp;



    boolean isLooped;



    public GTime(int time, boolean loop){

        this.time = time;
        this.isLooped = loop;

    }
    public GTime(int time){

        this.time = time;
        this.isLooped = false;

    }


    public void StartTimer(){

        ac = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                timeUp = true;

                //check kung gi loop ang timer
                if(!isLooped){
                    timer.removeActionListener(ac);
                }else{

                }
            }
        };

        timer = new Timer(time,ac);
    }


    public boolean isTimeUp(){

        return timeUp;
    }

}
