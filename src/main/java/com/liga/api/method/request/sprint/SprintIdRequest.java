package com.liga.api.method.request.sprint;

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
public class SprintIdRequest implements LigaApiRequest {

    private String token;

    /** 迭代主键编号 */
    @NonNull
    private Long sprintId;
}
