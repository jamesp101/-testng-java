package BackEnd;

import java.awt.*;
import java.util.LinkedList;

public class ObjectHandler {

     public LinkedList<GameObject> objects = new LinkedList<GameObject>();

    public void StartObjects(){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.Start();
        }
    }

    public void UpdateObjects(){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.Update();

        }
    }
    public void RenderObjects(Graphics g){
        for(int i = 0; i < objects.size(); i++){
            GameObject tempObject = objects.get(i);
            tempObject.Render(g);
        }
    }

    public void AddObject(GameObject object){

        this.objects.add(object);
        object.Start();
    }

    public void RemoveObject(GameObject object){
        this.objects.remove(object);
    }


}
