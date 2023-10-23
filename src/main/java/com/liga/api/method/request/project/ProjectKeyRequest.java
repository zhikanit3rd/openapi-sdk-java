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
public class ProjectKeyRequest implements LigaApiRequest {

    /**
     * 项目id
     */
    @NonNull
    private String projectKey;
    private String token;
}
