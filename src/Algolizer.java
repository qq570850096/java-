import java.awt.*;
public class Algolizer{
    private circle[] circles;
    private maze frame;

    public Algolizer(int sceneWidth,int sceneHeigth,int N){
        //初始化数据
        circles=new circle[N];
        int r=50;
        for(int i=0;i<N;i++){
        int x=(int)Math.random()*(sceneWidth-2*r);
        int y=(int)Math.random()*(sceneHeigth-2*r);
        int vx=(int)(Math.random()*11)-5;
        int vy=(int)(Math.random()*11)-5;
        circles[i]=new circle(x, y, r, vx, vy);
        }

        //初始化视图
        //事件派发队列太长使得不能相应操作,动画序列放在其他线程中
        EventQueue.invokeLater(()->{
            frame=new maze("welcome!",sceneWidth,sceneHeigth);
            new Thread(()->{
               run();
            }).start();
        });    
    }

    //动画逻辑
    private void run(){
        while(true){
            //绘制数据
            frame.render(circles);
            AlgoHelper.pause(20);
            //更新数据
            for(circle cir:circles){
                cir.move(0,0,frame.getCanvasWidth(),frame.getCanvasHight());
            }   
        }
    }
}