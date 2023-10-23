package com.liga.api.method.request.issue;

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
public class UpdateSubtaskStatusRequest implements LigaApiRequest {

    private String token;

    /**问题主键*/
    @NonNull
    private Long id;

    /**问题所属项目id*/
    @NonNull
    private Long projectId;

    /**是否完成*/
    @NonNull
    private Boolean done;
}
