package BackEnd.Utilities;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RectangularShape;

public class Collider  {
   public double x;
   public double y;
   public double width;
   public double height;

   public  Rectangle rectangle;
    public Collider(double x, double y, double width, double height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        rectangle = new Rectangle((int)x,(int)y,(int)width,(int)height);
    }

    public boolean CheckCollision(Collider collider) {
       return rectangle.intersects(collider.rectangle);

    }

    public void RenderCollider(Graphics g){
        g.setColor(Color.RED);
        g.drawRect((int)x, (int)y, (int) width,(int) height);

    }
    public void UpdateLocation(double x, double y){
        this.x = x;
        this.y  = y;
        rectangle = new Rectangle((int)x,(int)y,(int)width,(int)height);

    }




}
