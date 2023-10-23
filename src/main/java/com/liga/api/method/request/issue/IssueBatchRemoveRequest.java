package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueBatchRemoveRequest implements LigaApiRequest {

    private String token;

    /**项目id编号*/
    @NonNull
    protected Long projectId;

    /**
     * 主键编号
     */
    /**issue编号*/
    @NonNull
    private List<Long> issueIds;
}
