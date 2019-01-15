import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.*;
public class AlgoHelper{
    private AlgoHelper(){}

    public static void setStrokeWidth(Graphics2D g2d,int w){
        int stroke=w;
        g2d.setStroke(new BasicStroke(stroke,BasicStroke.CAP_ROUND,BasicStroke.JOIN_ROUND));
    }
    public static void strokeCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle=new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.draw(circle);
    }
    public static void fillCircle(Graphics2D g2d,int x,int y,int r){
        Ellipse2D circle=new Ellipse2D.Double(x-r,y-r,2*r,2*r);
        g2d.fill(circle);
    }
    public static void setColor(Graphics2D g2d,Color C){
        g2d.setColor(C);
    }

    public static void pause(int t){
        try{
            Thread.sleep(t);
        }
        catch(InterruptedException e)
        {
            System.out.println("Error in sleeping!");
        }
    }
}