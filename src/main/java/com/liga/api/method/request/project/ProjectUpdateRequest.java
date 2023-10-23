package com.liga.api.method.request.project;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectUpdateRequest implements LigaApiRequest {

    /** 项目编号 */
    @NonNull
    private Long id;
    /** 项目概览字段集合 */
    protected Map<String, Object> data;
    private String token;
}