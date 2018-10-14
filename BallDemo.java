import java.awt.Color;
import java.util.Random;
import java.lang.Math;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Bill Crosbie
 * @version 2015-March-BB
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 * 
 * @author Austin Raymond - Diameter Extra Credit
 * @version 2018.10.14
 */

public class BallDemo   
{
    private Canvas myCanvas;
    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        Random rand = new Random();
        
        int ground = 400;   // position of the ground line
        int balls = 30; // generating the amount of balls
        BouncingBall[] ballz = new BouncingBall [balls]; //Making array for balls
        int counter = 0; //counters for loops
        int counter2 = 0;

        myCanvas.setVisible(true);

        // draw the ground and walls
        myCanvas.drawLine(50, ground, 550, ground);
        myCanvas.drawLine(50, ground, 50, ground-400);
        myCanvas.drawLine(550, ground, 550, ground-400);
        myCanvas.drawLine(50, ground-400 , 550, ground-400);

        // crate and show the balls
        for(counter = 0; counter < ballz.length; ++counter){
            int top = ground - 400;
            int diameter = rand.nextInt((25 - 10) +1) + 10; //code giving random diamaeters, can be seen in debug
            int ranX = rand.nextInt((500 - 71) +1) + 71;
            int ranY = rand.nextInt(370);
            //int ranY = rad*-1;
            int r = rand.nextInt(200);
            int g = rand.nextInt(200);
            int b = rand.nextInt(200);
            Color color = new Color (r,g,b);
            BouncingBall ball = new BouncingBall(ranX,ranY,20,color,ground, myCanvas);
            ballz[counter] = ball;
            ballz[counter].draw();
        }
        
        // make them bounce
        boolean finished =  false;
        while(!finished) {
                       // small delay
            for(counter2 = 0; counter2 < ballz.length;++counter2){
                myCanvas.wait(1);
                ballz[counter2].move();
            }
            // stop once ball has travelled a certain distance on x axis
        }
    }
}