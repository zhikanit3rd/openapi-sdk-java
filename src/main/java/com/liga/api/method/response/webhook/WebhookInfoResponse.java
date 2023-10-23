package com.liga.api.method.response.webhook;

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
public class WebhookInfoResponse {
    /**webhook编号*/
    private Long webhookId;

    /**项目编号*/
    private Long projectId;

    /**webhook名称*/
    private String name;

    /**回调地址 */
    private String url;

    /**webhook类型 */
    private String type;

    /**启用状态(enabled: 启用, disabled: 禁用) */
    private String state;

    /**令牌/加签*/
    private String signature;

    /**事件监听列表 */
    private List<EventResponse> events;

    /**创建人*/
    private Long createBy;

    /**创建时间*/
    private Date createTime;
}
