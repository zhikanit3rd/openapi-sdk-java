package com.liga.api.method.request.issue;

import com.liga.api.method.LigaApiRequest;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.List;
import java.util.Map;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IssueBatchUpdateRequest implements LigaApiRequest {

    private String token;

    /**issue编号*/
    @NonNull
    private List<Long> issueIds;

    /**项目id编号*/
    @NonNull
    protected Long projectId;

    /**issue类型编号*/
    @NonNull
    protected Long issueTypeId;

    /**数据集合*/
    @NonNull
    private Map<String, Object> data;
}
