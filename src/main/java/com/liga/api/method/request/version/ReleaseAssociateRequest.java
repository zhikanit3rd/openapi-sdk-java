package com.liga.api.method.request.version;

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
public class ReleaseAssociateRequest implements LigaApiRequest {
    private String token;

    /** 版本id */
    @NonNull
    private Long releaseId;

    /** 事项id */
    @NonNull
    private Long issueId;
}
