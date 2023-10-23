package com.liga.api.method.request.version;

import com.liga.api.method.request.Pageable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PageAssociateRequest implements Pageable {
  
    /** 版本id */
    @NonNull
    private Long releaseId;

    /**项目id*/
    private Long projectId;

    /**状态类别*/
    private Integer stateCategory;

    /**执行人id*/
    private Long assigneeId;
    private Integer pageNumber;
    private Integer pageSize;
    private String token;
}
