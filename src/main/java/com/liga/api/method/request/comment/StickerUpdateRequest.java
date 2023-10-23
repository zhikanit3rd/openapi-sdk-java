package com.liga.api.method.request.comment;

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
public class StickerUpdateRequest implements LigaApiRequest {
    private String token;

    /**关联模块 */
    private String linkModule;

    /**关联实体, comment */
    private String linkEntity;

    /**关联实体id */
    @NonNull
    private Long linkId;

    /**表情编码*/
    @NonNull
    private String stickerCode;

    /**删除标识;是否(1/0)*/
    @NonNull
    private Byte deleteFlag;

    /**问题主键*/
    @NonNull
    private Long issueId;

}
