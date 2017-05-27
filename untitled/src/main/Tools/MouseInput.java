package main.Tools;

import java.awt.event.*;

/**
 * Created by hal on 5/27/17.
 */
public class MouseInput implements Runnable{
//kuha sa input sa mouse
    public static MouseListener mouseListener;
    public static MouseMotionAdapter s;

   static int mouseClick = 0;
    int mousePressed;
    int mouseReleased;


    public  MouseInput(){

        run();
    }



    // kung gusto ka makuha ang input sa mouse
    //MouseInput.getMouseClick
    //integer ang ireturn ani
    public static int getMouseClick(){
        return mouseClick;

    }


    @Override
    public void run() {
        System.out.println("hellow");

        mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                mouseClick =  mouseEvent.getID();
                System.out.println("asdasd");
                mouseClick = 0;
            }

            @Override
            public void mousePressed(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseReleased(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseEntered(MouseEvent mouseEvent) {

            }

            @Override
            public void mouseExited(MouseEvent mouseEvent) {

            }
        };
    }
}
