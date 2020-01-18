package me.yukuixing.dubbo.model;

import java.io.Serializable;
import lombok.Data;

/**
 * UserInfo
 *
 * @author: yukuixing
 * @since : 2020-01-17 17:28
 */
@Data
public class UserInfo implements Serializable {
    private static final long serialVersionUID = 7872225705577560403L;

    private long id;
    private String userName;
    private String mobile;
}
