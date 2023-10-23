package com.liga.api.method.request.tag;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TagUpdateRequest implements LigaApiRequest {

    private String token;

    /**主键*/
    @NonNull
    private Long id;

    /**标签名(长度需在1~20之间)*/
    @NonNull
    private String tagName;

}
