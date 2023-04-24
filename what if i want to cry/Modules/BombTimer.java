package Modules;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.text.*;

public class BombTimer extends JPanel implements ModuleTemplate {
    private JLabel countdownTimerLabel; 
    private Timer countdownTimer; 
    private int minutesLeft; 
    private int secondsLeft;
    private DecimalFormat decimalFormat; 
    private String doubleMinute; 
    private String doubleSecond; 


    public BombTimer() {
        countdownTimerLabel = new JLabel();
        countdownTimerLabel.setBounds(300, 230, 200, 100);
        countdownTimerLabel.setHorizontalAlignment(JLabel.CENTER);
        countdownTimerLabel.setFont(new Font("Times New Roman", Font.PLAIN, 50));
        countdownTimerLabel.setForeground(Color.white);
        this.add(countdownTimerLabel);

        decimalFormat = new DecimalFormat("00");
        countdownTimerLabel.setText("5:00");
        minutesLeft = 5; 
        secondsLeft = 0; 
        createBombTimer();
        countdownTimer.start();
    }

    public void createBombTimer() {
        countdownTimer = new Timer(1000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent ae) {
                secondsLeft--; 
                doubleMinute = decimalFormat.format(minutesLeft);
                doubleSecond = decimalFormat.format(secondsLeft);
                countdownTimerLabel.setText(doubleMinute + ":" + doubleSecond);

                if(secondsLeft == -1) {
                    secondsLeft = 59; 
                    minutesLeft--; 
                    doubleMinute = decimalFormat.format(minutesLeft);
                    doubleSecond = decimalFormat.format(secondsLeft);
                    countdownTimerLabel.setText(doubleMinute + ":" + doubleSecond);
                }

                if(minutesLeft == 0 && secondsLeft == 0) {
                    // bombExplodes();
                    countdownTimer.stop();
                }
            }
        });
    }

    public void draw(Graphics2D g2d) {
        //Rectangle2D.Double timerBackground = new Rectangle2D.Double(ALLBITS, ABORT, WIDTH, HEIGHT);
        //Rectangle2D.Double strikesCounter
        //Rectangle2D.Double timerHolder
        //Ellipse2D.Double CircleDesign 
    }

}