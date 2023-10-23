package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueSubTaskRemoveRequest implements LigaApiRequest {

    /**
     * 问题编号
     */
    @NonNull
    private Long issueId;

    /**
     * 子任务编号
     */
    @NonNull
    private Long subTaskId;
    private String token;
}
