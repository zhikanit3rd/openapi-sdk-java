package com.liga.api.method.request.version;

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
public class ReleaseStatusUpdateRequest implements LigaApiRequest {
    private String token;

    /**版本id*/
    @NonNull
    private Long id;

    /**发布日期*/
    @NonNull
    private Date releasedDate;
}