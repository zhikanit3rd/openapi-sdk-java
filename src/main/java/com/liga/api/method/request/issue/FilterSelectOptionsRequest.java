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
public class FilterSelectOptionsRequest implements LigaApiRequest {

    private String token;

    @NonNull
    private Long projectId;

    /**筛选字段id列表不能为空*/
    @NonNull
    private List<Long> customFiledIds;
}
