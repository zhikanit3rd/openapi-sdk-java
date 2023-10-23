package com.liga.api.method.response.workflow;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WorkflowResponse {

    /**工作流主键*/
    private Long id;

    /**工作流名称*/
    private String workflowName;

    /**工作流描述*/
    private String workflowDesc;

    /**是否默认工作流*/
    private Boolean defaultValue;

    /**状态列表*/
    private List<StateAssociateResponse> states;

    /**关联工作类型列表*/
    private List<WorkflowIssueTypeVO> issueTypes;

    @Data
    public static class  WorkflowIssueTypeVO{
        /**工作类型编号*/
        private Long id;

        /**工作类型名称*/
        private String name;

        /**工作类型编码*/
        private String code;

        /**工作类型描述*/
        private String description;
    }
}
