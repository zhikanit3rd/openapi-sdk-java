package com.liga.api.method.request.issue;

import com.liga.api.method.request.Pageable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueFinishedRequest implements Pageable {
    
    /**项目id列表*/
    private Set<Long> projectIds;

    /**迭代id列表*/
    private Set<Long> sprintIds;

    /**执行人id列表*/
    private Set<Long> assigneeIds;

    /**完成时间早于*/
    private Date before;

    /**完成时间晚于*/
    private Date after;
    private Integer pageNumber;
    private Integer pageSize;
    private String token;
}
