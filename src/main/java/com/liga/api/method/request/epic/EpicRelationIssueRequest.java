package com.liga.api.method.request.epic;

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
public class EpicRelationIssueRequest implements LigaApiRequest {

    private String token;

    /**
     * 史诗ID
     */
    @NonNull
    private Long epicId;

    /**
     * 关联事项ID列表
     */
    @NonNull
    private List<Long> issueIds;
}
