package com.liga.api.method.response.authorize;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Ferry
 * @create: 2023/9/5
 * @description:
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RefreshTokenResponse {

    /**
     * 旧accessToken
     */
    private String refreshToken;

    /**
     * 过期时间（单位：秒),-1代表用不过期
     */
    protected Integer expireIn;

    /**
     *  访问凭证
     */
    protected String accessToken;
}
