package com.liga.api.method.request.comment;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentAddRequest implements LigaApiRequest {
    private String token;

    /**评论模块 */
    @NonNull
    private String commentModule;

    /**关联id */
    @NonNull
    private Long linkId;

    /**回复评论id */
    private Long commentId;

    /**评论内容 */
    @NonNull
    private String content;

    /**评论内容（纯文本）*/
    private String plainContent;

    /**评论的其他属性信息*/
    private CommentAttributes commentAttributes;

    @Data
    public static class CommentAttributes {
        /**
         * @人员信息
         */
        private List<CommentAtInfo> commentAtInfos;
    }

    @Data
    public static class CommentAtInfo {
        /**用户id*/
        private Long userId;
        /**用户姓名*/
        private String userName;
        /**@信息的开始位置*/
        private Integer startPosition;
        /**@信息的结束位置*/
        private Integer endPosition;
    }
}
