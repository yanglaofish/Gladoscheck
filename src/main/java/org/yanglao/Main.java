package org.yanglao;


import java.util.Timer;
import java.util.TimerTask;

public class Main {
    public static void main(String[] args) {
        TimerTask GladosCheck=new TimerCheck();
        Timer timer = new Timer();
        timer.schedule(GladosCheck,0, 3000);
        //GladosCheck.run();

    }
}
