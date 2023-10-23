package com.liga.api.method.request.project;

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
public class ProjectIdRequest implements LigaApiRequest {

    /**
     * 项目id
     */
    @NonNull
    private Long projectId;
    private String token;
}
