package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueAddRequest implements LigaApiRequest {

    private String token;

    /**项目id编号*/
    @NonNull
    private Long projectId;

    /**issueTypeId编号*/
    @NonNull
    private Long issueTypeId;

    /**
     * 问题字段
     */
    @NonNull
    private Map<String, Object> data;
}
