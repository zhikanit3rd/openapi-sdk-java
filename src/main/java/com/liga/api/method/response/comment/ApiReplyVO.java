package com.liga.api.method.response.comment;

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
public class ApiReplyVO {
    
    /**项目id*/
    private Long projectId;

    /**关联id*/
    private Long linkId;

    /**组id，一级评论id*/
    private Long groupId;

    /**回复id（父id）*/
    private Long replyId;

    /**回复用户信息*/
    private UserSimpleVO replyUser;

    /**评论id*/
    private Long commentId;

    /**评论内容*/
    private String content;

    /**评论内容（纯文本）*/
    private String plainContent;

    /**评论的其他属性信息*/
    private CommentResponse.CommentAttributes commentAttributes;

    /**评论用户信息*/
    private UserSimpleVO commentUser;

    /**评论创建时间*/
    private Date createTime;

    /**评论更新时间*/
    private Date updateTime;

    /**删除标志, 1 删除, 0 未删除*/
    private Byte deleteFlag;

    /**回复数量(回复本条评论的数量)*/
    private Integer replyNo;

    /**创建人id*/
    private transient Long createBy;

    /**关联的事项删除标志, 1 删除, 0 未删除*/
    private Byte linkedIssueDeleteFlag = 0;

    /**表情列表*/
    private List<ApiStickerVO> stickerVOList;

    /**文件列表*/
    private List<FileResponse> files;
}
