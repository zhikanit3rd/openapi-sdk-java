package com.liga.api.method.response.tag;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagResponse {

    /**主键*/
    private Long id;

    /**标签名*/
    private String tagName;
}
