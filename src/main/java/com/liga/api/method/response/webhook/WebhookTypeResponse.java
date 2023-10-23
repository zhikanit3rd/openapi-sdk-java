package com.liga.api.method.response.webhook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WebhookTypeResponse {
    /** webhook类型编码 */
    String code;

    /**webhook类型名称*/
    String name;
}
