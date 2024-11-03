package org.yanglao;


import java.io.IOException;
import java.util.TimerTask;

//用于定时任务的类
public class TimerCheck extends TimerTask {

    private  CheckinTask checkinTask=new CheckinTask();

    @Override
    public void run() {
        try {
            checkinTask.Check();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
