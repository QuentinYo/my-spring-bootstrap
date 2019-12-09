package me.yukuixing.springwebdemo.controllers;

import lombok.extern.slf4j.Slf4j;
import me.yukuixing.springwebdemo.common.beans.MyEvent;
import me.yukuixing.springwebdemo.common.beans.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author: yukuixing
 * @since : 2019-11-17 22:16
 */
@Slf4j
@RestController
public class HelloController {

  @Autowired private ApplicationEventPublisher publisher;
  @Autowired private User user;

  @RequestMapping(value = "hello", method = RequestMethod.GET)
  public Object hello() {
    for (int i = 0; i < 10; i++) {
      System.out.println("sending, i=" + i);
      publisher.publishEvent(new MyEvent(String.valueOf(i), 1));
    }
    System.out.println("xxxxx======" + user);

    return "hello, world!";
  }
}
