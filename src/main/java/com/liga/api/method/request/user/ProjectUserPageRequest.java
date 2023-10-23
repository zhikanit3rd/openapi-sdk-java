package com.liga.api.method.request.user;

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
public class ProjectUserPageRequest implements Pageable {
    
    /**项目ID*/
    @NonNull
    private Long projectId;
    /**搜索关键字*/
    private String keyword;
    private Integer pageNumber;
    private Integer pageSize;
    @NonNull
    private String token;
}