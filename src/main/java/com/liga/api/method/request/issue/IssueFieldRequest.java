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
public class IssueFieldRequest implements LigaApiRequest {

    private String token;

    /**issue类型id*/
    @NonNull
    private Long issueTypeId;

    /**项目id*/
    @NonNull
    private Long projectId;

    /**字段编码*/
    @NonNull
    private String fieldCode;
}
