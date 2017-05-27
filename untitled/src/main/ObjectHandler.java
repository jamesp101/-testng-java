package main;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by hal on 5/27/17.
 */
public class ObjectHandler {

    public LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void AddObject(GameObject object){
        //create object
        objects.add(object);
        object.Start();
    }


    public void DestroyObject(GameObject object){
        //remove object
        objects.remove(objects);
    }

    public void StartObjects(){
        //initialize Do Start() in game objects
        //Do Start() in the first frame
        for(GameObject temp: objects){
            temp.Start();
        }
    }



    public void UpdateObjects(){
        //update all objects each frame
        for(GameObject temp: objects){
            temp.Update();
        }
    }

    public void Render(Graphics graphics){
        //render all objects each frame
        for(GameObject temp: objects){
            temp.Render(graphics);
        }
    }
}
