package org.yanglao;


import lombok.extern.log4j.Log4j;

import java.io.IOException;
import java.util.TimerTask;

//用于定时任务的类
@Log4j
public class TimerCheck extends TimerTask {

    private  CheckinTask checkinTask=new CheckinTask();

    @Override
    public void run() {
        try {
            checkinTask.Check();
        } catch (IOException e) {
            e.printStackTrace();
            log.info("try again!");
            System.out.println("try again!");
            CheckinTask tmp=new CheckinTask();
            try {
                tmp.Check();
            } catch (IOException ex) {
                log.info("try Failed!");
                System.out.println("try Failed!");
            }
        }
    }
}
