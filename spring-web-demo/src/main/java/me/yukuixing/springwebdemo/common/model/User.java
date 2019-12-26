package me.yukuixing.springwebdemo.common.model;

import lombok.Data;

/**
 * User
 *
 * @author: yukuixing
 * @since : 2019-11-24 17:40
 */
@Data
public class User {

    private long id;
    private int age;
    private String name;
    private String password;
}
