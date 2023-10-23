package com.liga.api.method.request.user;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectUserListRequest implements LigaApiRequest {
    /**项目ID*/
    @NonNull
    private Long projectId;
    /**搜索关键字*/
    private String keyword;
    @NonNull
    private String token;
}