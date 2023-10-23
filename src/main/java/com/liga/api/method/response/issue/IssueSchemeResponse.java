package com.liga.api.method.response.issue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueSchemeResponse {

    /** 问题类型id */
    private Long issueTypeId;

     /** 项目id */
    private Long projectId;

     /** 字段列表 */
    private List<CustomFieldResponse> fields;
}
