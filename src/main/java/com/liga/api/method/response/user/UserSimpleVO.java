package com.liga.api.method.response.user;

import lombok.Data;

@Data

public class UserSimpleVO {
    /**用户id*/
    private Long userId;

    /**用户名*/
    private String userName;

    /**用户头像*/
    private String profilePicture;

    /**账户是否启用(0:否,1:是)*/
    private Byte accountEnabled;
}
