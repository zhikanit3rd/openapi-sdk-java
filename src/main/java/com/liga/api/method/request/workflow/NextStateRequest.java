package com.liga.api.method.request.workflow;

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
public class NextStateRequest implements LigaApiRequest {

    private String token;

    /**当前状态主键编号*/
    @NonNull
    private Long stateId;

    /**工作流主键编号*/
    @NonNull
    private Long defId;
}
