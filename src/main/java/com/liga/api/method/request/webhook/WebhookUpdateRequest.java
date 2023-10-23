package com.liga.api.method.request.webhook;

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
public class WebhookUpdateRequest implements LigaApiRequest {
    private String token;
    
    @NonNull
    private Long webhookId;

    /**webhook名称*/
    private String name;

    /**回调地址 */
    private String url;

    /**webhook类型编码 */
    private String type;

    /**启用状态(enabled: 启用, disabled: 禁用) */
    private String state;

    /**令牌/加签*/
    private String signature;

    /**监听事项编号列表 */
    private List<Long> eventIds;
}
