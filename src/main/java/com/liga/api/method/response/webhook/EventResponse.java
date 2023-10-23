package com.liga.api.method.response.webhook;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventResponse {
    /**监听事件编号*/
   private Long eventId;

    /**类型名称*/
    private String typeName;

    /**类型编码 */
    private String typeCode;

    /**事件名称*/
    private String eventName;

    /**事件编码 */
    private String eventCode;
}
