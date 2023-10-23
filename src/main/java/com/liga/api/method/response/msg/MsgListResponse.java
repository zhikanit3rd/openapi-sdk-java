package com.liga.api.method.response.msg;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author: Ferry
 * @create: 2023/10/16
 * @description:
 **/

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MsgListResponse {
    /**消息id*/
    private Long msgId;
    /**消息主题*/
    private String subject;
    /**触发动作", example = "at*/
    private String action;
    /**该action的触发人名字*/
    private String triggerName;
    /**action的接受名,或是人名，或是状态名，或是优先级名*/
    private String receiverName;
    /**纯文本*/
    private String plainReceiverName;
    /**创建时间*/
    private Date createTime;
    /**内容*/
    private String content;
    /**被指派人的user_id*/
    private Long receiverId;
    /**是否已读  1 已读  0未读*/
    private Byte hasRead;
    /**接受通知主键id,用于设置消息已读*/
    private Long reminderReceiveId;
}