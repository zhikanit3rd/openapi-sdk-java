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
public class WebhookAddRequest implements LigaApiRequest {
    private String token;
    /**项目编号*/
    @NonNull
    private Long projectId;

    /**webhook名称*/
    @NonNull
    private String name;

    /**回调地址  */
    @NonNull
    private String url;

    /**webhook类型编码  */
    @NonNull
    private String type;

    /**启用状态(enabled: 启用, disabled: 禁用)，默认为禁用状态 */
    private String state = "disabled";

    /**令牌/加签*/
    private String signature;

    /**监听事项编号列表 */
    private List<Long> eventIds;
}
