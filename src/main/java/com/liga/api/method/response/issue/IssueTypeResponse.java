package com.liga.api.method.response.issue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueTypeResponse {


    /**
     * 问题类型编号
     */
    private Long id;

    /**
     * 问题类型名称
     */
    private String name;

    /**
     * 问题类型编码
     */
    private String code;

    /**
     * 工作流编号
     */
    private Long workflowId;
}
