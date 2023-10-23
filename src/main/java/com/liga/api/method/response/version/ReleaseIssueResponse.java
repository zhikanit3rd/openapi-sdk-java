package com.liga.api.method.response.version;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReleaseIssueResponse {

    /**事项id*/
    private Long id;

    /**概要*/
    private String summary;

    /**项目id*/
    private Long projectId;

    /**项目名称*/
    private String projectName;

    /**状态名称*/
    private String statusName;

    /**状态id*/
    private Long statusId;

    /**执行人*/
    private String assigneeName;

    /**执行人id*/
    private Long assigneeId;

    /**事项类型名称*/
    private String issueTypeName;

    /**事项类型id*/
    private Long issueTypeId;

    /**优先级名称*/
    private String priorityName;

    /**优先级编号*/
    private Long priorityId;

    /**截止时间*/
    private Date dueDate;


    /**创建时间*/
    private Date createTime;

    /**更新时间*/
    private Date updateTime;

}
