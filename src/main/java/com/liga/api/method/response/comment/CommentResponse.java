package com.liga.api.method.response.comment;

import com.liga.api.method.request.comment.CommentAddRequest;
import com.liga.api.method.response.file.FileResponse;
import com.liga.api.method.response.user.UserSimpleVO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {

    /**评论id*/
    private Long commentId;

    /**评论内容*/
    private String content;

    /**评论内容（纯文本）*/
    private String plainContent;

    /**评论的其他属性信息*/
    private CommentAttributes commentAttributes;

    /**评论用户信息*/
    private UserSimpleVO commentUser;

    /**评论创建时间*/
    private Date createTime;

    /**评论更新时间*/
    private Date updateTime;

    /**删除标志, 1 删除, 0 未删除*/
    private Byte deleteFlag;

    /**评论数量*/
    private Integer commentNo;

    /**子分页回复列表*/
    private List<ApiReplyVO> subReplies;

    /**表情列表*/
    private List<ApiStickerVO> stickerVOList;

    /**文件列表*/
    private List<FileResponse> files;

    /**创建人id*/
    private Long createBy;

    @Data
    public static class CommentAttributes {
        /**
         * @人员信息
         */
        private List<CommentAddRequest.CommentAtInfo> commentAtInfos;
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
