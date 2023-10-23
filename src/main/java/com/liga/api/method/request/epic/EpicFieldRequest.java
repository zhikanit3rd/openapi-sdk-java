package com.liga.api.method.request.epic;

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
public class EpicFieldRequest implements LigaApiRequest {

    private String token;

    @NonNull
    private Long projectId;

    /** 字段编码 */
    @NonNull
    private String fieldCode;
}
