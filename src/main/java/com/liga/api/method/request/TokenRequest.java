package com.liga.api.method.request;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Ferry
 * @create: 2023/10/19
 * @description:
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TokenRequest implements LigaApiRequest {

    private String token;
}
