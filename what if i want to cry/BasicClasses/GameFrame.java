package BasicClasses;

import java.awt.*;
import javax.swing.*;

public class GameFrame {
    private int width; 
    private int height; 
    private JFrame gameFrame; 
    private GameCanvas gameCanvas; 
    private boolean timetoChangeState; 

    public GameFrame(int w, int h) {
        width = w; 
        height = h; 
        gameFrame = new JFrame();
        gameCanvas = new GameCanvas(width, height);
    }

    public void setUpGUI() {
        Container cp = gameFrame.getContentPane();
        cp.add(gameCanvas, BorderLayout.CENTER);

        gameFrame.setTitle("No Human Being Detonates");
        gameCanvas.setPreferredSize(new Dimension(width, height));
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.pack();
        gameFrame.setVisible(true);
        
    }

    public void setUpModules() {  
        
        // Determine how to get currentCanvasState without it becoming an infinte loop 
        // Need it not to be an infinite loop so that we can add the modules into GameFrame 
            // we're planning on extending JPanel on all our other module components 
                // module componenets are our composite shape classes 


        while(true) {
            timetoChangeState = false; 
            int currentCanvasState = gameCanvas.getCurrentState();
            if(currentCanvasState == gameCanvas.titleState) {
                System.out.println("He like how i ride it");
            } 
            
            if(currentCanvasState == gameCanvas.howPlayState) {
                System.out.println("Hop on the dick, I made him get excited");
            }
        }       
    }

    public void changeCurrentState() {
        if(timetoChangeState == true) {
            gameCanvas.getCurrentState();
        }
    }

}   
