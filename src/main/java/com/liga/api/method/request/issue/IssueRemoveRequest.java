package com.liga.api.method.request.issue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueRemoveRequest {
    /**
     * 主键编号
     */
    @NonNull
    private Long id;

    /**
     * 事项添加渠道标识，默认为：open_api
     */
    protected String channel;
}
