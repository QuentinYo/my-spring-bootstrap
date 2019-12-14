package me.yukuixing.springwebdemo.eventlistener;

import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import me.yukuixing.springwebdemo.common.beans.MyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * EventListener
 *
 * @author: yukuixing
 * @since : 2019-11-17 22:13
 */
@Slf4j
@Component
public class MyEventListener {

    @Async("backgroundTaskExecutor")
    @EventListener
    public void onEvent(MyEvent myEvent) {
        System.out.println("rcv event. s=" + myEvent.getSource());
        try {
            TimeUnit.MILLISECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("event done. s=" + myEvent.getSource());
    }
}
