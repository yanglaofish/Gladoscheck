package org.yanglao;


import lombok.extern.log4j.Log4j;

import java.util.Timer;
import java.util.TimerTask;
public class Main {
    public static void main(String[] args) {
        TimerTask GladosCheck=new TimerCheck();
        Timer timer = new Timer();
        timer.schedule(GladosCheck,0, 3000*60*60*24);
        //GladosCheck.run();

    }
}
