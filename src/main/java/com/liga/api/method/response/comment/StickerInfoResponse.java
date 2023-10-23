package com.liga.api.method.response.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class StickerInfoResponse {

    /**
     * 表情编码
     */
    private String stickerCode;
    /**
     * 表情名称
     */
    private String stickerDesc;


}
