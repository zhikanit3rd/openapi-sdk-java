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
public class TagAddRequest implements LigaApiRequest {

    private String token;

    /** 项目编号 */
    @NonNull
    private Long projectId;

    /** 标签名 */
    @NonNull
    private String tagName;
}
