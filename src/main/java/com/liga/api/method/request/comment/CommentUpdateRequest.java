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
public class CommentUpdateRequest implements LigaApiRequest {
    private String token;


    @NonNull
    private Long commentId;

    @NonNull
    private String content;

    /** 评论内容（纯文本）*/
    private String plainContent;
}
