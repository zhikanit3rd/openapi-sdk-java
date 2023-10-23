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
public class IssueLabourRecordRequest implements LigaApiRequest {

    private String token;

    /** 工时登记id */
    @NonNull
    private Long id;

    /**工时 */
    protected BigDecimal labour;

    /**工时登记时间 */
    protected Date recordTime;

    /**备注 */
    protected String remarks;
}
