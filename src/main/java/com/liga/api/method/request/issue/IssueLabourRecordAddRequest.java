package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueLabourRecordAddRequest implements LigaApiRequest {

    private String token;

    /**issue id*/
    @NonNull
    private Long issueId;

    /**工时*/
    @NonNull
    private BigDecimal labour;

    /**工时登记时间*/
    @NonNull
    private Date recordTime;

    /**备注*/
    @NonNull
    private String remarks;
}
