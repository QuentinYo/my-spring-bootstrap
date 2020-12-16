package me.yukuixing.dubbo.dto;

import java.io.Serializable;
import lombok.Data;

/**
 * UserInfoDto
 *
 * @author: yukuixing
 * @since : 2020-01-17 17:06
 */
@Data
public class UserInfoDto implements Serializable {

    private static final long serialVersionUID = 6477721673115349267L;

    private long id;
    private String userName;
    private int age;
    private long createTime;
}
