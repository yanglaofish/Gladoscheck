import org.junit.Test;
import org.yanglao.CheckinTask;
import org.yanglao.TimerCheck;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class TestCheck {
    @Test
    public void testCheck() {
        TimerTask GladosCheck=new TimerCheck();
        Timer timer = new Timer();
        timer.schedule(GladosCheck,0, 5000);

    }

}
