package com.liga.api.method.request.issue;


import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueUpdateRequest implements LigaApiRequest {

    private String token;

    /**
     * 问题字段
     */
    @NotNull
    protected Map<String, Object> data;

    /**
     * 主键编号
     */
    @NotNull
    private Long id;
}
