package com.liga.api.method.request.authorize;

import com.liga.api.method.LigaApiRequest;
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
public class AccessTokenRequest implements LigaApiRequest {

    protected String clientId;
    protected String secretKey;

    @Override
    public String getToken() {
        return null;
    }
}
