package me.yukuixing.springwebdemo.common.beans;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.context.ApplicationEvent;

/**
 * MyEvent
 *
 * @author: yukuixing
 * @since : 2019-11-17 22:21
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class MyEvent extends ApplicationEvent {

    private int times;

    public MyEvent(String source, int times) {
        super(source);
        this.times = times;
    }
}
