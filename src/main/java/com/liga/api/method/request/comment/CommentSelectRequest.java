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
public class CommentSelectRequest implements LigaApiRequest {

    /**
     * 评论关联模块,issue
     */
    private String commentModule;

    /**
     * 关联id
     */
    @NonNull
    private Long linkId;
    private String token;
}
