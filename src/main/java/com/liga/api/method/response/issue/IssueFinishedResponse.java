package com.liga.api.method.response.issue;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueFinishedResponse {
    /**事项id*/
    private Long id;

    /**概要*/
    private String summary;

    /**项目id*/
    private Long projectId;

    /**项目名称*/
    private String projectName;

    /**事项类型id*/
    private Long issueTypeId;

    /**事项类型名称*/
    private String issueTypeName;

    /**状态id*/
    private Long statusId;

    /**状态名称*/
    private String statusName;

    /**执行人id*/
    private Long assigneeId;

    /**执行人名称*/
    private String assigneeName;

    /**优先级id*/
    private Long priorityId;

    /**优先级名称*/
    private String priorityName;

    /**issue编号*/
    private String issueNumber;

    /**迭代id*/
    private Long sprintId;

    /**迭代名称*/
    private String sprintName;

    /**点数*/
    private BigDecimal estimatePoint;

    /**预估工时*/
    private BigDecimal estimateManHour;

    /**实际工时*/
    private BigDecimal actualLabour;

    /**剩余工时*/
    private BigDecimal remainingLabour;

    /**完成时间*/
    private Date finishTime;

    /**开始时间*/
    private Date startDate;

    /**截止时间*/
    private Date dueDate;

    /**父issue id*/
    private Long parentId;

    /**父issue概要*/
    private String parentSummary;

    /**父issue 事项类型id*/
    private Long parentIssueTypeId;

    /**父issue 事项类型名称*/
    private String parentIssueTypeName;

    /**父issue编号*/
    private String parentIssueNumber;
}
