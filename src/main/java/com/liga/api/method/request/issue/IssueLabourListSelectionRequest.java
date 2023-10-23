package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueLabourListSelectionRequest implements LigaApiRequest {

    private String token;
    
    /**项目id*/
    @NonNull
    private Long projectId;

    /**事项id*/
    private Long issueId;

    /**登记的开始时间*/
    private Date startDate;

    /**登记的截止时间*/
    private Date endDate;

    /**登记人*/
    private Long createBy;

}
