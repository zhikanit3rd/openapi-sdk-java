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
public class IssueLabourRecordDetailResponse {
    
    /**登记id*/
    private Long id;

    /**
     * 工时，以h为单位
     */
    /**工时，以h为单位*/
    private BigDecimal labour;

    /**
     * 登记时间
     */
    /**登记时间*/
    private Date recordTime;

    /**
     * 备注
     */
    /**备注*/
    private String remarks;


    /**登记人id*/
    private Long createBy;

    /**登记人id*/
    private Long issueId;
}
