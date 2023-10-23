package com.liga.api.method.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SuccessResponse {
    private Boolean success;
}
