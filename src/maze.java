import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Ellipse2D;

import javax.swing.*;

public class maze extends JFrame{
    private int canvasHight;
    private int canvasWidth;
    public maze(String title ,int canvasWidth,int canvasHight){
        super(title);

        this.canvasHight=canvasHight;
        this.canvasWidth=canvasWidth;

        AlgoCanvas canvas=new AlgoCanvas();
        
        setContentPane(canvas);
        pack();


        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }


    public maze(String title){
        this(title, 1024, 768);
    }

    public int getCanvasWidth(){return canvasWidth;}
    public int getCanvasHight(){return canvasHight;}
    
    private circle[] circles;
    public void render(circle[] circles){
        this.circles=circles;
        repaint();//清空画布再绘制
    }

    private class AlgoCanvas extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            //通常叫做绘制的上下文环境
            super.paintComponent(g);

            Graphics2D g2d=(Graphics2D)g;
            //抗锯齿
            RenderingHints hints=new RenderingHints( RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.addRenderingHints(hints);
            //具体绘制
            //线宽
            // AlgoHelper.setStrokeWidth(g2d, 5);

            // AlgoHelper.setColor(g2d, Color.blue);
            // AlgoHelper.fillCircle(g2d, canvasWidth/2, canvasHight/2, 200);
            // //线颜色
            // AlgoHelper.setColor(g2d, Color.red);
            // //实心g2d.fill();
            // AlgoHelper.strokeCircle(g2d, canvasWidth/2, canvasHight/2, 200);
            AlgoHelper.setStrokeWidth(g2d, 1);
            AlgoHelper.setColor(g2d, Color.red);
            for(circle circle:circles){
                AlgoHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());
            }

        }
        @Override
        public Dimension getPreferredSize(){
            return new Dimension(canvasWidth,canvasHight);
        }
    }
}