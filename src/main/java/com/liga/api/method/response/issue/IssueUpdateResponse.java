package com.liga.api.method.response.issue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueUpdateResponse {

    /**是否成功*/
    private Boolean success;

    /**issue id*/
    private Long issueId;

    /**失败理由*/
    private String failureReason;
}
