package com.liga.api.method.response.version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OptionalOwnerListResponse {

    /**
     * 用户编号
     */
    private Long id;

    /**
     * 用户名称
     */
    private String name;

    /**
     * 账户头像
     */
    private String avatar;
}
