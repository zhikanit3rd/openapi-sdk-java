package com.liga.api.method.response.issue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueRelationshipResponse {
    
    /**问题id*/
    private Long issueId;

    /**
     * 关联类型
     */
    private String type;

    /**问题概要*/
    private String summary;

    /**
     * 项目信息
     */
    private Long projectId;
}
