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
public class IssueSubTaskResponse {

    /**子任务主键编号*/
    private Long id;

    /**子任务编号*/
    private Long issueNumber;

    /**问题概要*/
    private String summary;

    /**到期日期*/
    private Date dueDate;

    /**开始日期*/
    private Date startDate;

    /**是否完成*/
    private Boolean done;

    /**执行人名称*/
    private String assigneeName;

    /**执行人id*/
    private Long assigneeId;

    /**点数*/
    private BigDecimal estimatePoint;

    /**预估工时*/
    private Double estimateLabour;

    /**实际工时*/
    private Double actualLabour;

    /**剩余工时*/
    private Double remainingLabour;

    /**创建时间*/
    private Date createTime;
}
